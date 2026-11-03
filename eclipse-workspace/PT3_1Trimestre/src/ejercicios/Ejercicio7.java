package ejercicios;

import java.io.IOException;

public class Ejercicio7 {
	public static void main(String[] args) throws IOException, InterruptedException {

		// Creamos y lanzamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("dxdiag");
		Process p = proceso.start();
		
		// Mostramos un mensaje casa 2 segundos
				while(p.isAlive()) {
					Thread.sleep(2000);
					System.out.println("PID: " + p.pid());
					if (p.isAlive()) {
						System.out.println("El proceso sigue vivo.");
					}
				}
				System.out.println("El proceso se ha terminado.");
	}
}
