package aula20200211.singleton;

public class Universo {
	private static Universo theUniverse;

	private Universo() {
		System.out.println("Criando um universo...");
	}
	
	public static Universo getInstance() {
		if (theUniverse == null) {
			theUniverse = new Universo();
		}
		return theUniverse;
	}
	
}
