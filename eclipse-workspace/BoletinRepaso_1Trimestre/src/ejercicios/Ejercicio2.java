package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		
		// Variables para el contador de IPv4 y guardar las líneas de los comandos
		int direcciones = 0;
		String linea = "";
		
		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "ipconfig", "-all");
		Process p = proceso.start();
		
		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron 
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		// Vamos leyendo todas las líneas y mostrando solo las que contengan "ipv4" (iremos sumando
		// el contador) o "puerta de enlace" hasta que la línea leída sea igual a null
		linea = br.readLine();
		 do{
			if(linea.toLowerCase().contains("ipv4")) {
				System.out.println("IPv4 encontradas: " + linea);
				direcciones++;
			} else if(linea.toLowerCase().contains("puerta de enlace")) {
				System.out.println("Puerta de enlace: " + linea);
			}
			linea = br.readLine();
		}while(linea != null);
		 
		// Usando el contador mostramos el número de IPv4 encontradas
		System.out.println("Número de direcciones IPv4 encontradas: " + direcciones);
		
		br.close();
        
	}
}
