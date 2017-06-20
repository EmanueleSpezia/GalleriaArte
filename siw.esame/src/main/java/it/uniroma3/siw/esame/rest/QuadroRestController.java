package it.uniroma3.siw.esame.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.uniroma3.siw.esame.service.QuadroService;
import it.uniroma3.siw.esame.model.*;

@RestController
public class QuadroRestController {

		@Autowired
		QuadroService quadroService;
		
	    @RequestMapping("/rest/quadro/{id}")
	    public Quadro getQuadro(@PathVariable Long id) {
	        return quadroService.findbyId(id);
	    }
	}