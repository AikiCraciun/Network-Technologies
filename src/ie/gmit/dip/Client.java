package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String userName;
	
	public Client(Socket socket, String userName) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.userName = userName;
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	
	public void sendMessage() {
		try {
			bufferedWriter.write(userName);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		
			Scanner scanner = new Scanner(System.in);
			while (socket.isConnected()) {
				String messageToSend = scanner.nextLine();
				
				if (messageToSend.contains("quit")) {
					bufferedWriter.write(userName + ": " + "quit");
					bufferedWriter.newLine();
					bufferedWriter.flush();
					closeEverything(socket, bufferedReader, bufferedWriter);
					scanner.close();
					System.exit(0);
					break;
				}
				bufferedWriter.write("[" + userName + "]" + ": " + messageToSend);
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
		} catch (IOException e) {
			closeEverything(socket, bufferedReader, bufferedWriter);
		}
	}
	
	
	private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
		try {
			if(bufferedReader != null) {
				bufferedReader.close();
			}
			if(bufferedWriter != null) {
				bufferedWriter.close();
			}
			if(socket != null) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listenForMessage() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				String msgFromGroupChat;
				
				while(socket.isConnected()) {
					try {
						msgFromGroupChat = bufferedReader.readLine();
						if(msgFromGroupChat.contains("quit")) {
							closeEverything(socket, bufferedReader, bufferedWriter);
							System.exit(0);
							break;
						}
						System.out.println(msgFromGroupChat);
					} catch (IOException e) {
						closeEverything(socket, bufferedReader, bufferedWriter);
					}
				}
			}
		}).start();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your username for the group chat: ");
		String userName = scanner.nextLine();
		
		//scanner.close();
		
		Socket socket = new Socket("localhost", 9090);
	
		Client client = new Client(socket, userName); 
		client.listenForMessage();
		client.sendMessage();
		
		scanner.close();
	}
}
