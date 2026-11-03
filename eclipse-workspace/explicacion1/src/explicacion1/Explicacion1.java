package explicacion1;

import java.io.IOException;

public class Explicacion1 {

	public static void main(String[] args) throws IOException {

		System.out.println("Hola PSP");

//		Creamos el proceso de notepad
		ProcessBuilder cp = new ProcessBuilder("notepad");

//		Lanzamos el proceso
		for (int i = 0; i < 5; i++) {

			cp.start();

		}

	}

}
