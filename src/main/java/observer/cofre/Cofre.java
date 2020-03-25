package observer.cofre;

import java.util.ArrayList;
import java.util.List;

public class Cofre {

	private int senha;
	private boolean aberto;
	private List<CofreListener> listeners = new ArrayList<>();

	public Cofre(int senha) {
		this.senha = senha;
		this.aberto = true;
	}

	public boolean isAberto() {
		return this.aberto;
	}

	public void fechar() {
		this.aberto = false;
		for (CofreListener listener : this.listeners) {
			listener.cofreFoiFechado();
		}
	}

	public void abrir(int senhaInformada) {
		if (senhaInformada == this.senha) {
			this.aberto = true;
			this.listeners.forEach(l -> l.cofreFoiAberto());
		}		
	}

	public void addListener(CofreListenerConsole listener) {
		this.listeners.add(listener);
	}

}
