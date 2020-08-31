package aula20200810.resposta;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class FileServer {
	private final int PORT = 8080;
	
	public static void main(String[] args) throws IOException {
		FileServer server = new FileServer();
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
		String response = "";
		if (request.equalsIgnoreCase("listar")) {
			response = listFilesToClient(output);
		} else {
			response = ">>> " + request + ": " + new Date().toLocaleString();
		}
		output.println(response);
		output.flush();
	}

	private String listFilesToClient(PrintWriter output) {
		StringBuffer listagem = new StringBuffer();
		listarArquivosNoConsole(listagem, new File("/home/arthur/server"), ">");
		return listagem.toString();
	}
	
	private static void listarArquivosNoConsole(StringBuffer listagem, File diretório, String nível) {
		File[] arquivos = diretório.listFiles();
		for (File file : arquivos) {
			listagem.append(nível + " " + file.getName() + "<<quebra>>");
			if (file.isDirectory()) {
				listarArquivosNoConsole(listagem, file, nível + ">");
			}
		}
	}

}
