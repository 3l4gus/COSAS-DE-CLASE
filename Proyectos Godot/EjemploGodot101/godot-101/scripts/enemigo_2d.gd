extends CharacterBody2D


const SPEED = 100.0
var velocidad_actual = SPEED

func _physics_process(delta: float) -> void:
	# Add the gravity.
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
	
	velocity.x = velocidad_actual

	move_and_slide()
