package hilosparametros;

public class HiloL implements Runnable{


	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.print("L");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
