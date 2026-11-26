package juegos;

public class Vehiculo implements Runnable{
	
	// Atributos
	private String nombre;
	private double tiempo;
	
	// Constructor
	public Vehiculo(String nombre) {
		this.nombre = nombre;
	}

	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTiempo() {
		return tiempo / 1000;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	// Ejecutamos la tarea del hilo
	@Override
	public void run() {
		long tiempo = 0;
		System.out.println("\n" + nombre + " comienza su tramo.");
		
		// Recorremos 3 veces el for esperando el tiempo que indique el random que se hará en cada recorrido
		for (int i = 1; i < 4; i++) {
			System.out.println(nombre + " está completando la vuelta " + i);
			tiempo += calcularTiempo(500, 2000);
			System.out.println(nombre + " termina la vuelta " + i);
		}
		System.out.println("!" + nombre + " ha completado su tramo!");
		
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
