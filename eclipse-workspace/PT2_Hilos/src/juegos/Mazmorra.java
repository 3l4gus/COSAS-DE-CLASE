package juegos;

import java.util.Scanner;

public class Mazmorra {
	public static void jugar() throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		// Escribimos por consola el nombre de los personajes que vamos a crear
		System.out.println("---OPERACIÓN MAZMORRA---" + 
		"\nEscribe el nombre del guerrero: ");
		Personaje guerrero = new Personaje(sc.nextLine(), "Guerrero");
		System.out.println("Escribe el nombre del mago: ");
		Personaje mago = new Personaje(sc.nextLine(), "Mago");

		System.out.println("\n¡Comienza la competición!\n");

		// Ejecutamos el método para crear los hilos y los guardamos en un Thread para poder controlarlos individualmente.
		// Se ejecutan a la vez
		Thread hiloGuerrero = empezarHilo(guerrero, "Hilo-Guerrero");
		Thread hiloMago = empezarHilo(mago, "Hilo-Mago");

		// Mientras alguno de los hilos esté vivo iremos mostrando cada 1,6 segundos el estado de los hilos
		do {
			Thread.sleep(1600);
			System.out.println("\n---ESTADO PERSONAJES---\n" + 
			hiloGuerrero.getName() + ": " + hiloGuerrero.getState() + "\n" + 
			hiloMago.getName() + ": " + hiloMago.getState() + "\n");
		} while (hiloGuerrero.isAlive() || hiloMago.isAlive());

		// Esperamos a que se acaben la ejecución de los hilos para mostrar la siguiente información
		hiloGuerrero.join();
		hiloMago.join();
		
		// Una vez se han acabado de ejecutar los 2 se mostrará la siguiente información
		System.out.println("---RESULTADOS TOTALES---" + 
		"\n" + guerrero.getNombre() + " ha tardado " + guerrero.getTiempo() + " ms" + 
		"\n" + mago.getNombre() + " ha tardado " + mago.getTiempo() + " ms\n");
		
		// Indicamos qué personaje ha ganado la carrera o si se dio un empate
		if(guerrero.getTiempo() < mago.getTiempo()) {
			System.out.println("¡" + guerrero.getNombre() + " ha ganado la carrera!\n");
		}else if(guerrero.getTiempo() > mago.getTiempo()) {
			System.out.println("¡" + mago.getNombre() + " ha ganado la carrera!\n");
		}else {
			System.out.println("¡Los dos aventureros han llegado al mismo tiempo!\n");
		}
		sc.close();
	}

	// Método para crear hilos, devolverá el hilo
	public static Thread empezarHilo(Personaje personaje, String nombre) {

		// Creamos el hilo pasandole la tarea y el nombre y lo ejecutamos
		Thread hilo = new Thread(personaje, nombre);
		hilo.start();

		return hilo;
	}
}
