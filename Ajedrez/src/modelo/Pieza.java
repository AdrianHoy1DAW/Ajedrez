package modelo;

import entrada.Coordenada;

public abstract class Pieza {

	protected Tipo tipo;
	protected Tablero tablero;
	protected Coordenada posicion;

	
	public Pieza(Coordenada posicion, Tablero tablero) {
		super();
		this.posicion = posicion;
		this.tablero = tablero;
		colocate(posicion);
	}
	
	private void colocate(Coordenada c) {
		
		tablero.getCelda(posicion).setPieza(null);
		posicion = c;
		tablero.getCelda(posicion).setPieza(this);
		
	}
	
	public boolean cantMoveTo(Coordenada c) {
		
		return getNextMoves().contains(c);
		
	}
	
	public void move(Coordenada c) {
		
		if(tablero.getCelda(c).contienePieza()) 
			tablero.saveRemovedPiece(tablero.getCelda(c).getPieza());
			
			

		colocate(c);
		
			
			
			
		
		
	}
	
	
	public Color getColor() {
		return tipo.getColor();
	}
	
	


	public Coordenada getPosicion() {
		return posicion;
	}
	
	

	@Override
	public String toString() {
		return tipo.getForma();
	}
	
	public abstract Lista<Coordenada> getNextMoves();

	
	
	
	
	
}
