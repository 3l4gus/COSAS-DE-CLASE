extends CharacterBody2D

#Variables
const SPEED = 200.0
const JUMP_VELOCITY = -300.0
var cont = 3

@onready var animated_sprite: AnimatedSprite2D = $AnimatedSprite2D

# Para controlar cuándo estamos en animación de salto
var saltando := false 

func _physics_process(delta: float) -> void:
	# Aplicar gravedad si no estamos en el suelo si está reseteamos el contador
	if not is_on_floor():
		velocity += get_gravity() * delta
		saltando = true
	else:
		cont = 0
		saltando = false

	# Permitir hasta 3 saltos
	if Input.is_action_just_pressed("ui_accept") and cont < 3:
		velocity.y = JUMP_VELOCITY
		cont += 1
		saltando = true
		if animated_sprite.animation != "Jump":
			animated_sprite.play("Jump")
		else:
			animated_sprite.frame = 0

#Hacemos que el personaje se pueda mover hacia la izquierda y derecha
	var direction := Input.get_axis("ui_left", "ui_right")
	if direction:
		velocity.x = direction * SPEED
		if not saltando:
			animated_sprite.play("Walk")
		if direction < 0:
			animated_sprite.flip_h = true
		else:
			animated_sprite.flip_h = false
	else:
		velocity.x = move_toward(velocity.x, 0, SPEED)
		if not saltando:
			animated_sprite.play("Idle")

	move_and_slide()

func morir() -> void:
	get_tree().call_deferred("reload_current_scene")
