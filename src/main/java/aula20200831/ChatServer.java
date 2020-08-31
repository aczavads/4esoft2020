package aula20200831;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int PORT = 8080;
	private List<ChatClientHandler> clientHandlers = new ArrayList<>();
	
	public static void main(String[] args) {
		ChatServer server = new ChatServer();
		server.listen();
	}

	private void listen() {
		try (ServerSocket socket = new ServerSocket(PORT)) {
			while (true) {
				ChatClientHandler client = new ChatClientHandler(socket.accept(), new ChatClientHandlerListener() {
					@Override
					public void handleMessage(String username, String message) {
						for (ChatClientHandler chatClientHandler : clientHandlers) {
							chatClientHandler.send(">> " + username + ": " + message);
						}
					}
					@Override
					public void handleLogin(String username) {
						for (ChatClientHandler chatClientHandler : clientHandlers) {
							chatClientHandler.send("New user logged in: " + username);
						}
					}
				});
				clientHandlers.add(client);
				client.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
