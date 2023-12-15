package hilosparametros;

public class LanzadorHola {

	public static void main(String[] args) throws InterruptedException {
		
		//Vamos a crear un programa que mediante 4 hilos sincronizados saque por pantalla 
		//O: Hola, 1:hola... Cada hilo imprimira una letra y se sincronizaran para obtener la palabra hola
		HiloH h1 = new HiloH();
		Thread t1 = new Thread(h1);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloO h2 = new HiloO();
		Thread t2 = new Thread(h2);
		t2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloL h3 = new HiloL();
		Thread t3 = new Thread(h3);
		t3.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		HiloA h4 = new HiloA();
		Thread t4 = new Thread(h4);
		t4.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
