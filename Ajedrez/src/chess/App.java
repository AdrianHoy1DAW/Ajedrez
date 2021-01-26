package chess;

import java.util.Scanner;

import controlador.ControladorJuego;
import modelo.Jugador;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Jugador blancas, negras;
		String nombre;
		ControladorJuego cj;
		
		Scanner sc = new Scanner(System.in);
		nombre = sc.nextLine();
		
		System.out.println("Dame el nombre del jugador de las blancas ");
		blancas = new Jugador(nombre);
		
		System.out.println("Dame el nombre del jugador de las negras ");
		negras = new Jugador(nombre);
		
		cj = new ControladorJuego(blancas,negras);
		
		cj.go();
		
		
		
		
	}

}
