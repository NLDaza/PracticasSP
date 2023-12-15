package hilos;

public class MiPrimerHilo extends Thread{

	private String descripcion;
	private String nombre;
	
	public MiPrimerHilo (String nombre, String desc) {
		super(nombre);
		this.descripcion=desc;
	}

	@Override
	public void run() {
		
		System.out.println("Nuevo Hilo");
		for(int x=11; x<20;x++) {
			System.out.println(descripcion + " hilo: " + this.getName());
		}
	}
	
	
	
	}
