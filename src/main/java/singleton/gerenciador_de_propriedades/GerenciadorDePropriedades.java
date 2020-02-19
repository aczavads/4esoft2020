package singleton.gerenciador_de_propriedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import singleton.propriedades.AppPropriedades;

public class GerenciadorDePropriedades {
	private static GerenciadorDePropriedades instance = new GerenciadorDePropriedades();
	private Properties propriedades;
	
	private GerenciadorDePropriedades() {
	}
	
	public static GerenciadorDePropriedades getInstance() {
		return instance;
	}
	
	//+ getValorDaPropriedade(propriedade : String) : String
	public String getValorDaPropriedade(String propriedade) {
		if (propriedades == null) {
			propriedades = carregarPropriedadesDoArquivo();
		}
		return propriedades.getProperty(propriedade);
	}
	
	private Properties carregarPropriedadesDoArquivo() {
		try (InputStream input = AppPropriedades.class.getResourceAsStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);
			return properties;			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return null;
	}
}
