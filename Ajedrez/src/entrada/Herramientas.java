package entrada;

import java.util.Scanner;

public class Herramientas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	
	public static Coordenada obtenerCoordenada() {
		String coordenada = obtenerCadena();
		while(!esCoordenada(coordenada)) {
			coordenada = obtenerCadena();
		}
		
		
		coordenada = coordenada.toUpperCase();
		return new Coordenada(coordenada.charAt(0), Integer.parseInt(String.valueOf(coordenada.charAt(1))));
		
		
		
	}
	
	private static String obtenerCadena() {
		Mensaje("Introduce una coordenada primero poniendo la letra y después el número ");
		String coordenada = pedirString();
		
		if(coordenada.length() == 2) {
			return coordenada;
		} else {
			while(coordenada.length() != 2) {
				System.out.println("Introduce la coordenada correctamente");
				coordenada = pedirString();
		
			}	
		}	
			return coordenada;
		}
	
	
	private static boolean esCoordenada(String coordenada) {
		coordenada = coordenada.toUpperCase();
		if(coordenada.length() != 2)
			return false;
		if(!(coordenada.charAt(0) >= 'A' && coordenada.charAt(0) <= 'J'))
			return false;
		if(!(coordenada.charAt(1)>='0' && coordenada.charAt(1) <= '9' ))
			return false;
		return true;
	}
	
	
	
	public static String pedirString() {
		String pedido = "";
		Scanner sc = new Scanner(System.in);
		
		pedido = sc.nextLine();
		return pedido;
		
		
	}
	
	public static void clear() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	} 
	
	public static  void Mensaje(String mensaje) {
		System.out.println(mensaje);
	}

}
