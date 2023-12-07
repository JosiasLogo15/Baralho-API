package com.api.baralho.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.baralho.cliente.DeckClient;
import com.api.baralho.models.BaralhoModel;
import com.api.baralho.models.CartaModel;
import com.api.baralho.models.JogadorModel;
import com.api.baralho.reposiroty.CartaRepository;
import com.api.baralho.reposiroty.DeckRepository;
import com.api.baralho.reposiroty.ImagesRepository;
import com.api.baralho.reposiroty.JogadorRepository;

import jakarta.transaction.Transactional;
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
	
	@Autowired private JogadorRepository jogadorRepository;
	
	
	@Transactional
	@GetMapping("/obter_baralho")
	public List<JogadorModel> getBaralho() {
		if (deckRepository.count() == 0) { 
			for (int i = 0; i < 5; i++) { 
				BaralhoModel baralho = deckClient.obterBaralho(); 
				salvarBaralhoEJogador(baralho);
			} 
		} else{ 
			limpaBanco();
			for(BaralhoModel baralho : deckRepository.findAll()) { 
			int id = baralho.getId();
			baralho = deckClient.embaralhar(baralho.getDeck_id()); 
			baralho = deckClient.obterCartas(baralho.getDeck_id()); baralho.setId(id);
			salvarBaralhoEJogador(baralho); 
				} 
			}

	    return contarPontos();
	}

	private void limpaBanco() {
		cartaRepository.deleteAll();
		imageRepository.deleteAll();
		jogadorRepository.deleteAll();
	}

	private void salvarBaralhoEJogador(BaralhoModel baralho) {
	    JogadorModel jogador = salvarJogador(baralho);
	    salvarCartas(baralho, jogador);
	    deckRepository.save(baralho);
	}

	private JogadorModel salvarJogador(BaralhoModel baralho) {
	    List<CartaModel> cartasJogador = new ArrayList<>();

	    for (CartaModel cards : baralho.getCards()) {
	    	cards.setBaralho(null);
	        cartasJogador.add(cards);
	    }
	    JogadorModel jogador = new JogadorModel(cartasJogador);
	    jogadorRepository.save(jogador);
	    return jogador;
	}

	private void salvarCartas(BaralhoModel baralho, JogadorModel jogador) {
	    for (CartaModel cards : baralho.getCards()) {
	        cards.setBaralho(baralho);
	        cards.setJogador(jogador);
	        cartaRepository.save(cards);
	        imageRepository.save(cards.getImages());
	    }
	}

	
	private List<JogadorModel> contarPontos() {
	    List<JogadorModel> listaJogadores = (List<JogadorModel>) jogadorRepository.findAll();

	    listaJogadores.forEach(JogadorModel::contaPontos);

	    OptionalInt maxPontos = listaJogadores.stream()
	            .mapToInt(JogadorModel::getPontos)
	            .max();

	    if (maxPontos.isPresent()) {
	        int pontosVencedor = maxPontos.getAsInt();

	        List<JogadorModel> empate = listaJogadores.stream()
	                .filter(j -> j.getPontos() == pontosVencedor)
	                .collect(Collectors.toList());

	        return empate.size() > 1 ? empate : Collections.singletonList(empate.get(0));
	    }

	    return Collections.emptyList();
	}
}