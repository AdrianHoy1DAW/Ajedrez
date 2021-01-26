package modelo;

import entrada.Coordenada;

public class Tablero {

	private Celda[][] tablero;
	private Lista<Pieza> blancas;
	private Lista<Pieza> negras;
	private Lista<Pieza> blancasEliminadas;
	private Lista<Pieza> negrasEliminadas;
	
	public Tablero(){
		tablero = new Celda[8][8];
		blancas = new Lista<Pieza>();
		negras = new Lista<Pieza>();
		this.blancasEliminadas = new Lista<Pieza>();
		this.negrasEliminadas = new Lista<Pieza>();
		inicializar();
		
	}
	
	private void inicializar() {
		
		for(int fila = 0; fila < tablero.length; fila ++) {
			for(int col = 0; col < tablero[0].length; col++) {
				tablero[fila][col] = new Celda();
			}
		}
		
//		//Colocar las piezas
				negras.addHead(new Rook(Color.BLACK,new Coordenada('A',8),this));
				negras.addHead(new Knight(Color.BLACK,new Coordenada('B',8),this));
				negras.addHead(new Bishop(Color.BLACK,new Coordenada('C',8),this));
				negras.addHead(new Queen(Color.BLACK,new Coordenada('D',8),this));
				negras.addHead(new King(Color.BLACK,new Coordenada('E',8),this));
				negras.addHead(new Bishop(Color.BLACK,new Coordenada('F',8),this));
				negras.addHead(new Knight(Color.BLACK,new Coordenada('G',8),this));
				negras.addHead(new Rook(Color.BLACK,new Coordenada('H',8),this));
				for(int i = 0; i < tablero.length; i ++) {
					negras.addHead(new Pawn(Color.BLACK,new Coordenada((char) ('A' + i),7),this));
			}
				
				blancas.addHead(new Rook(Color.WHITE,new Coordenada('A',1),this));
				blancas.addHead(new Knight(Color.WHITE,new Coordenada('B',1),this));
				blancas.addHead(new Bishop(Color.WHITE,new Coordenada('C',1),this));
				blancas.addHead(new Queen(Color.WHITE,new Coordenada('D',5),this));
				blancas.addHead(new King(Color.WHITE,new Coordenada('E',1),this));
				blancas.addHead(new Bishop(Color.WHITE,new Coordenada('F',1),this));
				blancas.addHead(new Knight(Color.WHITE,new Coordenada('G',1),this));
				blancas.addHead(new Rook(Color.WHITE,new Coordenada('H',1),this));
				for(int i = 0; i < tablero.length; i ++) {
					blancas.addHead(new Pawn(Color.WHITE,new Coordenada((char) ('A' + i),2),this));
				}
		
	
				
		
	}
	
	public boolean coordenadaEnTablero(Coordenada c) {
		return !(c.getEjeX() < 'A' || c.getEjeY() < 1 || c.getEjeX() > 'H' || c.getEjeY() > 8);
	}
	

	
	public Celda getCelda(Coordenada coordenada) {
		
		if(this.coordenadaEnTablero(coordenada)) 
			return tablero[8 - coordenada.getEjeY()][coordenada.getEjeX() - 'A'];
		
		return null;
	}
	
	public void saveRemovedPiece(Pieza p) {
		
		if(p.getColor() == Color.WHITE) {
			blancas.getAndRemove(p);
			blancasEliminadas.addHead(p);
			
		} else {
			negras.getAndRemove(p);
			negrasEliminadas.addHead(p);
		}
		
	}
	
	
	
	public String Print(Color color) {
		switch(color) {
		case WHITE: 
			return PrintAsWhite();
			
		case BLACK: 
			return PrintAsBlack();
		default: 
			return "";
			
		}
	}
	
	private String PrintAsBlack() {
		String visualizar = "";
		for(int fila = 8; fila > -2; fila --) {
			for(int col = 0; col <tablero[0].length +9; col++) {
				if(fila == -1) {
					visualizar += "╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝";
					col = tablero[0].length + 9;
				} else {
				if(fila == 8) {
					visualizar = "╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗";
					col = tablero[0].length + 9;
				} else {
					if(col == 0 || col == 16)
						visualizar += "║";
					else if (col%2 == 0){
						visualizar += "│";
					} else {
						visualizar += " " + tablero[fila][col/2] + " ";
					}
					
				}
				
					
				
		
		}
			}
			if(fila == -1 ) {
				visualizar += "";
			} else if(fila == 8 || fila == 0) {
				visualizar += "\n";
			} else {
			
				visualizar += "\n";
				visualizar += "╟───┼───┼───┼───┼───┼───┼───┼───╢";
				visualizar += "\n";
			}
			
				
			
		}
		visualizar += "\n" + "blancas Eliminadas: " + blancasEliminadas + "\n";
		visualizar += "\n" + "negras Eliminadas: " + negrasEliminadas + "\n";
		visualizar += "\n" + "negras: " + negras + "\n";
		visualizar += "\n" + "blancas: " + blancas + "\n";
		
		return visualizar;
	
	
		
	}
	
	
	
	
	

	private String PrintAsWhite() {
		String visualizar = "";
		for(int fila = -1; fila < tablero.length +1; fila ++) {
			for(int col = 0; col <tablero[0].length +9; col++) {
				if(fila == 8) {
					visualizar += "╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝";
					col = tablero[0].length + 9;
				} else {
				if(fila == -1) {
					visualizar = "╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗";
					col = tablero[0].length + 9;
				} else {
					if(col == 0 || col == 16)
						visualizar += "║";
					else if (col%2 == 0){
						visualizar += "│";
					} else {
						visualizar += " " + tablero[fila][col/2] + " ";
					}
					
				}
				
					
				
		
		}
			}
			if(fila == 8 ) {
				visualizar += "";
			} else if(fila == -1 || fila == 7) {
				visualizar += "\n";
			} else {
			
				visualizar += "\n";
				visualizar += "╟───┼───┼───┼───┼───┼───┼───┼───╢";
				visualizar += "\n";
			}
			
			
			
				
			
		}
		
		visualizar += "\n" + "blancas Eliminadas: " + blancasEliminadas + "\n";
		visualizar += "\n" + "negras Eliminadas: " + negrasEliminadas + "\n";
		visualizar += "\n" + "negras: " + negras + "\n";
		visualizar += "\n" + "blancas: " + blancas + "\n";
		
		
		
		return visualizar;
	
	
		
	}
	
	
	
	public Lista<Pieza> getBlancas() {
		return blancas;
	}

	public Lista<Pieza> getNegras() {
		return negras;
	}

	public void pruebas() {

		
		
	}
	
	
	public boolean blackCheck() {
		
		
		

			return false;
	}
	
	public boolean whiteCheck() {
		
		return false;
	}
}
