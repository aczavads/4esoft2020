package builder.base;

public class AppBuilderBase {
	
	public static void main(String[] args) {
		
		/*
		Bolo gostoso = new Bolo(
				null, 
				null,
				Massa.FECULA,
				SaborMassa.VINHO_BRANCO,
				Recheio.MOUSSE,
				SaborRecheio.MORANGO,
				3,
				true);
		
		Bolo outroGostoso = new Bolo(
				Cobertura.PASTA_AMERICANA, 
				SaborCobertura.BAUNILHA,
				Massa.FECULA,
				SaborMassa.VINHO_BRANCO,
				null,
				null,
				3,
				true);	
		
		Bolo paoDeLoDeLaranja = new Bolo(
				Massa.PAO_DE_LO,
				SaborMassa.LARANJA,
				true);
		*/
		Bolo laranjaComCoberturaDeChocolate = (new Bolo.Builder())
				.frio()
				.massa(Massa.PAO_DE_LO, SaborMassa.LARANJA)
				.cobertura(Cobertura.GANACHE, SaborCobertura.CHOCOLATE)
				.builder();
		
	}

}
