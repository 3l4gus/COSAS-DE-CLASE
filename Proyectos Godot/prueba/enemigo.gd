extends CharacterBody2D

const SPEED = 100.0
var velocidad_actual = SPEED

@onready var animated_sprite: AnimatedSprite2D = $AnimatedSprite2D

func _ready() -> void:
	animated_sprite.play("walk")

func _physics_process(delta: float) -> void:
	if not is_on_floor():
		velocity += get_gravity() * delta
	
	if $RayCastDerecha2D.is_colliding():
		velocidad_actual = -SPEED
		
	if $RayCastIzquierda2D.is_colliding():
		velocidad_actual = SPEED
	
	if not $RayCastSueloIzquierda2D.is_colliding():
		velocidad_actual = SPEED
	
	if not $RayCastSueloDerecha2D.is_colliding():
		velocidad_actual = -SPEED
		
	if velocidad_actual < 0:
		animated_sprite.flip_h = true
	else:
		animated_sprite.flip_h = false
	
	velocity.x = velocidad_actual

	move_and_slide()

func _on_zona_daño_body_entered(body: Node2D) -> void:
	if body.is_in_group("Jugador"):
		body.morir()
