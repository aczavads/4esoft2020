package factoryMethodWithReflection.carros;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppReflection {
	
	public static void main(String[] args) throws Exception {
		
		//Carro corollaNovo = new Corolla();
		//Object corollaNovo = classe.newInstance();
		Class classe = Class.forName("factoryMethodWithReflection.carros.Corolla");
		Constructor construtorPadrao = classe.getConstructor(new Class[] {});
		Object corollaNovo = construtorPadrao.newInstance(new Object[] {});
		
		listarAtributos(corollaNovo);
		
		listarMetodos(corollaNovo);
		
	}

	private static void listarMetodos(Object obj) {
		System.out.println();
		System.out.println("Listando métodos...");
		try {
			Class classe = obj.getClass();
			for (Method metodo : classe.getDeclaredMethods()) {
				System.out.println(metodo.getName() + " : " + metodo.getReturnType().getTypeName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void listarAtributos(Object obj) {
		System.out.println();
		System.out.println("Listando atributos...");
		try {
			Class classe = obj.getClass();
			for (Field campo : classe.getDeclaredFields()) {
				campo.setAccessible(true);
				if (campo.getName().equalsIgnoreCase("lote")) {
					campo.set(obj, "xiiiiiii!");
				}
				System.out.println(campo.getName() + " : " + campo.getType().getTypeName() + " ==> " + campo.get(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
