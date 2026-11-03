package ejercicios;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		// Variables para el contador de procesos, guardar las líneas de los comandos y la respuesta a 
		// la pregunta
		int procesos = 0;
		String linea = "", respuesta = "";
		
		// ArrayList donde guardaremos todas las líneas de tasklist
        ArrayList<String> listaProcesos = new ArrayList<>();
		
		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "tasklist");
		Process p = proceso.start();
		
		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron 
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		// Leemos línea por línea, la añadimos al ArrayList y mostramos solo las que tengan "kb"
		// que son las líneas que respresentan a un proceso
		linea = br.readLine();
		
		do{
			listaProcesos.add(linea);
			
			if(linea.toLowerCase().contains("kb")) {
				procesos++;
			}
			linea = br.readLine();
		}while(linea != null);
		 
		 // Preguntamos si queremos mostrar la lista completa dependiendo de si el usuario pone "s" o "n"
		System.out.println("Se han encontrado " + procesos + " procesos." + 
		"\n¿Quieres mostrar la lista completa? (s/n): ");
		do {
			respuesta = sc.next();
			
			if(respuesta.equals("s")) {
				
				// Recorremos el ArrayList desde el principio
                for (String lin : listaProcesos) {
                    System.out.println(lin);
                }
                
                System.out.println("\nFin del programa.");
			}else if(respuesta.equals("n")) {
				System.out.println("\nFin del programa.");
				break;
			}else {
				System.out.println("Debes escribir 's' o 'n'");
			}
		}while(!respuesta.equals("s") && !respuesta.equals("n"));
		
		br.close();
		sc.close();
	}
}
