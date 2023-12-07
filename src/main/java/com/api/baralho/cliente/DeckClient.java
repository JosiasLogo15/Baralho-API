package com.api.baralho.cliente;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.api.baralho.models.BaralhoModel;


@FeignClient(
		name = "DeckClient",
		url = "https://deckofcardsapi.com"
		)
public interface DeckClient {
	
	@GetMapping(value = "/api/deck/new/draw/?count=5")
	BaralhoModel obterBaralho();

	
	@GetMapping(value = "/api/deck/{deck_id}/shuffle/") 
	BaralhoModel embaralhar(@PathVariable("deck_id") String deck_id);
	
	@GetMapping(value = "/api/deck/{deck_id}/draw/?count=5")
	BaralhoModel obterCartas(@PathVariable("deck_id") String deck_id);
	
}
