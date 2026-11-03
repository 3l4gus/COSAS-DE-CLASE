package ejercicios;

import java.util.Scanner;
import java.io.IOException;

public class Ejercicio7 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		
		int r = (int) (Math.random() * 3) + 1;
		
		System.out.println("Te tocó el número " + r + ".");
		
		switch(r) {
		case 1:
			ProcessBuilder cp1 = new ProcessBuilder("calc.exe");
			cp1.start();
			break;
		case 2:
			ProcessBuilder cp2 = new ProcessBuilder("notepad");
			cp2.start();
			break;
		default:
			ProcessBuilder cp3 = new ProcessBuilder("mspaint.exe");
			cp3.start();
			break;
		}
		
	}


}
