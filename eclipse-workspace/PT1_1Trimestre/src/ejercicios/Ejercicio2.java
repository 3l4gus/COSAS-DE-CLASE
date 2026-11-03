package ejercicios;

import java.io.IOException;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {

		ProcessBuilder cp = new ProcessBuilder("mspaint.exe");

		for (int i = 0; i < 3; i++) {
			
			cp.start();
		
		}
		
	}

}
