package juegos;

public class Personaje implements Runnable{
	private String nombre;
	private String tipo;
	
	public Personaje(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("¡" + nombre + "entra en la sala " + (i + 1) + "!");
			System.out.println("¡" + nombre + "supera la sala " + (i + 1) + "!");
		}
	}
}
