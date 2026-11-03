package ejercicios;

import java.util.Scanner;
import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner sc = new Scanner(System.in);

		// Variables para contador y tiempo máximo
		int cont = 0, t = 0;

		// Pedimos el tiempo máximo
		System.out.println("Escribe el tiempo máximo de ejecución en segundos: ");
		t = sc.nextInt();

		// Creamos y lanzamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("mspaint.exe");
		Process p = proceso.start();

		// Incrementamos el contador cada segundo hasta que se iguale al tiempo máximo
		do {
			Thread.sleep(1000);
			cont++;
			System.out.println(cont);
		}while(cont < t && p.isAlive());
		
		// Forzamos cierre si llega al límite de tiempo
		p.destroy();
		
		// Indicamos si se cerró automáticamente o no
		if(cont == t) {
			System.out.println("Proceso cerrado automáticamente.");
		}else {
			System.out.println("El usuario cerró la aplicación antes.");
		}
		
		sc.close();
	}
}
