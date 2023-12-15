package hiloscooperativos;

import java.util.Random;

public class Temperaturas extends Thread {

    public static int years = 10;
    public static int days = 365 * years;
    private static int [] weather = new int [days];

    private int minimum, maximum;

    public Temperaturas(int min, int max) {
        this.minimum = min;
        this.maximum = max;
    }

    @Override
    public void run()
    {
        this.maximum = weather[weather.length - 1];

        for (int i = 0; i < weather.length; i++)
        {
            if (this.maximum < weather[i])
                this.maximum = weather[i];
        }
    }

    
    public static void main(String[] args) {

        // Genero el array de valores aleatorios
        Random rand = new Random(System.nanoTime());
        for (int i = 0; i < weather.length; i++) {
            weather[i] = rand.nextInt(81) - 30;
        }

        // 't' es un array de objetos de tipo "Temperaturas". Creo uno por cada año.
        Temperaturas [] t = new Temperaturas[years];
        int max = 0;
        for (int i = 0; i < t.length; i++) {
            max += i + (days/years - 1);
            t[i] = new Temperaturas(i + max, max);
            t[i].start();
        }

        // Espero a que los hilos terminen
        try {
            for (int i = 0; i < t.length; i++) {
                t[i].join();
            }
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Recupero los valores de los máximos y busco el máximo entre ellos
        int maximo = t[t.length - 1].maximum;
        for (int i = 0; i < t.length; i++) {
            if (maximo < t[i].maximum)
                maximo = t[i].maximum;
        }
        System.out.println("El valor maximo registrado es " + maximo + " grados.");
    }
}
