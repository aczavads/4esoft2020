package factoryMethodWithReflection.carros;

public class AppCarros {
	
	public static void main(String[] args) {
		Carro novo = CarroFactory.criarModeloCompacto("VW");		
		System.out.println(novo.toString());
		
		System.out.println(CarroFactory.criarModeloCompacto("VW").getClass().getName());		
		System.out.println(CarroFactory.criarModeloCompacto("FORD").getClass().getName());
		System.out.println(CarroFactory.criarModeloCompacto("FIAT").getClass().getName());
		System.out.println(CarroFactory.criarModeloCompacto("RENAULT").getClass().getName());
		System.out.println(CarroFactory.criarModeloCompacto("TOYOTA").getClass().getName());
	}

}
