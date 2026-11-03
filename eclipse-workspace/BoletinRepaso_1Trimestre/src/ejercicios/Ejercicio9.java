package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio9 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// Creamos el Process en null para poder utilizarlo aunque no hayamos lanzado aún el Bloc de notas
		Process p = null;
		
		// Variable para la opción que escoja el usuario
		int opcion = 0;
		
		// Se repetirá mientras la opción sea distinta a 4
		do {
			
			// Mostramos menú y guardamos la opción escogida
			System.out.println("===== CONTROL DE PROCESO =====" 
					+ "\n1. Lanzar Bloc de notas" 
					+ "\n2. Comprobar estado"
					+ "\n3. Mostrar PID"
					+ "\n4. Salir"
					+ "\nEscoge una opción: ");
			opcion = sc.nextInt();
			
			// Dependiendo de la opción que escojamos ocurrirá una cosa u otra
			switch(opcion) {
			case 1:
				
				// Lanzamos el Bloc de notas si no está abierto
				if(p == null || !p.isAlive()) {
					ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "notepad.exe");
					p = proceso.start();
					System.out.println("Bloc de notas lanzado.");
				}else {
					System.out.println("Ya se ha lanzado un bloc de notas.");
				}
				break;
			case 2:
				
				// Mostramos si el Bloc de notas está en ejecución
				if(p != null && p.isAlive()) {
					System.out.println("El Bloc de notas está en ejecución.");
				}else {
					System.out.println("El Bloc de notas no está en ejecución.");
				}
				break;
			case 3:
				
				// Mostramos el PID del Bloc de notas si está abierto
				if(p != null && p.isAlive()) {
					System.out.println("PID del Bloc de notas: " + p.pid());
				}else {
					System.out.println("El Bloc de notas no está en ejecución.");
				}
				break;
			case 4:
				System.out.println("Fin del programa.");
				break;
			}
		}while(opcion != 4);
		
		sc.close();
	}
}
