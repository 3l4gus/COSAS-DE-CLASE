extends CharacterBody2D


const SPEED = 300.0
const JUMP_VELOCITY = -1000.0

# HACK (WORKAROUND)
const ESCALADO_CUANDO_QUIETECITO = Vector2(0.9, 0.9)
const ESCALADO_CUANDO_PUÑETAZO = Vector2(1.1, 1.1)

var dando_puñetazo = false


func _physics_process(delta: float) -> void:
	# Add the gravity.
	if not is_on_floor():
		velocity += get_gravity() * delta

	# Handle jump.
	if Input.is_action_just_pressed("ui_accept") and is_on_floor():
		velocity.y = JUMP_VELOCITY

	# Get the input direction and handle the movement/deceleration.
	# As good practice, you should replace UI actions with custom gameplay actions.
	if Input.is_action_pressed("ui_left"):
		velocity.x = -SPEED
	elif Input.is_action_pressed("ui_right"):
		velocity.x = SPEED
	else:
		velocity.x = 0
	
	move_and_slide()

func _process(delta: float) -> void:
	if dando_puñetazo:
		$AnimatedSprite2D.play("puñito")
		$AnimatedSprite2D.scale = ESCALADO_CUANDO_PUÑETAZO
	elif Input.is_action_just_pressed("punch"):
		dando_puñetazo = true
	elif not is_on_floor():
		if velocity.y < 0:
			$AnimatedSprite2D.play("subiendo")
			$AnimatedSprite2D.flip_h = velocity.x < 0
			$AnimatedSprite2D.scale = Vector2(1, 1)
		else:
			$AnimatedSprite2D.play("cayendo")
			$AnimatedSprite2D.flip_h = velocity.x < 0
			$AnimatedSprite2D.scale = Vector2(1, 1)
	else:
		if velocity.x > 0:
			$AnimatedSprite2D.play("en_marcha")
			$AnimatedSprite2D.flip_h = false
			$AnimatedSprite2D.scale = Vector2(1, 1)
		elif velocity.x < 0:
			$AnimatedSprite2D.play("en_marcha")
			$AnimatedSprite2D.flip_h = true
			$AnimatedSprite2D.scale = Vector2(1, 1)
		else:
			$AnimatedSprite2D.play("quietecito")
			$AnimatedSprite2D.scale = ESCALADO_CUANDO_QUIETECITO

func _on_animated_sprite_2d_frame_changed() -> void:
	if $AnimatedSprite2D.animation == "puñito":
		
		if $AnimatedSprite2D.frame == 15:
			dando_puñetazo = false
