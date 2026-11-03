package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		
		System.out.println("Escribe un número:");
		n=sc.nextInt();
		
		if(n > 5) {
			
			ProcessBuilder cp = new ProcessBuilder("calc.exe");

			cp.start();
			
		}else {
			
			ProcessBuilder cp = new ProcessBuilder("notepad");

			cp.start();
			
		}
		
		sc.close();
		
	}

}
