package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int opcion = 0;

		//Creamos el menú y dependiendo de la opción imprimirá un comando u otro
		do {

			ProcessBuilder cp = null;

			System.out.println("\n---MENÚ---\n" 
			+ "(1) hostname\n" 
					+ "(2) whoami\n" 
			+ "(3) date\n" 
					+ "(4) time\n" 
			+ "(5) Salir\n");

			opcion = sc.nextInt();

			switch (opcion) {
			case 1:
				cp = new ProcessBuilder("cmd", "/c", "hostname");
				leerComando(cp, "hostname");

				break;

			case 2:
				cp = new ProcessBuilder("cmd", "/c", "whoami");
				leerComando(cp, "whoami");

				break;

			case 3:
				cp = new ProcessBuilder("cmd", "/c", "date /t");
				leerComando(cp, "date");

				break;

			case 4:
				cp = new ProcessBuilder("cmd", "/c", "time /t");
				leerComando(cp, "time");

				break;

			default:
				break;
			}

		} while (opcion != 5);

		System.out.println("Fin del programa.");
		sc.close();

	}
	
	public static void leerComando(ProcessBuilder cp, String s) throws IOException {
		Process p = cp.start();

		// Guardamos la salida en un inputstream
		InputStream salida = p.getInputStream();

		// Convertimos la salida de bytes a caracteres
		InputStreamReader conversor = new InputStreamReader(salida);

		// Lo metemos en un buffer y mostramos la única línea que hay
		BufferedReader buffer = new BufferedReader(conversor);
		String linea = "";
		while (linea != null) {
			System.out.println(linea);
			linea = buffer.readLine();
		}

		cp.start();
	}

}
