package chess;

import java.util.Scanner;

import controlador.ControladorJuego;

import modelo.Player;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		Player j1 = new Player("Hoyos");
		Player j2 = new Player("Martín");
		ControladorJuego cj = new ControladorJuego(j1, j2);
		
		
		cj.go();
	
		
		
		
		
	}

}
