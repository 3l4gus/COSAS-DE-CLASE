package ejercicios;

public class Ejercicio4 {
	public static void main(String[] args) {
		System.out.println("INICIO");
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				
				// Dependiendo del nombre del hilo hará un for u otro
				if (Thread.currentThread().getName().equals("Máquina A")) {
					for (int i = 0; i < 21; i+=5) {
						System.out.println("La " + Thread.currentThread().getName() + " está procesando el " + i);
					}
				} else {
					for (int j = 20; j >= 0; j-=5) {
						System.out.println("La " + Thread.currentThread().getName() + " está procesando el " + j);
					}
				}
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Máquina A");
		empezarHilo(tarea, "Máquina B");
		System.out.println("FIN");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}
}
