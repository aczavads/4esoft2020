package aula20200803.introducaoIO;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class EchoServer {
	private final int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		EchoServer server = new EchoServer();
		server.listen();
	}

	private void listen() throws IOException {
		ServerSocket socket = null;
		try {
			System.out.println("Starting server...");
			socket = new ServerSocket(PORT);
			System.out.println("Server listening...");
			while (true) {
				Socket connection = socket.accept();
				
				handleClientCommunication(connection);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
				System.out.println("Socket closed.");
			}
		}		
		System.out.println("Server is down.");
	}

	private void handleClientCommunication(Socket connection) throws IOException {
		Scanner input = new Scanner(connection.getInputStream());
		PrintWriter output = new PrintWriter(connection.getOutputStream());
		String request = input.nextLine();				
		String response = ">>> " + request + ": " + new Date().toLocaleString();
		output.println(response);
		output.flush();
	}

}
