package Ejercicios;

import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) throws IOException, InterruptedException {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "ping google.com");
		
		pb.inheritIO();
		Process p = pb.start();
		int codigo = p.waitFor();
		
		System.out.println("Código de salida: " + codigo);
	}
}
