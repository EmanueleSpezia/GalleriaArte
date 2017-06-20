package it.uniroma3.siw.esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import it.uniroma3.siw.esame.model.Autore;
import it.uniroma3.siw.esame.model.Quadro;
import it.uniroma3.siw.esame.service.AutoreService;
import it.uniroma3.siw.esame.service.QuadroService;



@Controller
public class GalleriaController  {

	@Autowired
	private AutoreService autoreservice;

	@Autowired
	private QuadroService quadroservice;



	@GetMapping("/ricercaQuadro")
	public String showForm(Quadro quadro) {
		return "formRicercaQuadro";
	}

	@GetMapping("/ricercaAutore")
	public String showForm(Autore autore) {
		return "formRicercaAutore";
	}

	@GetMapping("/modificaQuadro")
	public String modificaQuadro(Quadro quadro){
		return "formModificaQuadro";
	}


	//CASO D'USO 3: (CONSULTAZIONE)
	
	
	
	//UTENTE
	@PostMapping("/ricercaQuadro")
	public String getByTitolo(String titolo, 
			BindingResult bindingResult, Model model)    {

		if (bindingResult.hasErrors()) {
			return "formRicercaQuadro";
		}

		else {
			Quadro quadro = quadroservice.findByTitolo(titolo);
			model.addAttribute(quadro);

		}

		return "result";

	}


	//ADMIN
	@PostMapping("/adminRicercaQuadro")
	public String getByTitoloAdmin(String titolo, 
			BindingResult bindingResult, Model model)    {

		if (bindingResult.hasErrors()) {
			return "adminFormQuadro";
		}

		else {
			Quadro quadro = quadroservice.findByTitolo(titolo);
			model.addAttribute(quadro);

		}

		return "adminResult";

	}

	//UTENTE
	@PostMapping("/ricercaAutore")
	public String getByAutore(String nome,  Model model)    {

		if (nome==null) {
			return "formRicercaAutore";
		}

		else {

			Autore autore = autoreservice.findByNome(nome);
			model.addAttribute(autore);
			model.addAttribute("listaQuadri", autore.getQuadri());

		}

		return "formSelezionaQuadro";

	}


	//ADMIN
	@PostMapping("/adminRicercaAutore")
	public String getByAutoreAdmin(String nome, 
			BindingResult bindingResult, Model model)    {

		if (bindingResult.hasErrors()) {
			return "adminFormAutore";
		}

		else {
			Autore autore = autoreservice.findByNome(nome);
			model.addAttribute(autore);

		}

		return "adminFormSelezionaQuadro";

	}


	//UTENTE
	@PostMapping("/selezionaQuadro")
	public String getQuadro(String titolo, BindingResult bindingResult, Model model ){

		if (bindingResult.hasErrors()) {
			return "formSelezionaQuadro";
		}

		else {
			Quadro quadro = quadroservice.findByTitolo(titolo);
			model.addAttribute(quadro);

		}

		return "result";
	}

	//ADMIN
	@PostMapping("/adminSelezionaQuadro")
	public String getQuadroAdmin(String titolo, BindingResult bindingResult, Model model ){

		if (bindingResult.hasErrors()) {
			return "adminFormSelezionaQuadro";
		}

		else {
			Quadro quadro = quadroservice.findByTitolo(titolo);
			model.addAttribute(quadro);

		}

		return "adminResult";
	}


	//CASO D'USO 2: (RIMOZIONE)
	
	
	//RIMOZIONE
	@PostMapping("/cancellaQuadro")
	public void cancellaQuadro(Quadro quadro){
		quadroservice.remove(quadro.getTitolo());
	}

	
	//CASO D'USO 4: (AGGIORNAMENTO)
	
	//AGGIORNAMENTO QUADRO (MODIFICA)
	@PostMapping("/modificaQuadro")
	public String modificaQuadro(Quadro quadro, BindingResult bindingResult, Model model ){
		quadroservice.update(quadro);
		return "adminResult";
	}


	//AGGIORNAMENTO AUTORE (MODIFICA)
	@PostMapping("/modificaAutore")
	public String modificaAutore(Autore autore, BindingResult bindingResult, Model model ){
		autoreservice.update(autore);
		return "adminResult";
	}

}





