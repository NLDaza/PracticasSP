package hilos;

public class Bucles {

	public static void main(String[] args) {
		
		BuclesHilos h1 = new BuclesHilos("Cuenta 5");
		
		BuclesHilos2 h2 = new BuclesHilos2("Cuenta 10");
		
		MiPrimerHiloRunnable h3 = new MiPrimerHiloRunnable("Cuenta mas de 10");
		
		Thread HiloRunnable = new Thread(h3);
		
		h1.start();
		h2.start();
		HiloRunnable.start();
	}

}
