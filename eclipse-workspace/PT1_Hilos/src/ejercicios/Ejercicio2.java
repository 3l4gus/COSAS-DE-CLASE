package ejercicios;

public class Ejercicio2 {
	public static void main(String[] args) {

		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {

				// Dependiendo del nombre del hilo hará un for u otro
				if (Thread.currentThread().getName().equals("Números")) {
					for (int i = 1; i < 11; i++) {
						System.out.println("Hilo " + Thread.currentThread().getName() + " dice.. " + i);
					}
				} else {
					for (char letra = 'A'; letra < 'K'; letra++) {
						System.out.println("Hilo " + Thread.currentThread().getName() + " dice.. " + letra);
					}
				}
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Números");
		empezarHilo(tarea, "Letras");
	}

	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}
}
