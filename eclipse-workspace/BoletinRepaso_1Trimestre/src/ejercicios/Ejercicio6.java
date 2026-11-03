package ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio6 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		// Variables contar el número de veces que aparece el proceso, guardar el nombre del proceso
		// que queremos buscar, guardar las líneas del comando y saber si existe o no el proceso
		int cont = 0;
		String nombreProceso = "", linea = "";
		boolean existe = false;
		
		// Preguntamos y mostramos qué proceso queremos buscar
		System.out.println("Escribe el nombre de un proceso:");
		nombreProceso = sc.nextLine().toLowerCase();
		System.out.println("\nProceso buscado: " + nombreProceso);
				
		// Creamos y ejecutamos el proceso
		ProcessBuilder proceso = new ProcessBuilder("cmd.exe", "/c", "tasklist");
		Process p = proceso.start();
		
		// Creamos un BufferedReader que leerá los caracteres (antes bytes) que fueron 
		// convertidos por el InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		
		// Leemos línea por línea y si existe el nombre del proceso que escribimos, pondremos el booleano
		// en true y sumaremos 1 al contador
		linea = br.readLine();
		
		do{			
			if(linea.contains(nombreProceso)) {
				existe = true;
				cont++;
			}
			
			linea = br.readLine();
		}while(linea != null);
		
		// Dependiendo del booleano y de si el contador es mayor a 1 ocurrirán unas cosas u otras
		if(existe) {
			System.out.println("El proceso está en ejecución." 
					+ "\nNúmero de instancias: " + cont);
			
			if(cont > 1) {
				System.out.println("Hay varias instancias.");
			}
		}else {
			System.out.println("El proceso no está en ejecución.");
		}
		
		br.close();
	}
}
