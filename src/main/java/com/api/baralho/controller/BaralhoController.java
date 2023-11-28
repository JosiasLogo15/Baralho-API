package com.api.baralho.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.baralho.cliente.DeckClient;



@RestController
@RequestMapping("/baralho")
public class BaralhoController implements DeckClient{
	
	private DeckClient deckClient;
	
	public BaralhoController(DeckClient deckClient) {
		this.deckClient = deckClient;
	}
	
	@GetMapping("/")
	public @ResponseBody String obtemBaralho() {	
		return obterBaralho();
	}


	@Override
	public String obterBaralho() {
		
		return deckClient.obterBaralho();
	}
	
}
