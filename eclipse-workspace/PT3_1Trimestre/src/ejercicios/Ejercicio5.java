package ejercicios;

import java.io.IOException;

public class Ejercicio5 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Creamos y lanzamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("mspaint.exe");
		Process p = proceso.start();
		do {
			Thread.sleep(2000);
		} while (p.isAlive());

		// Cuando se cierre, espera 5 segundos, muestra el mensaje y se vuelve a abrir
		if (!p.isAlive()) {
			Thread.sleep(5000);
			System.out.println("El proceso se ha cerrado.");
			Thread.sleep(2000);
			proceso.start();
		}
	}
}
