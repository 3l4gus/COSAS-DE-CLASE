package ejercicios;

import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ProcessBuilder proceso = null;
		
		// Creamos y lanzamos cada proceso con un intervalo de 3 segundos
		proceso = new ProcessBuilder("mspaint.exe");
		Process p1 = proceso.start();
		System.out.println("Esperando 3 segundos...");
		Thread.sleep(3000);
		
		proceso = new ProcessBuilder("notepad");
		Process p2 = proceso.start();
		System.out.println("Esperando 3 segundos...");
		Thread.sleep(3000);
		
		// Mostramos el PID de cada proceso
		System.out.println("Pid del primer proceso: " + p1.pid() + 
				"\nPid del segundo proceso: " + p2.pid());
		
		// Indicamos cuál tiene el mayor PID
		if(p1.pid() > p2.pid()) {
			System.out.println("El mayor PID es el del primer proceso.");
		}else {
			System.out.println("El mayor PID es el del segundo proceso.");
		}
		
		// Comprobamos si siguen abiertos los procesos
		System.out.println("¿El primer proceso sigue vivo? " + p1.isAlive());
		System.out.println("¿El segundo proceso sigue vivo? " + p2.isAlive());

		// Forzamos el cierre de ambos procesos
		p1.destroy();
		p2.destroy();

		
	}
}
