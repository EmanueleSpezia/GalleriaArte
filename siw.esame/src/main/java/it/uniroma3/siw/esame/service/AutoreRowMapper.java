package it.uniroma3.siw.esame.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.uniroma3.siw.esame.model.Autore;

public class AutoreRowMapper implements RowMapper<Object> {
	  
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Autore autore = new Autore();
	      autore.setNome(rs.getString("nome"));
	      autore.setCognome(rs.getString("cognome"));
	      autore.setNazione(rs.getString("nazione"));
	      autore.setNascita(rs.getDate("nascita"));
	      return autore;
	  }
}