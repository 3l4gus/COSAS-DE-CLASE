package ejercicios;

import java.io.IOException;

public class Ejercicio6 {
	public static void main(String[] args) {
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				long pid = 0;
				
				// Dependiendo del nombre del hilo se ejecutará un comando u otro y devolverá el PID para
				// mostrarlo por consola
				if (Thread.currentThread().getName().equals("Calculadora")) {
					System.out.println("Hilo " + Thread.currentThread().getName() + " ha iniciado la Calculadora.");
					pid = crearProcesos("calc.exe");
					System.out.println("PID de la " + Thread.currentThread().getName() + ": " + pid);
				}else {
					System.out.println("Hilo " + Thread.currentThread().getName() + " ha iniciado el Bloc de notas.");
					pid = crearProcesos("notepad");
					System.out.println("PID del " + Thread.currentThread().getName() + ": " + pid);
				}

			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Calculadora");
		empezarHilo(tarea, "Bloc");
		System.out.println("¡El centro de mando ha iniciado los programas!");
	}

	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}

	// Método para crear procesos
	public static long crearProcesos(String comando) {
		long pid = 0;
		
		// Creamos el proceso y lo mostramos por consola
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
		try {
			
			// Ejecutamos el proceso y guardamos el PID para devolverlo
			Process p = pb.start();
			pid = p.pid();
		} catch (IOException e) {
			System.out.println("Error.");
		}
		return pid;
	}
}
