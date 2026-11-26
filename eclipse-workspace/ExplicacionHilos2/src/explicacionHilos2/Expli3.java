package explicacionHilos2;

public class Expli3 {
	public static void main(String[] args) throws InterruptedException {
		
		// Creamos los objetos de la clase tarea
		Tarea3 tarea1 = new Tarea3("Lúa", 5);
		Tarea3 tarea2 = new Tarea3("Jaco", 3);
		
		// Creamos los hilos
		Thread hilo1 = new Thread(tarea1, "hilo1");
		Thread hilo2 = new Thread(tarea2, "hilo2");
		
		// Iniciamos hilos
		hilo1.start();
		hilo2.start();
		
		// Esperamos
		hilo1.join();
		hilo2.join();
		
		System.out.println("FIN DE TODOS LOS HILOS");
	}

}
