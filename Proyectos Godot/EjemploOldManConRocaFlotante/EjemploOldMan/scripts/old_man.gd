extends CharacterBody2D

const SPEED = 200
const JUMP_SPEED = -600

var dentro_del_area = false

func _ready():
	$AnimatedSprite2D.sprite_frames.set_animation_loop_mode("die", SpriteFrames.LoopMode.LOOP_NONE)

func _physics_process(delta: float) -> void:
	if not is_on_floor():
		velocity = velocity + get_gravity() * delta

	if dentro_del_area == true:
		velocity.x = 0
	elif Input.is_action_pressed("izqda"):
		velocity.x = -SPEED
	elif Input.is_action_pressed("der"):
		velocity.x = SPEED
	else:
		velocity.x = 0
		
	if is_on_floor() and Input.is_action_just_pressed("ui_up"):
		velocity.y = JUMP_SPEED
	
	move_and_slide()
	
func _process(delta):
	if velocity.x > 0:
		$AnimatedSprite2D.play("walk")
		$AnimatedSprite2D.flip_h = false
	elif velocity.x < 0:
		$AnimatedSprite2D.play("walk")
		$AnimatedSprite2D.flip_h = true
	elif dentro_del_area:
		$AnimatedSprite2D.play("die")
	else:
		$AnimatedSprite2D.play("idle")
		
func _on_area_muerte_body_entered(body: Node2D) -> void:
	if body.name == "OldMan":
		dentro_del_area = true


func _on_area_muerte_body_exited(body: Node2D) -> void:
	print("SALISTE DE LA MUERTE")
	dentro_del_area = false


func _on_animated_sprite_2d_animation_finished() -> void:
	if $AnimatedSprite2D.animation == "die":
		print("VE AL PARQUE POR FAVOR")
		print("GRACIAS POR JUGAR")
		get_tree().quit()
