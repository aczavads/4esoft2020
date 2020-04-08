package composite.veiculo;

public class AdapterMarsEngineToUnidadeDePotencia implements UnidadeDePotencia {

	private MarsParticleEngine engine;

	public AdapterMarsEngineToUnidadeDePotencia(MarsParticleEngine engine) {
		this.engine = engine;
	}

	@Override
	public double fornecer() {
		return engine.bringTheFlow();
	}

}
