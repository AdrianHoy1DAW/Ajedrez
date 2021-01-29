package chess;

import java.util.Scanner;

import controlador.ControladorJuego;
import modelo.Jugador;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		Jugador j1 = new Jugador("Hoyos");
		Jugador j2 = new Jugador("Martín");
		ControladorJuego cj = new ControladorJuego(j1, j2);
		
		
		cj.go();
	
		
		
		
		
	}

}
