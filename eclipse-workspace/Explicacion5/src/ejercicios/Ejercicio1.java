package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		String linea = "";
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping 8.8.8.8");
		
		Process p = pb.start();
		
		InputStream salida = p.getInputStream();
		InputStreamReader conversor = new InputStreamReader(salida);
		BufferedReader br = new BufferedReader(conversor);
		
		File fichero = new File("ping.txt");
		
		PrintWriter pw = new PrintWriter(fichero);
		
		linea = br.readLine();
		
		while(linea != null) {
			if(linea.contains("TTL")){
					pw.println(linea);
			}
			linea = br.readLine();
		}
		
		pw.close();
	}
}
