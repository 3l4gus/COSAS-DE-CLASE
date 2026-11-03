package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// Variable para la escoger una opción
		int opcion = 0;

		// Se repetirá el menú hasta que no se escriba un 5
		do {
			System.out.println("\n===== HERRAMIENTAS =====" 
					+ "\n1. ¿Quién soy?" 
					+ "\n2. ¿Cómo se llama este equipo?"
					+ "\n3. ¿Qué hora es?"
					+ "\n4. ¿Qué procesos están ejecutándose?" 
					+ "\n5. Salir"
					+ "\n\nSelecciona una opción: ");
			opcion = sc.nextInt();

			// Dependiendo del número utilizará un String u otro como parámetro
			switch (opcion) {
			case 1:
				ejecutarComando("whoami");
				break;
			case 2:
				ejecutarComando("hostname");
				break;
			case 3:
				ejecutarComando("time /t");
				break;
			case 4:
				ejecutarComando("tasklist");
				break;
			case 5:
				System.out.println("Fin del programa.");
				break;
			}
			
			if(opcion < 1 || opcion > 5) {
				System.out.println("Debes escribir un número del 1 al 5.\n");
			}
		} while (opcion != 5);
		
		sc.close();
	}

	// Método para crear y ejecutar un comando dependiendo del String que le
	// pongamos de parámetro
	public static void ejecutarComando(String comando) throws IOException {
		String linea = "";

		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", comando);
		Process p = proceso.start();

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Imprimimos por consola línea por línea
		linea = br.readLine();

		do {
			System.out.println(linea);
			linea = br.readLine();
		} while (linea != null);
		
		br.close();
	}
}
