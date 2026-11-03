package ejercicios;

import java.io.IOException;

public class Ejercicio7 {
	public static void main(String[] args) {
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				
				// Dependiendo del nombre del hilo se ejecutará un comando u otro
				if (Thread.currentThread().getName().equals("Diagnóstico A")) {
					System.out.println("Hilo " + Thread.currentThread().getName() + ": iniciando date");
					crearProcesos("date /t", "A");
				}else {
					System.out.println("Hilo " + Thread.currentThread().getName() + ": iniciando hostname");
					crearProcesos("hostname", "B");
				}
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Diagnóstico A");
		empezarHilo(tarea, "Diagnóstico B");
		System.out.println("Centro de diagnóstico iniciado.");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}

	// Método para crear procesos
	public static void crearProcesos(String comando, String letra) {
		
		// Creamos el proceso y lo mostramos por consola
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
		pb.inheritIO();
		try {
			
			// Ejecutamos el proceso y mostramos el PID
			Process p = pb.start();
			System.out.println("PID del proceso " + letra + ": " + p.pid());
		} catch (IOException e) {
			System.out.println("Error.");
		}
	}
}
