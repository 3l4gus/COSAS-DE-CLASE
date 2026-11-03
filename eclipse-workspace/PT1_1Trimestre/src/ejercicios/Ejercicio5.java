package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int opcion = 0;
		
		do {
			
			System.out.println("---MENÚ---\n"
					+ "(1) Calculadora\n"
					+ "(2) Paint\n"
					+ "(3) Notepad\n"
					+ "(4) Salir\n");
			
			opcion=sc.nextInt();
			
			switch (opcion) {
			case 1:
				ProcessBuilder cp1 = new ProcessBuilder("calc.exe");
				cp1.start();
				break;
				
			case 2:
				ProcessBuilder cp2 = new ProcessBuilder("mspaint.exe");
				cp2.start();
				break;
				
			case 3:
				ProcessBuilder cp3 = new ProcessBuilder("notepad");
				cp3.start();
				
			default:
				break;
			}
			
		}while(opcion != 4);
		
		System.out.println("Fin del programa.");
		sc.close();
		
	}

}
