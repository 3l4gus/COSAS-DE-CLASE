package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		
		// Variables para guardar las líneas de los comandos
		String usuario = "", equipo = "";
		
		// Creamos y ejecutamos el primer proceso
		ProcessBuilder proceso = null;
		proceso = new ProcessBuilder("cmd.exe", "/c", "whoami");
		Process p1 = proceso.start();
		
		// Guardamos en el String usuario la primera línea del primer proceso mediante un BufferedReader que
		// leerá los caracteres (antes bytes) que fueron convertidos por el InputStreamReader
		BufferedReader brUsuario = new BufferedReader(new InputStreamReader(p1.getInputStream()));
        usuario = brUsuario.readLine();
		
        // Creamos y ejecutamos el segundo proceso
		proceso = new ProcessBuilder("cmd.exe", "/c", "hostname");
		Process p2 = proceso.start();
		
		// Lo mismo que en el primer proceso
		BufferedReader brEquipo = new BufferedReader(new InputStreamReader(p2.getInputStream()));
        equipo = brEquipo.readLine();

		// Imprimimos por consola la información que pide el enunciado
		System.out.println("=====INFORMACIÓN DEL EQUIPO=====" 
	+ "\n\nUsuario: " + usuario
				+ "\nEquipo: " + equipo
	+ "\n\n==================================");
		
		brUsuario.close();
		brEquipo.close();
	}
}
