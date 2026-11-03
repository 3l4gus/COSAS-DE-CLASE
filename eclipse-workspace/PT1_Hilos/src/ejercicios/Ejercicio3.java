package ejercicios;

public class Ejercicio3 {
	public static void main(String[] args) {
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				
				// Cada hilo mostrará este mensaje
				System.out.println(Thread.currentThread().getName() + " tiene el estado: "
			+ Thread.currentThread().getState() + " y su id es: " + Thread.currentThread().getId());
				
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Roberto");
		empezarHilo(tarea, "Manolo");
		empezarHilo(tarea, "Pablo");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}

}
