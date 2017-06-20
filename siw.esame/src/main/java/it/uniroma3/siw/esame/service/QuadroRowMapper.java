package it.uniroma3.siw.esame.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import it.uniroma3.siw.esame.model.Quadro;

public class QuadroRowMapper implements RowMapper<Object> {
	  
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Quadro quadro = new Quadro();
	      quadro.setTitolo(rs.getString("titolo"));
	      quadro.setAnno(rs.getInt("anno"));
	      quadro.setTecnica(rs.getString("tecnica"));
	      return quadro;
	  }
}