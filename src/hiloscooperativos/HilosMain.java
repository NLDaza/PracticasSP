package hiloscooperativos;

import java.util.Random;

public class HilosMain {

	public static void main(String[] args) {
		int[] temp = new int[3650];//Creamos un array de 3650 de tamaño para representar las temperaturas de los últimos 10 años
		
		llenarArray(temp, -30, 50);//Rellenamos el array de temperaturas aleatorias
		
		for (int i=0; i<10; i++) {
			System.out.println("Temperatura: " + temp[i]);//Imprimimos algunas temperaturas para verificar el array
		
		int arrayPartes = 10;//Dividiremos el array en partes, en este caso escogemos 10 (se puede cambiar)
		
		int tamañoArray = temp.length/ arrayPartes;//Tamaño de cada parte
		}

	}

	private static void llenarArray(int[] array, int min, int max) {
		//Metodo para llenar el array de temperaturas aleatorias
		Random rand = new Random();
		
		for(int i=0; i<array.length; i++) {
			array[i] = rand.nextInt((max - min) + 1) + min;
			/*Aquí, (max - min) + 1 representa el rango de valores que queremos obtener. 
			Sumamos 1 porque el método nextInt genera números hasta n - 1.
			le sumamos min para ajustar el rango. Esto garantiza que el número 
			aleatorio generado esté en el rango [min, max] en lugar de [0, max - min].*/
		}
		
	}

}
