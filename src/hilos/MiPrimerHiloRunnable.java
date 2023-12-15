package hilos;

public class MiPrimerHiloRunnable implements Runnable{

private String nombre;
	
	

	public MiPrimerHiloRunnable(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public void run() {
		for(int x=10; x<20;x++)
			System.out.println(this.nombre + ": " +x);
	}
}
