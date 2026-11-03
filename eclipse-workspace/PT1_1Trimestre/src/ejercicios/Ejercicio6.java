package ejercicios;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		int opcion = 0, veces = 0;
		
		
		do {
			
			System.out.println("---MENÚ---\n"
					+ "(1) Calculadora\n"
					+ "(2) Paint\n"
					+ "(3) Notepad\n"
					+ "(4) Salir\n");
			
			opcion=sc.nextInt();
			
			if(opcion < 4 && opcion > 0) {
				System.out.println("¿Cuántas veces quieres lo quieres abrir?");
				veces=sc.nextInt();
			}
			
			switch (opcion) {
			case 1:
				for (int i = 0; i < veces; i++) {
					ProcessBuilder cp1 = new ProcessBuilder("calc.exe");
					cp1.start();
				}
				break;
				
			case 2:
				for (int i = 0; i < veces; i++) {
					ProcessBuilder cp2 = new ProcessBuilder("mspaint.exe");
					cp2.start();
				}
				break;
				
			case 3:
				for (int i = 0; i < veces; i++) {
					ProcessBuilder cp3 = new ProcessBuilder("notepad");
					cp3.start();
				}
				break;
				
			default:
				break;
			}
			
		}while(opcion != 4);
		
		System.out.println("Fin del programa.");
		sc.close();
		
	}

}
