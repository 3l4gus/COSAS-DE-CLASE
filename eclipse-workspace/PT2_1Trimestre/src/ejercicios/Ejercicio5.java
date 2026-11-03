package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio5 {
	public static void main(String[] args) throws IOException {

		// Creamos el proceso para que muestre la salida de ipconfig,
		// lo ejecutamos y lo guardamos en un objeto
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "ipconfig");
		Process p = cp.start();

		// Guardamos la salida en un inputstream
		InputStream salida = p.getInputStream();

		// Convertimos la salida de bytes a caracteres
		InputStreamReader conversor = new InputStreamReader(salida);

		// Lo metemos en un buffer y mostramos la única línea que hay mostrando el número de línea
		BufferedReader buffer = new BufferedReader(conversor);
		String linea = "";
		for (int i = 1; i < 11; i++) {
			System.out.println("Línea " + i + ": " + linea);
			linea = buffer.readLine();
		}

		cp.start();
	}
}
