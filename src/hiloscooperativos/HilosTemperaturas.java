package hiloscooperativos;

public class HilosTemperaturas extends Thread{
	//Clase que extiende Thread para buscar la temperatura máxima en una parte del Array
	int [] temp; //Array que contiene las temperaturas 
	int inicio; //Indice del inicio del array de este hilo
	int fin; //Indice del final del array para este hilo
	int temperaturaMax = Integer.MIN_VALUE; //Almacena la temperatura máxima encontrada en el Array
	
	//Constructor que recibe el array de temperaturas y los indices inicio y fin
	public HilosTemperaturas(int[]temp, int inicio, int fin) {
		this.temp=temp;
		this.inicio=inicio;
		this.fin=fin;	
	}
	//Metodo ejecutado cuando inicia el hilo
	@Override
	public void run() { 
		//Utiliza un buble para iterar a través de la sección del array y actualiza temperaturaMax con el valor maximo encontrado
		for (int x = inicio; x < fin; x++ ) {
			temperaturaMax = Math.max(temperaturaMax, temp[x]);
		}
	}
	//Este método proporciona una forma de obtener la temperatura máxima encontrada por este hilo.
	public int getTemperaturaMax() {
		return temperaturaMax;
	}
	//Este método para cambiar la temperatura maxima de ser necesario pero es prescindible
	public void setTemperaturaMax(int temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	
}
