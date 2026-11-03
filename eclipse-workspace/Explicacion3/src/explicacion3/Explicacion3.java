package explicacion3;

import java.io.IOException;

public class Explicacion3 {
	public static void main(String[] args) throws IOException, InterruptedException  {

		ProcessBuilder proceso = new ProcessBuilder("cmd", "/c", "hostname & whoami");

		// Lanzamos proceso
		Process p = proceso.start();

		// Mostramos PID del proceso
		System.out.println("El PID del proceso es: " + p.pid());

		// Comrpobamos si sigue abierto el proceso
		System.out.println("Sigue vivo? " + p.isAlive());

		// Esperamos 5 segundos
		System.out.println("Esperando 5 segundos...");
		Thread.sleep(5000);

		System.out.println("Sigue vivo? " + p.isAlive());

		// Forzamos el cierre
		p.destroy();
		
		Thread.sleep(5000);
		System.out.println("Sigue vivo? " + p.isAlive());
	}
}
