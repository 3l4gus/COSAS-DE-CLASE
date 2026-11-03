package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio6 {
	public static void main(String[] args) throws IOException {

		// Creamos una variable para contar las líneas
		int cont = 0;
		
		// Creamos el proceso para que muestre la salida de ipconfig,
		// lo ejecutamos y lo guardamos en un objeto
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "ipconfig");
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
			cont++;
			linea = buffer.readLine();
		}

		//Mostramos el número de líneas
		System.out.println("\nTotal de líneas: " + cont);

		cp.start();
	}
}
