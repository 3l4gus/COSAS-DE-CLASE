package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio9 {
	public static void main(String[] args) throws IOException {

		// Creamos el proceso para que muestre dos comandos en cmd, lo ejecutamos y lo guardamos en un objeto
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "hostname & whoami");
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
