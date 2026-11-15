extends StaticBody2D

var contador = 0

# Called when the node enters the scene tree for the first time.
func _ready() -> void:
	print("HOLA")
	
func _process(delta: float) -> void:
	var variable = "izqda"
	if Input.is_action_just_pressed(variable) == false:
		print("SE HA PULSADO IZQUIERDA")
		
	if Input.is_action_just_released("der"):
		print("SE HA PULSADO derecha")	
	
