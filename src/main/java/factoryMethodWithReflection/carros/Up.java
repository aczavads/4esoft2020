package factoryMethodWithReflection.carros;

public class Up implements Carro {

	@Override
	public String getMarca() {
		return "VolksWagen";
	}

	@Override
	public String getModelo() {
		// TODO Auto-generated method stub
		return "Up";
	}

	@Override
	public double getPotenciaEmCavalos() {
		// TODO Auto-generated method stub
		return 81.25;
	}

	@Override
	public double getPortaMalasEmLitros() {
		// TODO Auto-generated method stub
		return 220;
	}
	@Override
	public String toString() {
		return this.asString();
	}

}
