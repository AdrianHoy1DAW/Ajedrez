package sockets;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import chess.ChessServer;

public class GameManager implements Runnable {

	private Socket socket;
	private ChessServer chessServer;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;

	public GameManager(Socket socket, ChessServer chessServer) {
		super();
		this.socket = socket;
		this.chessServer = chessServer;
	}

	@Override
	public void run() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-uuuu H:m:s");
		String instante = LocalDateTime.now().format(dtf);

		System.out
				.println(instante + " -> Connection successful from IP " + socket.getRemoteSocketAddress().toString());

		try {

			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());

			Message mIn, mOut;
			boolean exit = false;
			GestionMensajes gm = new GestionMensajes();

			while (!exit && (mIn = (Message) ois.readObject()) != null) {

				System.out.println("<- GameManager receives: " + mIn.toString());

				mOut = gm.procesInput(mIn);

				System.out.println("-> GameManager receives: " + mOut.toString());
				
				oos.writeObject(mOut);

				if (mOut.getMessageType() == Message.Type.EXIT || mOut.getMessageType() == Message.Type.ADDED_TO_GAME)
					exit = true;

			}

		} catch (Exception e) {

		}

	}

}
