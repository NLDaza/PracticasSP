package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PingGoogle {
    //El código proporcionado es un ejemplo de cómo utilizar la clase ProcessBuilder en Java para ejecutar un comando en la línea de comandos de Windows y mostrar su salida en la consola.
	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder ("cmd", "/c","ping -n 3 google.es");
		/*En esta línea de código, se crea un objeto de la clase ProcessBuilder y se le pasa como argumento el comando que se desea ejecutar en la línea de comandos de Windows. En este caso, 
		el comando es "ping -n 3 google.es", que se utiliza para enviar tres paquetes de datos a la dirección IP de Google y mostrar la respuesta en la consola.*/
		try {
			Process p = pb.start();//En esta línea de código, se inicia el proceso utilizando el objeto ProcessBuilder creado anteriormente y se almacena en una variable llamada "p".
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			//En estas líneas de código, se crea un objeto InputStreamReader y un objeto BufferedReader para leer la salida del proceso iniciado anteriormente.
			
			String linea = "";
			while((linea = br.readLine()) != null)
			System.out.println(linea);
			/*En estas líneas de código, se lee la salida del proceso línea por línea utilizando el objeto BufferedReader y se imprime en la consola utilizando el 
			método "println" de la clase System. El bucle while se ejecuta mientras la variable "linea" no sea nula, lo que significa que aún hay líneas por leer en la salida del proceso.*/
			
			System.out.println("proceso terminado correctamente");
			//En esta línea de código, se imprime un mensaje indicando que el proceso ha terminado correctamente.
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
