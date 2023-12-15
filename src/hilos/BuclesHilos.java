package hilos;

public class BuclesHilos extends Thread{
	
	private String nombre;
	
	

	public BuclesHilos(String nombre) {
		super(nombre);
	}

	@Override
	public void run() {
		for(int x=0; x<5;x++)
			System.out.println(this.getName() + ": " +x);
	}
	

}
