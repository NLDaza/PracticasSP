package hiloscooperativos;

import java.util.Random;

public class HilosMain {

	public static void main(String[] args) {
		int[] temp = new int[3650];//Creamos un array de 3650 de tamaño para representar las temperaturas de los últimos 10 años
		
		llenarArray(temp, -30, 50);//Rellenamos el array de temperaturas aleatorias
		
		
		int arrayPartes = 10;//Dividiremos el array en partes, en este caso escogemos 10 (se puede cambiar)
		
		HilosTemperaturas[] arrayHilos = new HilosTemperaturas[arrayPartes];
		
		int tamañoArray = temp.length/ arrayPartes;//Tamaño de cada parte
		
		//Inicializaremos cada hilo
		for (int x = 0; x < arrayPartes; x++) {
			int inicio = x * tamañoArray;  // Calcular el índice de inicio de la sección del array para este hilo
			int fin = Math.min((x + 1) * tamañoArray, temp.length);// Calcular el índice de fin de la sección del array, asegurándose de que no exceda la longitud total del array
			arrayHilos[x] = new HilosTemperaturas(temp, inicio, fin); // Crear un hilo de temperatura para manejar la búsqueda en la sección específica del array
			arrayHilos[x].start();//Iniciar ejecucion del hilo
			
		}
		try {
            for (HilosTemperaturas hilo : arrayHilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//YImprimimos la temperatura maxima de cada año
        int temperaturaMaximaGlobal = Integer.MIN_VALUE;// Inicializar la temperatura máxima global con el valor mínimo posible de un entero
        int año = 2013; // Año inicial, puedes ajustar esto según sea necesario
        
        for (HilosTemperaturas hilo : arrayHilos) { // Iterar a través de todos los hilos en arrayHilos
            int temperaturaMaximaHilo = hilo.getTemperaturaMax();// Obtener la temperatura máxima encontrada por este hilo
            System.out.println("Año: " + año + " - Temperatura máxima " + temperaturaMaximaHilo);
            temperaturaMaximaGlobal = Math.max(temperaturaMaximaGlobal, temperaturaMaximaHilo); // Actualizar la temperatura máxima global usando la temperatura máxima encontrada por este hilo
            año++; // Incrementar el año para el próximo ciclo
        }
     // Imprimir la temperatura máxima global
        System.out.println("Temperatura máxima global " + temperaturaMaximaGlobal);

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