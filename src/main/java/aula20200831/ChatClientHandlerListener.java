package aula20200831;

public interface ChatClientHandlerListener {
	
	void handleLogin(String username);
	void handleMessage(String username, String message);

}
