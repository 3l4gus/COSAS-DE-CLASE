package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio8 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// Variables para la opcion que escoja el usuario y el número aleatorio
		int opcion = 0, aleatorio = 5;

		// Mientras la opcion y el número aleatorio sean distintos se seguirá haciendo
		do {
			
			// Pedimos opción y la mostramos junto al número generado
			System.out.println("¿Cuál es tu aplicación favorita?" 
			+ "\n1. Paint" 
							+ "\n2. Calculadora" 
			+ "\n3. Bloc de notas");
			opcion = sc.nextInt();
			aleatorio = (int) (Math.random() * 3) + 1;
			System.out.println("\nOpción elegida: " + opcion 
					+ "\nNúmero generado: " + aleatorio + "\n");

			// Si la opción elegida y el número generado coinciden se hará el switch, sino aparecerá un 
			// mensaje y nos volverá a pedir una opción
			if (opcion == aleatorio) {
				System.out.println("¡Has tenido suerte!\n");
				
				switch (opcion) {
				case 1:
					ejecutarComando("mspaint.exe");
					break;
				case 2:
					ejecutarComando("calc");
					break;
				case 3:
					ejecutarComando("notepad.exe");
					break;
				}
			} else {
				System.out.println("Hoy no hay suerte...\n");
			}
		} while (opcion != aleatorio);
		
		System.out.println("Fin del programa.");
		sc.close();
	}

	// Método para crear y ejecutar un comando dependiendo del String que le
	// pongamos de parámetro
	public static void ejecutarComando(String comando) throws IOException {
		String linea = "";

		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", comando);
		Process p = proceso.start();
	}
}
