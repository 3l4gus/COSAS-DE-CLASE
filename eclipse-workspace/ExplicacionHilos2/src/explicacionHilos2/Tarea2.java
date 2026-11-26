package explicacionHilos2;

// En esta clase definimos la tarea del hilo
public class Tarea2 implements Runnable{

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
	
}
