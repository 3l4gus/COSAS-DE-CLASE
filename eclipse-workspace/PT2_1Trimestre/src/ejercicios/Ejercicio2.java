package ejercicios;

import java.io.IOException;

public class Ejercicio2 {
	public static void main(String[] args) throws IOException {
		
		//Creamos el proceso para que abra chrome y lo ejecutamos
		ProcessBuilder cp = new ProcessBuilder("cmd", "/c", "start chrome");
		cp.start();
	}
}
