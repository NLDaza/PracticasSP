package procesos;

import java.io.IOException;

public class MiPrimerProceso {

	public static void main(String[] args) {
		
		ProcessBuilder pb = new ProcessBuilder("C:\\Windows\\system32\\notepad.exe");
		
		try {
			 pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*Runtime rt = Runtime.getRuntime();
		
		try {
			rt.exec("calc.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

}
