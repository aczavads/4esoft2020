package singleton.gerenciador_de_propriedades;

public class AppGerenciadorDePropriedades {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			System.out.println(GerenciadorDePropriedades.getInstance());
		}
		GerenciadorDePropriedades gp = GerenciadorDePropriedades.getInstance();
		System.out.println(gp.getValorDaPropriedade("icms-estadual-base"));
		
		
	}

}
