package hiloscooperativos;
import java.util.Random;

public class Pruebas {
    public static void main(String[] args) {
        // Crear array de 3650 posiciones
        int[] temperaturas = new int[3650];

        // Llenar el array con temperaturas aleatorias entre -30 y 50
        llenarArrayConTemperaturas(temperaturas, -30, 50);

        // Número de partes en las que se divide el array (puedes ajustar esto según sea necesario)
        int numPartes = 5;

        // Crear un array de objetos HiloTemperatura
        HiloTemperatura[] arrayHilos = new HiloTemperatura[numPartes];

        // Tamaño de cada parte
        int tamanoParte = temperaturas.length / numPartes;

        // Inicializar e iniciar cada hilo
        for (int i = 0; i < numPartes; i++) {
            int inicio = i * tamanoParte;
            int fin = (i == numPartes - 1) ? temperaturas.length : (i + 1) * tamanoParte;
            arrayHilos[i] = new HiloTemperatura(temperaturas, inicio, fin);
            arrayHilos[i].start();
           
        }

        // Esperar a que todos los hilos terminen
        try {
            for (HiloTemperatura hilo : arrayHilos) {
                hilo.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontrar la temperatura máxima global
        int temperaturaMaximaGlobal = Integer.MIN_VALUE;
        for (HiloTemperatura hilo : arrayHilos) {
            int temperaturaMaximaHilo = hilo.getTemperaturaMaxima();
            temperaturaMaximaGlobal = Math.max(temperaturaMaximaGlobal, temperaturaMaximaHilo);
        }

        // Imprimir la temperatura máxima global
        System.out.println("Temperatura máxima de los últimos 10 años = " + temperaturaMaximaGlobal);
    }
    
    

    // Método para llenar el array con temperaturas aleatorias
    private static void llenarArrayConTemperaturas(int[] array, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt((max - min) + 1) + min;
        }
    }
}

// Clase que extiende Thread para buscar la temperatura máxima en una parte del array
class HiloTemperatura extends Thread {
    private int[] temperaturas;
    private int inicio;
    private int fin;
    private int temperaturaMaxima = Integer.MIN_VALUE;

    public HiloTemperatura(int[] temperaturas, int inicio, int fin) {
        this.temperaturas = temperaturas;
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = inicio; i < fin; i++) {
            temperaturaMaxima = Math.max(temperaturaMaxima, temperaturas[i]);
        }
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }
}