package test;

import entrada.Coordenada;
import modelo.Color;
import modelo.Pieza;
import modelo.Tablero;
import modelo.Tipo;

public class test {

	public static void main(String[] args) {
		
		Coordenada origen = new Coordenada('D',5);
		Coordenada destino = new Coordenada('D',7);
		Coordenada origen2 = new Coordenada('D', 8);
		Coordenada destino2 = new Coordenada('D', 7);
		Coordenada destino3 = new Coordenada('D', 2);
		Tablero t = new Tablero();
		
		
		
//		System.out.println(t.getCelda(c).getPieza().getNextMoves());
		
		t.getCelda(origen).getPieza().move(destino);
		t.getCelda(origen2).getPieza().move(destino2);
		t.getCelda(destino2).getPieza().move(destino3);
		System.out.println(t.Print(Color.WHITE));
		
		
		
		
		
		

	}

}
