extends Area2D

var vivo = true

@onready var animated_sprite: AnimatedSprite2D = $AnimatedSprite2D

func _ready() -> void:
	animated_sprite.play("idle")

func _on_body_entered(body: Node2D) -> void:
	if body.is_in_group("Jugador"):
		morirEnemigo()

func morirEnemigo() -> void:
	if not vivo:
		return
		
	vivo = false
	monitoring = false
	animated_sprite.play("dead")
	await animated_sprite.animation_finished


func _on_bola_body_entered(body: Node2D) -> void:
	if body.is_in_group("Jugador"):
		body.morir()
