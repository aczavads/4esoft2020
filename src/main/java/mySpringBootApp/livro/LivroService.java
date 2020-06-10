package mySpringBootApp.livro;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LivroService {
	@Autowired
	private LivroRepository repo;
	

	public void deleteById(String id) {
		repo.deleteById(id);
	}

	public Livro getById(String id) {
		//return repo.findById(id).get(); 
		return repo.findById(id).orElseThrow(NotFoundException::new);
	}
	
	public List<Livro> getAll() {
		return repo.findAll();
	}
	
	public String save(Livro livro) {
		return this.repo.save(livro).getId();
	}
	
}
