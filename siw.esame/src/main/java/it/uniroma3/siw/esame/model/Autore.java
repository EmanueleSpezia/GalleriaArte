package it.uniroma3.siw.esame.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Autore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id_autore;


	@NotNull
	@Size(min=1)
	private String nome;


	@NotNull
	@Size(min=1)
	private String cognome;





	private String nazione;


	@NotNull
	@Temporal(TemporalType.DATE)
	private Date nascita;



	@Temporal(TemporalType.DATE)
	private Date morte;



	@OneToMany(mappedBy="autore")
	private List<Quadro> quadri;
	
	
	

	


	public Autore() {
		
	}


	public Autore(String nome,String cognome,Date nascita){
		this.nome=nome;
		this.cognome=cognome;
		this.nascita=nascita;
	}


	//metodi getter setter
	
	public List<Quadro> getQuadri() {
		return quadri;
	}

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public Date getNascita() {
		return nascita;
	}
	public void setNascita(Date nascita) {
		this.nascita = nascita;
	}
	public Date getMorte() {
		return morte;
	}
	public void setMorte(Date morte) {
		this.morte = morte;
	}



}
