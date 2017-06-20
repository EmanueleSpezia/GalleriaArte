package it.uniroma3.siw.esame.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Quadro {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id_quadro;


	@NotNull
	private String titolo;


	@NotNull
	private int anno;


	
	private String tecnica;

	@ManyToOne
	private Autore autore;

	public Quadro(String titolo){
		this.titolo=titolo;
	}
	

	public Quadro() {
		
	}
	


	public Quadro(String titolo, int anno, String tecnica, Autore autore) {
		
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.autore = autore;
	}


	//metodi getter setter
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}

}
