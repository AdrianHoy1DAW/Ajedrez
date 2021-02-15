package sockets;


public class GestionMensajes {

	public GestionMensajes() {

	}

	public Message procesInput(Message m) {
		Message out = null;

		switch (m.getMessageType()) {
		
		case CREATE_GAME:
			
			break;
		}

		return out;
	}

}