package aula20200602.mocksParaDependências;

public class UnidadeFederativa {

	private String nome;

	public UnidadeFederativa(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	

	@Override
	public String toString() {
		return "UnidadeFederativa [nome=" + nome + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadeFederativa other = (UnidadeFederativa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	

}
