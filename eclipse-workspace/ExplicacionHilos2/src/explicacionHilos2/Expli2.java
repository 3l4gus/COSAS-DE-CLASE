package explicacionHilos2;

public class Expli2 {
	public static void main(String[] args) throws InterruptedException {
		
		// Creamos objeto de la clase tarea
		Tarea2 tarea = new Tarea2();
		
		// Creamos el hilo asociado a la tarea
		Thread hilo = new Thread(tarea, "hilo1");
		
		// Comprobamos el estado final
		System.out.println("Estado inicial: " + hilo.getState());
		
		// Iniciamos hilo
		hilo.start();
		
		// Comprobamos si está vivo
		System.out.println("Esta vivo? " + hilo.isAlive());
		
		// Comprobamos estado
		System.out.println("Estado medio: " + hilo.getState());
		
		// Esperamos a que el hilo termine
		hilo.join();
		
		// Comprobamos estado
		System.out.println("Estado final: " + hilo.getState());
	}
}
