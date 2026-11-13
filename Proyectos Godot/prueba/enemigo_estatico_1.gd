extends CharacterBody2D

const SPEED = 300.0
const JUMP_VELOCITY = -400.0

@onready var animated_sprite: AnimatedSprite2D = $AnimatedSprite2D
@onready var collision_ataque_der: CollisionShape2D = $Area2D/CollisionAtaqueDer
@onready var collision_ataque_izq: CollisionShape2D = $Area2D/CollisionAtaqueIzq

func _ready() -> void:
	animated_sprite.play("idle")
	collision_ataque_der.set_deferred("disabled", true)
	collision_ataque_izq.set_deferred("disabled", true)

func _physics_process(delta: float) -> void:
	if not is_on_floor():
		velocity += get_gravity() * delta
		
	if $RayCastDer.is_colliding():
		animated_sprite.play("attack")
		animated_sprite.flip_h = false
	elif $RayCastIzq.is_colliding():
		animated_sprite.play("attack")
		animated_sprite.flip_h = true
	else:
		animated_sprite.play("idle")
		
	move_and_slide()

func _on_area_2d_body_entered(body: Node2D) -> void:
	if body.is_in_group("Jugador"):
		body.morir()

func _on_animated_sprite_2d_frame_changed() -> void:
	if animated_sprite.animation != "attack":
		collision_ataque_der.set_deferred("disabled", true)
		collision_ataque_izq.set_deferred("disabled", true)
		return

	if animated_sprite.frame == 3:
		if animated_sprite.flip_h:
			collision_ataque_izq.set_deferred("disabled", false)
			collision_ataque_der.set_deferred("disabled", true)
		else:
			collision_ataque_der.set_deferred("disabled", false)
			collision_ataque_izq.set_deferred("disabled", true)
	else:
		collision_ataque_der.set_deferred("disabled", true)
		collision_ataque_izq.set_deferred("disabled", true)
