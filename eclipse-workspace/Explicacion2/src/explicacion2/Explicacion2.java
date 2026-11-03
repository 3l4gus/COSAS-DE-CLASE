package explicacion2;

import java.io.IOException;

public class Explicacion2 {
	public static void main(String[] args) throws IOException {
		System.out.println("Hola PSP");
// Creamos el proceso de notepad

		ProcessBuilder cp = new ProcessBuilder("mspaint");

// lanzamos el proceso
		for (int i = 0; i < 5; i++) {
			cp.start();
		}
	}
}