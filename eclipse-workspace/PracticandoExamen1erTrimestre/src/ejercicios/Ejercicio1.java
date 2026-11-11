package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		long inicio = 0, total = 0;
		int codigo = 0;
		
		File fichero = new File("fichero.txt");
		
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ipconfig");
		inicio = System.currentTimeMillis();
		
		// pb.inheritIO();
		Process p = pb.start();
		codigo = p.waitFor();
		total = System.currentTimeMillis() - inicio;
		
		pb.redirectErrorStream(true);
		// pb.redirectOutput(fichero);
		
		System.out.println("El proceso está vivo? " + p.isAlive());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		PrintWriter pw = new PrintWriter(fichero);
		
		String linea = br.readLine();
		
		while(linea != null) {
			if(linea.contains("a")) {
				System.out.println(linea);
				pw.println(linea);
			}
			linea = br.readLine();
		}
		System.out.println("Transcurriendo 2 segundos...");
		Thread.sleep(2000);
		System.out.println("\nTiempo transcurrido: " + total + 
				"\nCódigo: " + codigo +
				"\nRuta del fichero: " + fichero.getAbsolutePath() +
				"\nPID: " + p.pid());
		
		p.destroy();
		System.out.println("El proceso está vivo? " + p.isAlive());
		
		pw.close();
		br.close();
	}
}
