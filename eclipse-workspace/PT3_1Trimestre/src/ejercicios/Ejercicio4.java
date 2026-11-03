package ejercicios;

import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException, InterruptedException {

		ProcessBuilder proceso = null;

		// Creamos y lanzamos cada proceso
		proceso = new ProcessBuilder("mspaint.exe");
		Process p1 = proceso.start();
		proceso = new ProcessBuilder("notepad");
		Process p2 = proceso.start();
		proceso = new ProcessBuilder("calc");
		Process p3 = proceso.start();

		// Mostramos el PID de cada uno
		System.out.println("PID del primer proceso: " + p1.pid());
		System.out.println("PID del segundo proceso: " + p2.pid());
		System.out.println("PID del tercer proceso: " + p3.pid());

		Thread.sleep(3000);
		
		// Comprobamos si siguen abiertos los procesos
		System.out.println("¿El primer proceso sigue vivo? " + p1.isAlive());
		System.out.println("¿El segundo proceso sigue vivo? " + p2.isAlive());
		System.out.println("¿El tercer proceso sigue vivo? " + p3.isAlive());
		
		// Aplicamos el destroy solo si están abiertos
		if(p1.isAlive()) {
			p1.destroy();
		}else if(p2.isAlive()) {
			p2.destroy();
		}else if(p3.isAlive()) {
			p3.destroy();
		}
	}
}
