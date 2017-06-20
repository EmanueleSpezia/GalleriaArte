package it.uniroma3.siw.esame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.esame.model.Autore;
import it.uniroma3.siw.esame.repository.AutoreRepository;




@Service
public class AutoreService {

	@Autowired
	private JdbcTemplate serviceSpring;

	@Autowired
	private AutoreRepository autoreRepository; 

	public Iterable<Autore> findAll() {
		return this.autoreRepository.findAll();
	}

	//RICERCA SINGOLA
	public  Autore findByNome(String nome){
		Autore autore = (Autore) serviceSpring.queryForObject("select * from autore where nome = ?", new Object[] { nome },new AutoreRowMapper());
		return autore;
	}

	//MODIFICA
	@Transactional
	public void update(Autore autore){
		serviceSpring.update("update autore set nome = ?, cognome = ?, nazione = ? where id = ?",
				new Object[] { autore.getNome(), autore.getCognome(), autore.getNazione() });
	}

	//INSERIMENTO
	@Transactional
	public void add(final Autore autore) {
		this.autoreRepository.save(autore);
	}


	public Autore findbyId(Long id) {
		return this.autoreRepository.findOne(id);
	}

	//RIMOZIONE
	@Transactional
	public void remove(String nome){
		Autore autore=this.autoreRepository.findByNome(nome);
		this.autoreRepository.delete(autore);
	}




}
