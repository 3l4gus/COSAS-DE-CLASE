package explicacionHilos2;

public class Expli1 {
	public static void main(String[] args) throws InterruptedException {
		Runnable tarea = new Runnable() {

			@Override
			public void run() {
				System.out.println("El hilo está trabajando");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("El hilo terminó");
			}
		};
		
		// Creamos el hilo
		Thread hilo = new Thread(tarea, "hilo");
		
		// Consultamos el estado antes del start
		System.out.println("Estado antes de emepezar: " + hilo.getState());
		
		// Iniciamos hilo
		hilo.start();
		
		// Consultamos estado mientras trabaja
		System.out.println("Mientras trabaja: " + hilo.getState());
		
		// Esperamos a que el hilo termine
		hilo.join();
		
		System.out.println("Estado final: " + hilo.getState());
		
		System.out.println("FIN");
	}
}
