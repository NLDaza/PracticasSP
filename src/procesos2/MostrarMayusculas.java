package procesos2;

public class MostrarMayusculas {

	public static void main(String[] args) {
		
		//si no recibe parámetros, el hijo devuelve un 1
		if (args.length != 1)
			{
			System.out.println("Parámetros incorrectos");
			System.exit(1);
			}
		else {
			//Si la cadena contiene algún número devolveremos un 2
			String frase = args[0];
			for(Character letra:frase.toCharArray()) {
				if(Character.isDigit(letra)) {
					System.out.println("Hay números en la cadena: "+ frase);
					System.exit(2);
				}
			}
			
			//todo esta correcto
			System.out.println("La frase en mayusculas es: " + frase.toUpperCase());
			System.exit(0);
		}

	}

}
