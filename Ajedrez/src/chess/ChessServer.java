package chess;

import java.io.IOException;
import java.net.ServerSocket;

import sockets.GameManager;

public class ChessServer {

	private int connectionActives;
	private int newIdGame;
	
	private int portNumber;
	private boolean listening = true;
	
	public ChessServer(int portNumber) {
		
		this.connectionActives = 0;
		this.newIdGame = 1;
		this.listening = true;
		this.portNumber = portNumber;
		
	}
	
	public static void main(String[] args) {
		
		int port;
		try {
			port = Integer.parseInt(args[0]);
		}	catch (Exception e) {
			port = 6000;
		}
		
		ChessServer chs = new ChessServer(port);
		chs.run();
		
		
			
		
	}

	private void run() {
		
		System.out.println("ServerSocket trying to start on the port " + portNumber);
		
		try(ServerSocket ss = new ServerSocket(portNumber)) {
			
			while(listening) {
				
				new Thread(new GameManager(ss.accept(),this)).start();
				System.out.println("Connection nº" + (++ this.connectionActives));
				
			}
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
