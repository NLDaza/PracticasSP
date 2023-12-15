package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SegundoProceso {

	public static void main(String[] args) {
		
		//1.Creamos el processBuilder
		ProcessBuilder pb = new ProcessBuilder ("cmd", "/c","dir");
		
		try {
			Process p = pb.start();
			//Continuamos en el siguiente video
			//Creamos un Stream de Lectura para leer la salida del hijo, InputStream porque es la entrada del padre, y Reader porque lee la salida del hijo
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			
			//Se lee la salida del datos del hijo, el proceso P
			//Usamos un bufferreader para leer todos los datos
			
			BufferedReader br = new BufferedReader(isr);
			
			//igual que antes pasabamos el filereader, esta vez se usa un stream, funciona exactamente igual
			
			String linea = "";
			
			while((linea = br.readLine()) != null) {
				System.out.println(linea);
			}
			
			int codigo = p.waitFor();
			System.out.println("Proceso terminado correctamente con codigo " + codigo);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
