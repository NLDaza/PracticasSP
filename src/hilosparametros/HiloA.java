package hilosparametros;

public class HiloA implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("A");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}