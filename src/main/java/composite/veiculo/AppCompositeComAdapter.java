package composite.veiculo;

public class AppCompositeComAdapter {
	
	
	public static void main(String[] args) {
		UnidadeDePotenciaComposite composite = new UnidadeDePotenciaComposite();
		composite.addUnidadeDePotencia(new MotorDoisPontoZeroTurboFlex());
		composite.addUnidadeDePotencia(new MotorWankel());
		composite.addUnidadeDePotencia(new MotorWankel());
		
		Veiculo v1 = new Veiculo(new AdapterMarsEngineToUnidadeDePotencia(new MarsParticleEngine()));
		
		v1.ligar();
		v1.acelerar();
		v1.acelerar();
		v1.acelerar();
	}

}
