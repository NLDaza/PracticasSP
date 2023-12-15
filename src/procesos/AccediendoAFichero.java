package procesos;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AccediendoAFichero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leer_Fichero lector = new Leer_Fichero();
		lector.lee();
		Escribir_Fichero escritor = new Escribir_Fichero();
		escritor.escribe();
	}
}
	class Leer_Fichero{
		public void lee() {
			try {
				FileReader fr = new FileReader("C:/Users/Usuario/Desktop/Hola.txt/");
				int letra;
				
				while((letra=fr.read()) !=-1) {
				
					char letracorrecta = (char) letra;
					System.out.print(letracorrecta);
				}
				fr.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class Escribir_Fichero{
		public void escribe() {
			String frase = "Probando escritura en fichero";
			
			try {
				FileWriter fw = new FileWriter("C:/Users/Usuario/Desktop/Hola.txt/", true);
				
				//El foreach para cuando sabes cuantas veces tienes que hacerlo
				/*for (iterable_type iterable_element : iterable) {
					
				}*/
				
				for(int i=0; i<frase.length();i++) {
					fw.write(frase.charAt(i));
				}
				fw.close();
				
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}


