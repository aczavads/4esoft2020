package composite.veiculo;

import java.util.ArrayList;
import java.util.List;

public class UnidadeDePotenciaComposite implements UnidadeDePotencia {
	private List<UnidadeDePotencia> unidadesDePotencia = new ArrayList<>();

	public void addUnidadeDePotencia(UnidadeDePotencia unidadeDePotencia) {
		this.unidadesDePotencia.add(unidadeDePotencia);
	}

	@Override
	public double fornecer() {
		return unidadesDePotencia.stream().map(udp -> udp.fornecer()).reduce((atual, total) -> total + atual).get();
	}

}
