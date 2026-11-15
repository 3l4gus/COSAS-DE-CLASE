extends Node2D
var bala = preload("res://bala.tscn")

func _ready():
	$HTTPRequest.request("https://pmdm.fpcoruna.org/configuracion_juego.json")
func _on_timer_timeout() -> void:
	print("Ñoquis con pollo")
	var nuevaBala = bala.instantiate()
	add_child(nuevaBala)
	nuevaBala.position = $Enemigo.position 


func _on_http_request_request_completed(result: int, response_code: int, headers: PackedStringArray, body: PackedByteArray) -> void:
	var texto = body.get_string_from_utf8()
	var json = JSON.parse_string(texto)
	var balasMinuto = json["balas_por_minuto"]
	print(int(balasMinuto))
	$Timer.wait_time = 60 / balasMinuto
