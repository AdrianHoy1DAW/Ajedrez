package controlador;

import entrada.Coordenada;
import entrada.Herramientas;
import modelo.Color;
import modelo.Jugador;
import modelo.Tablero;

public class ControladorJuego {

	private Jugador playerWhite;
	private Jugador playerBlack;
	private Tablero tablero;
	private Color turno;
	
	
	public ControladorJuego(Jugador playerWhite, Jugador playerBlack) {
		super();
		this.playerWhite = playerWhite;
		this.playerBlack = playerBlack;
		tablero = new Tablero();
		turno = Color.WHITE;
	}
	
	public void go() {
		String a = "A";
		String b = "B";
		while(a != b) {
			switch(turno) {
			case WHITE:
				turnoJugador();
			
			case BLACK:
				turnoJugador();
				
			}
		}
		
		
	}
	
	public void turnoJugador() {
		Coordenada coordenada = null;
		Coordenada destino = null;
		
		while(turno == Color.WHITE) {
			System.out.println(tablero.Print(turno));
			Herramientas.Mensaje("Qué ficha quieres mover");
			coordenada = Herramientas.obtenerCoordenada();
			if(tablero.getCelda(coordenada).contienePieza() == true) {
				if(tablero.getCelda(coordenada).getPieza().getColor() == Color.WHITE) {
					Herramientas.Mensaje("A donde la quieres mover");
					destino = Herramientas.obtenerCoordenada();
					if(tablero.getCelda(coordenada).getPieza().cantMoveTo(destino)) {
						tablero.move(coordenada, destino);
						CambiarTurno();
					}	
				}
					
			}
		}
	}
	
	private void CambiarTurno() {
		turno = Color.values()[(turno.ordinal() +1) % Color.values().length];
	}
	
	
	
	
	
	
	
}
