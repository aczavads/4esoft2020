package factoryMethod.carros;

public class CarroFactory {

	public static Carro criarModeloCompacto(String marca) {
		switch (marca) {
		case "VW":
			return new Up();
		case "FORD":
			return new Ka();
		case "FIAT":
			return new Mobi();
		case "RENAULT":
			return new Kwid();
		default:
			break;
		}
		return null;
	}

}
