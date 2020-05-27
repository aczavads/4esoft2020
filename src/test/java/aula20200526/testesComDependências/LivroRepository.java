package aula20200526.testesComDependências;

public interface LivroRepository {
	
	Livro findById(String id);
	void save(Livro l);
	void commit();
	void rollback();
	

}
