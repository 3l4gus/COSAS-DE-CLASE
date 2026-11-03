package ejercicios;

import java.io.IOException;

public class Ejercicio6 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variable para el contador
		int cont = 0;
		
		// Creamos y lanzamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("mspaint.exe");
		Process p = proceso.start();
		
		// Mostramos un mensaje a cada segundo que pasa
		while(p.isAlive()) {
			Thread.sleep(1000);
			System.out.println("Ha pasado un segundo.");
			cont++;
		}
		
		// Mostramos tiempo transcurrido y PID
		System.out.println("Tiempo total: " + cont + 
				"\nPID: " + p.pid());
	}
}
