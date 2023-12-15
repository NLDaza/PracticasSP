package hilos;

public class LanzadorHilos {

	public static void main(String[] args) {

        //Lanzamos los hilos que heredan de thread
		MiPrimerHilo h1 = new MiPrimerHilo("Pepito", "Hilo 1");
		h1.start(); //Se encarga de llamar al run() del hilo
		MiPrimerHilo h2 = new MiPrimerHilo("Pepito","Hilo 2");
		h2.start();

	}

}
