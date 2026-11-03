package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {
	public static void main(String[] args) throws IOException {
		
		// Variable para guardar la línea del comando
		String linea = "";

		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "hostname");
		Process p = proceso.start();

		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

		// Leemos el comando y mostramos la línea y el número de caracteres que contiene
		linea = br.readLine();
		System.out.println("Nombre del equipo: " + linea);
		System.out.println("Número de caracteres: " + linea.length());
		
		br.close();
	}
}
