package com.api.baralho.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.baralho.cliente.DeckClient;
import com.api.baralho.models.BaralhoModel;
import com.api.baralho.reposiroty.CartaRepository;
import com.api.baralho.reposiroty.DeckRepository;
import com.api.baralho.reposiroty.ImagesRepository;

import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
@RequestMapping("/baralho")
public class BaralhoController{
	
	@Autowired
	private DeckClient deckClient;
	@Autowired
	private DeckRepository deckRepository;
	@Autowired
	private ImagesRepository imageRepository;
	@Autowired
	private CartaRepository cartaRepository;
	
	
	@GetMapping
	public List<BaralhoModel> getBaralho() {
		List<BaralhoModel> listaBaralho = deckClient.embaralhar();
		for(BaralhoModel baralho: listaBaralho){
			deckRepository.save(baralho);
		}
		return listaBaralho;
	}
	
	/*
	 * public BaralhoModel getCartas() { BaralhoModel baralho =
	 * deckClient.tirarCartas(); }
	 */

}
