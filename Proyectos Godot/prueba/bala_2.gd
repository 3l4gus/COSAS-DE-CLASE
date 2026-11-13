extends StaticBody2D

const SPEED = 500

var posicion_inicial: Vector2

func _ready() -> void:
	posicion_inicial = global_position

func _physics_process(delta: float) -> void:
	global_position.x -= SPEED * delta

func _on_area_muerte_body_entered(body: Node2D) -> void:
	if body.is_in_group("Jugador"):
		body.morir()

func _on_fin_bala_area_entered(area: Area2D) -> void:
	if area == $AreaMuerte:
		set_deferred("global_position", posicion_inicial)
