package aula20200810.resposta;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class FileClient {
	
	private static final String SERVER_ADDRESS = "localhost";
	private static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		FileClient client = new FileClient();
		client.doIt();
	}

	private void doIt() throws Exception {
		InputStream consoleInput = System.in;
		OutputStream consoleOutput = System.out;
		
		
		String comando = "";
		Scanner scannerConsole = new Scanner(consoleInput);
		while (!comando.equalsIgnoreCase("sair")) {
			System.out.print("Digite um comando>>  ");
			comando = scannerConsole.nextLine();
			
			String response = handleServerCommunication(comando);			
			
			System.out.println(response);
		}
		System.out.println("Saiu.");
	}

	private String handleServerCommunication(String comando) throws UnknownHostException, IOException {
		Socket connection = new Socket(SERVER_ADDRESS, PORT);			
		Scanner serverInput = new Scanner(connection.getInputStream());
		PrintWriter serverOutput = new PrintWriter(connection.getOutputStream());
		serverOutput.println(comando);
		serverOutput.flush();			
		String response = serverInput.nextLine();
		response = response.replaceAll("<<quebra>>", "\\\n");
		connection.close();
		return response;
	}

}
