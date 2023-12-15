package hilosparametros;

public class HiloContador implements Runnable{
	
	private int limite;
	private String nombre;
	
	public HiloContador(String nombre) {
		this.nombre=nombre;
	}

	@Override
	public void run() {
		for (int i=0; i<=limite; i++) {
			System.out.println(i + " " + nombre);
		}
		
	}
	
	public void setLimite (int valor) {
		this.limite=valor;
	}

}
