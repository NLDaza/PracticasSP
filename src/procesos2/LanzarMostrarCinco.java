package procesos2;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LanzarMostrarCinco {

	public static void main(String[] args) {
		
		try {
		//Para obtener desde el teclado
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce una cadena");
		String cadena = sc.nextLine();
		
		//Creamos proceso
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("java", "procesos2.MostrarCinco", cadena);
		
		//Directorio
		File directorio = new File("./bin");
		pb.directory(directorio);
		
		//Redireccionamos la salida
		
		pb.redirectOutput(new File("./src/procesos2/Resultados.txt"));
		
		//Creamos el proceso
		
			Process p = pb.start();
			
			int codigo = p.waitFor();
			
			System.out.println("Finalizado con codigo " + codigo);
			
			sc.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
