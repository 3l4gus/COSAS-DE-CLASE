extends Timer
var bala = preload("res://balon.tscn")

func _on_timeout() -> void:
	print ("Han pasado 2 segundos.")
	var nuevaBala = bala.instantiate()
	nuevaBala.position = Vector2(0, 0)
	get_parent().add_child(nuevaBala)
