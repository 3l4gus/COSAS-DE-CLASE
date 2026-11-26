package juegos;

public class Personaje implements Runnable {
	
	// Atributos
	private String nombre;
	private String tipo;
	private long tiempo;

	// Constructor
	public Personaje(String nombre, String tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
	}

	//Getters y Setters
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

	public long getTiempo() {
		return tiempo;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	// Ejecutamos la tarea del hilo
	@Override
	public void run() {
		String hilo = Thread.currentThread().getName();
		long tiempo = 0;
		System.out.println("[" + hilo + "] " + nombre + " comienza la aventura.\n");
		
		// Recorremos 3 veces el for esperando el tiempo que indique el random que se hará en cada recorrido
		for (int i = 1; i < 6; i++) {
			System.out.println("[" + hilo + "] ¡" + nombre + " entra en la sala " + i + "!");
			
			// Dependiendo del tipo del personaje y de si la sala es par o impar, el mínimo y máximo del random cambiarán
			switch (tipo) {
			case "Mago":
				if (i % 2 == 0) {
					tiempo += calcularTiempo(1200, 1700);
				} else {
					tiempo += calcularTiempo(500, 1000);
				}
				break;
			case "Guerrero":
				if (i % 2 != 0) {
					tiempo += calcularTiempo(1200, 1700);
				} else {
					tiempo += calcularTiempo(500, 1000);
				}
				break;
			}
			System.out.println("[" + hilo + "] ¡" + nombre + " supera la sala " + i + "!");
		}
		System.out.println("[" + hilo + "] " + nombre + " ha conseguido llegar al tesoro.");
		
		// Guardamos el tiempo que ha transcurrido durante la tarea del hilo
		setTiempo(tiempo);
	}

	// Método para calcular un número random entre el mínimo y máximo que le pasemos por parámetro, devolverá el número
	public long calcularTiempo(int min, int max) {
		long tiempo = (long) (Math.random() * (max - min + 1)) + min;
		
		try {
			Thread.sleep(tiempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return tiempo;
	}
}
