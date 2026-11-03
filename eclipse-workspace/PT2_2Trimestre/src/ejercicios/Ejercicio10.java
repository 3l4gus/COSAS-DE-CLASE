package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejercicio10 {
	public static void main(String[] args) throws IOException {

		// Creamos una variable para contar las instancias
		int cont = 0;

		// Creamos el proceso para que muestre dos comandos en cmd, lo ejecutamos y lo
		// guardamos en un objeto
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "tasklist");
		Process p = cp.start();

		// Guardamos la salida en un inputstream
		InputStream salida = p.getInputStream();

		// Convertimos la salida de bytes a caracteres
		InputStreamReader conversor = new InputStreamReader(salida);

		// Lo metemos en un buffer y si el notepad está en ejecución aparacerá un mensaje
		BufferedReader buffer = new BufferedReader(conversor);
		String linea = "";
		while (linea != null) {
			if (linea.toLowerCase().contains("notepad.exe")) {
				System.out.println("El bloc de notas está en ejecución.");
				cont++;
			}
			linea = buffer.readLine();
		}

		// Mostramos el número de instancias o de lo contrario que no está en ejecución
		if (cont != 0) {
			System.out.println("El número de instancias es " + cont + ".");
		}else {
			System.out.println("El bloc de notas no está en ejecucuón.");
		}

		cp.start();
	}
}
