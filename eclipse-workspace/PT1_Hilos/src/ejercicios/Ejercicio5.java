package ejercicios;

public class Ejercicio5 {
	public static void main(String[] args) {
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				
				// Dependiendo del indice mostrará un mensaje u otro
				for(int i = 1; i < 8; i++) {
					if(i == 1) {
						System.out.println(Thread.currentThread().getName() + " empieza la carrera!");
					}else if(i == 7) {
						System.out.println(Thread.currentThread().getName() + " ha terminado la carrera!");
					}else {
						System.out.println(Thread.currentThread().getName() + " - paso " + (i - 1));
					}
				}
				
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Robot 1");
		empezarHilo(tarea, "Robot 2");
		empezarHilo(tarea, "Robot 3");
		System.out.println("¡Carrera iniciada!");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}
}
