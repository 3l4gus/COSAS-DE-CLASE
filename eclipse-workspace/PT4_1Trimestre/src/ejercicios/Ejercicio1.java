package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {

		// Variable para guardar la línea del comando
		String linea = "", linea2 = "";
		
		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "getmac");
		Process p = proceso.start();

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Vamos leyendo todas las líneas y mostramos solo la última
		do {
			linea2 = linea;
			linea = br.readLine();
			if(linea == null) {
				System.out.println("Última línea: " + linea2);
			}
		} while (linea != null);
		
		br.close();
	}
}
