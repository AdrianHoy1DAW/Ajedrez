package chess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import entrada.Herramientas;
import modelo.Color;
import modelo.Player;
import sockets.Message;

public class ChessClient {

	private String ip;
	private int port;
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	private Player player;

	public static void main(String[] args) {

		ChessClient cc = new ChessClient();
		cc.run();

	}

	private void run() {
		showStartMenu();

		
		int option;

		do {

			option = Herramientas.pedirInt("Enter option (0-Exit):");
			switch (option) {
			case 1:
				connect();
				getPlayer();
				createGame();
				break;
			case 2:
				connect();
				getPlayer();
				addToGame();
				break;
			default:
				showStartMenu();
				System.out.println("Option not valid. Enter option (0-Exit):");
				break;
			}
		} while (option != 0);

	}

	private void addToGame() {

	}

	private void createGame() {

		Message mIn, mOut;
		mOut = new Message(Message.Type.CREATE_GAME,"Crear un nuevo juego.");
		mOut.setPlayer(player);
		
		mIn = sendMessageAndWaitResponse(mOut);
		
		

	}

	private void connect() {

		ip = Herramientas.pedirString("Introduce la direccion IP: ");
		port = Herramientas.pedirInt("Introduce el puerto:");

		try {

			this.socket = new Socket(ip, port);

			this.ois = new ObjectInputStream(socket.getInputStream());
			this.oos = new ObjectOutputStream(socket.getOutputStream());

			System.out.println("Conexion establecida correctamente!!");	
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void getPlayer() {

		String nombre = Herramientas.pedirString("Dame tu nombre");

		String c = Herramientas.pedirString("Dime tu color [w|b]:").toLowerCase().substring(0, 1);
		try {
			if (c.equals("b"))
				player = new Player(nombre, Color.BLACK,
						InetAddress.getByName(socket.getRemoteSocketAddress().toString()));
			else
				player = new Player(nombre, Color.WHITE,
						InetAddress.getByName(socket.getRemoteSocketAddress().toString()));

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private Message sendMessageAndWaitResponse(Message mOut) {

		Message mIn = null;

		try {

			oos.writeObject(mOut);
			mIn = (Message) ois.readObject();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return mIn;
	}

	private void showStartMenu() {

		update();
		System.out.println(" ╔════════════════════════════╗");
		System.out.println(" ║            Menu            ║");
		System.out.println(" ╟────────────────────────────╢");
		System.out.println(" ║      1- Create game        ║");
		System.out.println(" ║      2- Add to game        ║");
		System.out.println(" ╟────────────────────────────╢");
		System.out.println(" ║      0- Exit               ║");
		System.out.println(" ╚════════════════════════════╝");

	}

	private void update() {
		System.out.flush();
	}

}
