package ejercicios;

import java.io.IOException;

public class Ejercicio4 {
	public static void main(String[] args) throws IOException {
		
		//Creamos el proceso para que abra youtube y lo ejecutamos
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "start", "https://www.youtube.com/");
		cp.start();
	}
}
