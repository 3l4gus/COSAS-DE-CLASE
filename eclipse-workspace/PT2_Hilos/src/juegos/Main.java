package juegos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		do {
			System.out.println("\t\tPSP ARCADE" + "\n1. MAZMORRAS" + "\n2. CIRCUITO DE RELEVO" + "\n0. SALIR"
					+ "\n\n\nEscoge un juego: ");
			
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
			switch (op) {
			case 1:
				Mazmorra.jugar();
				break;
			case 2:
				break;
			case 0:
				System.out.println("Fin del programa.");
				break;
			}
		} while (op != 0);
		sc.close();
	}
}
