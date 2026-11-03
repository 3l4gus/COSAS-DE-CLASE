package ejercicios;

import java.io.IOException;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		
		ProcessBuilder cp = new ProcessBuilder("calc.exe");

		cp.start();

	}

}