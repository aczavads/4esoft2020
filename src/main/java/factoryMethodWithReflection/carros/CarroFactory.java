package factoryMethodWithReflection.carros;

import java.io.InputStream;
import java.util.Properties;

public class CarroFactory {

	public static Carro criarModeloCompacto(String marca) {		
		try (InputStream input = CarroFactory.class.getResourceAsStream("factory.properties")) {
			Properties propriedades = new Properties();
			propriedades.load(input);
			
			return instanciarCarro(propriedades.getProperty(marca));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static Carro instanciarCarro(String nomeDaClasse) {
		try {
			return (Carro) Class.forName(nomeDaClasse).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
