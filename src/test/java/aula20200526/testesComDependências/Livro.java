package aula20200526.testesComDependências;

public class Livro {
	private String título;
	private String editora;
	private int númeroDePáginas;
	
	public void setEditora(String editora) {
		if (editora == null || editora.trim().isEmpty()) {
			throw new RuntimeException("Editora não poder ser nula nem vazia!");
		}
		this.editora = editora;
	}
	public String getEditora() {
		return editora;
	}
	public int getNúmeroDePáginas() {
		return númeroDePáginas;
	}
	public String getTítulo() {
		return título;
	}
	
	public Livro(String título, String editora, int númeroDePáginas) {
		super();
		this.título = título;
		this.editora = editora;
		this.númeroDePáginas = númeroDePáginas;
	}
}
