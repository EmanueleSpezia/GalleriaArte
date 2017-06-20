package it.uniroma3.siw.esame.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.esame.model.Autore;

public interface AutoreRepository extends CrudRepository<Autore, Long> {

    Autore findByNome(String nome);

    List<Autore> findByCognome(String cognome);
    
    
  
    
   
    
}