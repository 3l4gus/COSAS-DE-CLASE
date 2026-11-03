package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		
		// Mostramos la variables de un número aleatorio del 1 al 3
		int aleatorio = (int) (Math.random() * 3) + 1;
		System.out.println("Número generado: " + aleatorio + "\n");
		
		// Dependiendo del número utilizará un String u otro como parámetro
		switch(aleatorio) {
		case 1:
			ejecutarComando("hostname");
			break;
		case 2:
			ejecutarComando("whoami");
			break;
		case 3:
			ejecutarComando("ipconfig");
			break;
		}
	}
	
	// Método para crear y ejecutar un comando dependiendo del String que le pongamos de parámetro
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
		
		do{			
			System.out.println(linea);
			linea = br.readLine();
		}while(linea != null);
		
		br.close();
	}
}
