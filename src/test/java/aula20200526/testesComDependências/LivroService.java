package aula20200526.testesComDependências;

public class LivroService {
	private LivroRepository repo;
	
	public LivroService() {
	}
	
	public LivroService(LivroRepository repo) {
		this.repo = repo;
	}

	public void alterarEditora(String id, String novaEditora) {		
		Livro recuperado = repo.findById(id);
		if (recuperado == null) {
			return;
		}
		try {
			recuperado.setEditora(novaEditora);
			//repo.save(new Livro("zzz", "zzz", 0));
			repo.save(recuperado);
			repo.commit();
		} catch (Exception e) {
			repo.rollback();
		}
	}

	public Livro encontrarPeloId(String id) {
		return repo.findById(id);
	}

}
