package observer.cofreRefatorado;

public class AppCofre {
	
	public static void main(String[] args) {
		Cofre daSala = new Cofre(123456);
		
		AberturaDoCofreListener abertura = new AberturaDoCofreListener() {
			@Override
			public void notificar() {
				System.out.println("Abertura realizada!");
			}		
		};
		
		FechamentoDoCofreListener fechamento = new FechamentoDoCofreListener() {
			@Override
			public void notificar() {
				System.out.println("Fechamento realizado!");
			}		
		};
		
		/*
		SenhaDoCofreIncorretaListener senhaIncorreta = new SenhaDoCofreIncorretaListener() {
			@Override
			public void notificar() {
				System.out.println("Senha incorreta utilizada!");
			}		
		};
		*/
		
		daSala.addListener(abertura);
		daSala.addListener(fechamento);
		//daSala.addListener(senhaIncorreta);
		daSala.addListener((SenhaDoCofreIncorretaListener)() -> System.out.println("Senha incorreta utilizada!"));
		
		System.out.println(daSala.isAberto());
		
		daSala.fechar();
		System.out.println(daSala.isAberto());
		
		daSala.abrir(111);
		System.out.println(daSala.isAberto());

		daSala.abrir(123456);
		System.out.println(daSala.isAberto());
		
		System.out.println("Fim.");
		
	}

}
