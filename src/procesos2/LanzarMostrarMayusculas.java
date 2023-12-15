package procesos2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class LanzarMostrarMayusculas {

	public static void main(String[] args) {
		
		
		try {
		ProcessBuilder pb = new ProcessBuilder();
		pb.command("java","procesos2/MostrarMayusculas","Hola");
		
		//Directorio, para decirle al programa donde buscar el directorio, ponemos la ruta
		
		File directorio = new File("./bin");
		pb.directory(directorio);
		
		//Creamos el proceso
		
			Process p = pb.start();
			
			InputStreamReader isr = new InputStreamReader(p.getInputStream());
			BufferedReader br =new BufferedReader(isr);
			
			String linea;
			
			while ((linea=br.readLine())!= null){
				System.err.println(linea);
			}
			
			int codigo = p.waitFor();
			
			System.out.println("Finalizado con codigo " + codigo);
			
			br.close();
			isr.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
