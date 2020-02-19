package singleton.propriedades;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppPropriedades {

	public static void main(String[] args) {
		
		try (InputStream input = AppPropriedades.class.getResourceAsStream("config.properties")) {
			Properties properties = new Properties();
			properties.load(input);
			
			for (Object key : properties.keySet()) {
				System.out.println(key + " ==> " + properties.getProperty((String)key));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	

}
