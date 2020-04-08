package observer.cofreRefatorado;

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
			if (listener instanceof FechamentoDoCofreListener) {
				listener.notificar();
			}
		}
	}

	public void abrir(int senhaInformada) {
		if (senhaInformada == this.senha) {
			this.aberto = true;
			this.listeners.stream().filter(l -> l instanceof AberturaDoCofreListener).forEach(l -> l.notificar());
		} else {
			this.listeners.stream().filter(l -> l instanceof SenhaDoCofreIncorretaListener).forEach(l -> l.notificar());
		}
	}

	public void addListener(AberturaDoCofreListener listener) {
		this.listeners.add(listener);
	}
	public void addListener(FechamentoDoCofreListener listener) {
		this.listeners.add(listener);
	}
	public void addListener(SenhaDoCofreIncorretaListener listener) {
		this.listeners.add(listener);
	}

}




