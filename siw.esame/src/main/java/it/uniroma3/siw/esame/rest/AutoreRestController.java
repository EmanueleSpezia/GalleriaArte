package it.uniroma3.siw.esame.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.esame.service.AutoreService;
import it.uniroma3.siw.esame.model.Autore;

@RestController
public class AutoreRestController {

		@Autowired
		AutoreService autoreService;
		
	    @RequestMapping("/rest/autore/{id}")
	    public Autore getAutore(@PathVariable Long id) {
	        return autoreService.findbyId(id);
	    }
	}