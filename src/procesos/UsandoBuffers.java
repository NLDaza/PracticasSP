package procesos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UsandoBuffers {

	public static void main(String[] args) {
		LectorBuffer lector = new LectorBuffer();
		lector.lee();
		EscritorBuffer escritor = new EscritorBuffer();
		escritor.escribe();

	}

}
class EscritorBuffer{
	public void escribe(){
		try {
			FileWriter fw = new FileWriter("C:/Users/Usuario/Desktop/Hola.txt/", true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write("Esto es una prueba");
			bw.newLine();
			bw.write("Esto es una prueba numero 2");
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class LectorBuffer{
	public void lee() {
		try {
			FileReader fr = new FileReader("C:/Users/Usuario/Desktop/Hola.txt/");
			BufferedReader br = new BufferedReader(fr);
			
			String linea = "";
			
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			br.close();
			fr.close();
			//Se cierra en este orden para que no de problemas
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
