package hilos;

public class BuclesHilos2 extends Thread{
	
	private String nombre;
	
	

	public BuclesHilos2(String nombre) {
		super(nombre);
	}

	@Override
	public void run() {
		for(int x=5; x<10;x++)
			System.out.println(this.getName() + ": " +x);
	}
	

}

