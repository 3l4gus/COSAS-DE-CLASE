package Ejercicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		int cont = 1;
		String linea = "";
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig");
		Process p = pb.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				
		linea = br.readLine();
		
		while(linea != null) {
			if(cont % 5 == 0) {
				System.out.println("Línea número " + cont + ": " + linea);
			}
			linea = br.readLine();
			cont++;
		}
		br.close();
	}
}
