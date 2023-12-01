package com.api.baralho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.baralho.cliente.DeckClient;
import com.api.baralho.models.BaralhoModel;
import com.api.baralho.models.CartaModelo;
import com.api.baralho.models.ImagesModel;
import com.api.baralho.reposiroty.CartaRepository;
import com.api.baralho.reposiroty.DeckRepository;
import com.api.baralho.reposiroty.ImagesRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("")
public class BaralhoController{
	
	@Autowired
	private DeckClient deckClient;
	
	@Autowired private DeckRepository deckRepository;
	  
	@Autowired private ImagesRepository imageRepository;
	  
	@Autowired private CartaRepository cartaRepository;
	 
	
	
	@GetMapping("/obter_baralho")
	public List<BaralhoModel> getBaralho() {
		List<BaralhoModel> listaBaralho = new ArrayList<BaralhoModel>();
		for(int i = 0; i<5; i++) {
			BaralhoModel baralho = deckClient.embaralhar();
			listaBaralho.add(baralho);
			deckRepository.save(baralho);
			salvarCartas(baralho);
		}
		return listaBaralho;
	}
	private void salvarCartas(BaralhoModel baralho) {
		for(CartaModelo cards: baralho.getCards()) {
			cartaRepository.save(cards);
			imageRepository.save(cards.getImages());
		}
	}
	
	/*
	 * public BaralhoModel getCartas() { BaralhoModel baralho =
	 * deckClient.tirarCartas(); }
	 */

}
