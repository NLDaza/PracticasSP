package hilosparametros;

public class LanzadorHiloContador {

	public static void main(String[] args) {
		
		//Creamos un array con 5 hilos
		//Implementando runnable
		HiloContador arrayHilos[] = new HiloContador[5];
		
		//Los lanzamos
		for(int i=0; i<5; i++) {
			arrayHilos[i]= new HiloContador("Hilo " + i);
			arrayHilos[i].setLimite(2);
			Thread hilo = new Thread(arrayHilos[i]);
			//Cada hilo tendrá un nombre
			hilo.start();
		}
		
		
		
		//Cada hilo contara hasta X (Siendo X un argumento que se le pasara como parametro)

	}

}
