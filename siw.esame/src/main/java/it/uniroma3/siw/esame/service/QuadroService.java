package it.uniroma3.siw.esame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.esame.model.Quadro;
import it.uniroma3.siw.esame.repository.QuadroRepository;



@Service
public class QuadroService {

	@Autowired
	private JdbcTemplate serviceSpring;


	@Autowired
	private QuadroRepository quadroRepository; 




	public Iterable<Quadro> findAll() {
		return this.quadroRepository.findAll();
	}


	//MODIFICA
	@Transactional
	public void update(Quadro quadro){
		serviceSpring.update("update quadro set titolo = ?, anno = ?, tecnica = ? where id = ?",
				new Object[] { quadro.getTitolo(), quadro.getAnno(), quadro.getTecnica() });
	}




	//INSERIMENTO
	@Transactional
	public void add(final Quadro quadro) {
		this.quadroRepository.save(quadro);
	}

	public Quadro findbyId(Long id) {
		return this.quadroRepository.findOne(id);
	}


	//RICERCA SINGOLA
	public Quadro findByTitolo(String titolo){
		Quadro quadro = (Quadro) serviceSpring.queryForObject("select * from quadro where titolo = ?", new Object[] { titolo },new QuadroRowMapper());
		return quadro;
	}

	
	//RIMOZIONE
	@Transactional
	public void remove(String titolo){
		Quadro quadro=this.quadroRepository.findByTitolo(titolo);
		this.quadroRepository.delete(quadro);
	}

}
