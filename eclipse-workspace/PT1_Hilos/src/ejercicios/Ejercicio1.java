package ejercicios;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			public void run() {
				
				// Recorremos el for para que cada hilo muestre el mensaje 5 veces
				for(int i = 1; i < 6; i++) {
					System.out.println("Mensaje " + i + ": cositas.." + Thread.currentThread().getName());
				}
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Manuel");
		empezarHilo(tarea, "Paola");
		empezarHilo(tarea, "César");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}
}
