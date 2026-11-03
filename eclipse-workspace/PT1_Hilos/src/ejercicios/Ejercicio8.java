package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {
	public static void main(String[] args) {
		System.out.println("Centro de diagnóstico iniciado");
		
		// Creamos el fichero
		File fichero = new File("salida.txt");
		
		// Creamos la tarea que ejecutará los hilos
		Runnable tarea = new Runnable() {
			@Override
			public void run() {
				System.out.println("Nombre del hilo iniciado: " + Thread.currentThread().getName());
				
				// Ejecutamos los comandos y decimos que se guarden en el fichero
				crearProcesos("date /t", fichero);
				crearProcesos("time /t", fichero);
				System.out.println(Thread.currentThread().getName() + ": diagnóstico finalizado");
			}
		};
		
		// Creamos los hilos
		empezarHilo(tarea, "Diagnostico A");
		empezarHilo(tarea, "Diagnostico B");
	}
	
	// Método para crear hilos
	public static void empezarHilo(Runnable tarea, String nombre) {
		
		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(tarea, nombre);
		hilo.start();
	}
	
	// Método para crear procesos
	public static void crearProcesos(String comando, File fichero) {
		
		// Creamos el proceso
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", comando);
		try {
			
			// Ejecutamos el proceso
			Process p = pb.start();
			
			// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
			// convertidos por el InputStreamReader
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

			// Abrimos el fichero para escribir en él y ponemos el true para que no se sobreescriba
	        BufferedWriter bw = new BufferedWriter(new FileWriter(fichero, true));

	        String linea = br.readLine();
	        
	        // Leemos las líneas hasta el final
	        while (linea != null) {
	            bw.write(linea);
	            bw.newLine();
	            linea = br.readLine();
	        }

	        bw.close();
	        br.close();
		} catch (IOException e) {
			System.out.println("Error.");
		}
	}
}
