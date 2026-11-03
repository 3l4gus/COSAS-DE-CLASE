package ejercicios;

import java.io.IOException;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Variable para el contador
		int cont = 0;

		// Creamos y lanzamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("mspaint.exe");
		Process p = proceso.start();
		
		// Mostramos cada 1 segundo que sigue activo y vamos incrementando el contador
		while (p.isAlive()) {
			System.out.println("El proceso sigue activo...");
			Thread.sleep(1000);
			cont++;
		}

		// Cuando se cierra mostramos PID y cuántos segundos estuvo abierto
		System.out.println("Paint se ha cerrado." + 
		"\nPID: " + p.pid() + 
		"\nEl proceso estuvo " + cont + " segundo/s abierto.");

	}
}
