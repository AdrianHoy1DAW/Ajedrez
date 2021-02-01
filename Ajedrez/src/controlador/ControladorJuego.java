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
				turnoJugador(Color.WHITE);
			
			case BLACK:
				turnoJugador(Color.BLACK);
				
			}
		}
		
		
	}
	
	public void turnoJugador(Color color) {
		Coordenada coordenada = null;
		Coordenada destino = null;
		boolean sePuedeMover = false;
		
		while(sePuedeMover == false) {
			System.out.println(tablero.Print(turno));
			Herramientas.Mensaje("Qué ficha quieres mover");
			coordenada = Herramientas.obtenerCoordenada();
			if(tablero.getCelda(coordenada).contienePieza() == true) {
				if(tablero.getCelda(coordenada).getPieza().canMove() == true) {
					sePuedeMover = true;
				} else {
					Herramientas.Mensaje("Esa ficha no se puede mover");
				}
			} else {
				Herramientas.Mensaje("En esa posición no hay una ficha");
			}
		}
		
		
		while(turno == color) {
				if(tablero.getCelda(coordenada).getPieza().getColor() == turno) {
					Herramientas.Mensaje("A donde la quieres mover");
					destino = Herramientas.obtenerCoordenada();
					if(tablero.getCelda(coordenada).getPieza().cantMoveTo(destino)) {
						tablero.move(coordenada, destino);
						CambiarTurno();
					} else {
						Herramientas.Mensaje("No se puede mover ahí");
					}
				} else {
					Herramientas.Mensaje("Esa pieza no es de tu color");
				}
					
			} 
		}
	
	
	private void CambiarTurno() {
		turno = Color.values()[(turno.ordinal() +1) % Color.values().length];
	}
	
	
	
	
	
	
	
}
