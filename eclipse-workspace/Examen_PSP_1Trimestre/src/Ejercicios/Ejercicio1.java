package Ejercicios;

import java.io.IOException;

public class Ejercicio1 {
	public static void main(String[] args) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("calc");
		Process p = pb.start();
		
		System.out.println("Estoy lanzando la calculadora con el pid " + p.pid());
	}
}
