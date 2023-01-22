package ie.gmit.dip;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private ServerSocket serverSocket;

	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public void startServer() {
		
		try {
			
			while (!serverSocket.isClosed()) {
				System.out.println("--------------SERVER waiting for connection--------------");
				Socket socket = serverSocket.accept();
				System.out.println("A new client has connected!!");
				
				ClientHandler clientHandler = new ClientHandler(socket);
			
				Thread thread = new Thread(clientHandler);
				
				thread.start();
			}
		} catch (IOException e) {
			System.err.println("IOException in Server.startServer() method.");
		}
	}
	
	
	public void closeServerSocket() {
		try {
			if (serverSocket != null) {
				serverSocket.close(); 
			}
		} catch (IOException e) {
			System.err.println("IOException in Server.closeServerSocket() method.");
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9090);
		Server server = new Server(serverSocket);
		server.startServer();
	}
}
