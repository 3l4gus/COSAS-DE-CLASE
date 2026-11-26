package juegos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		// Menú para elegir el juego que queremos jugar, al teclear 0 finalizará el programa
		do {
			System.out.println("\t\t---PSP ARCADE---" + "\n1. MAZMORRAS" + "\n2. CIRCUITO DE RELEVO" + "\n0. SALIR"
					+ "\n\n\nEscoge un juego: ");
			
			// Nos aseguramos de que la opción escogida sea válida
			try {
				op = sc.nextInt();
				
				if(op < 0 || op > 2) {
					System.out.println("Error: el número debe estar entre 0 y 2.");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error: debes escribir un número.");
				sc.nextLine();
				op = -1;
				continue;
			}
			
			// Se ejecutará el case que coincida con la opción escogida
			switch (op) {
			case 1:
				Mazmorra.jugar();
				break;
			case 2:
				Circuito.jugar();
				break;
			case 0:
				System.out.println("Fin del programa.");
				break;
			}
		} while (op != 0);
		sc.close();
	}
}
