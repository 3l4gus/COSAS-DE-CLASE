package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		// Variables
		String op = "";

		// Mientras op sea distinto de "e" se seguirá repitiendo el menú
		do {
			System.out.println("---COMANDOS---" + "\na. Mostrar las direcciones MAC" + "\nb. Mostrar el usuario actual"
					+ "\nc. Mostrar la versión de Windows" + "\nd. Mostrar la configuración de red" + "\ne. Salir."
					+ "\nEscoge una opción: ");
			op = sc.next();

			// Dependiendo de la opción que escojamos se hará una cosa u otra
			switch (op) {
			case "a":
				mostrarComando("getmac");
				break;
			case "b":
				mostrarComando("whoami");
				break;
			case "c":
				mostrarComando("ver");
				break;
			case "d":
				mostrarComando("ipconfig /all");
				break;
			case "e":
				System.out.println("Fin del programa.");
				break;
			}
		} while (!op.equals("e"));
		
		sc.close();
	}

	// Método que crea y ejecuta el proceso y muestra las líneas dependiendo del String que
	// le pasemos como parámetro
	public static void mostrarComando(String nombre) throws IOException {
		String linea = "";
		
		// Creamos el proceso y lo ejecutamos
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", nombre);
		Process p = pb.start();

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Vamos leyendo todas las líneas y mostrandolas
		do {
			linea = br.readLine();
			if (linea != null) {
				System.out.println(linea);
			}
		} while (linea != null);
		
		System.out.println();
		br.close();
	}
}
