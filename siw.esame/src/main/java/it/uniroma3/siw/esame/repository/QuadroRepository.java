package it.uniroma3.siw.esame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.esame.model.Autore;
import it.uniroma3.siw.esame.model.Quadro;

public interface QuadroRepository extends CrudRepository<Quadro, Long> {

    
	Quadro findByTitolo(String titolo);

    List<Quadro> findByAnno(int anno);
    
    
    List<Quadro> findByAutore(Autore autore);
    
    
   
    
}