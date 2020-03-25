package observer.cofre;

import java.util.Date;

public class CofreListenerConsole implements CofreListener {

	@Override
	public void cofreFoiAberto() {
		System.out.println("O cofre foi aberto: " + new Date().toLocaleString());
	}

	@Override
	public void cofreFoiFechado() {
		System.out.println("O cofre foi fechado: " + new Date().toLocaleString());		
	}

}
