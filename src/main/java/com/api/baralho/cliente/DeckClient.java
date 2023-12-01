package com.api.baralho.cliente;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.api.baralho.models.BaralhoModel;


@FeignClient(
		name = "DeckClient",
		url = "https://deckofcardsapi.com"
		)
public interface DeckClient {
	
	String string = "/api/deck/new/draw/?count=5";
	
	//@GetMapping(value = "/api/deck/new/shuffle/?deck_count=1")
	@GetMapping(value = string)
	BaralhoModel embaralhar();

	//@GetMapping(value = "/api/deck/{deck_id}/draw/?count=5")
	//BaralhoModel tirarCartas(@PathVariable("deck_id") String deck_id);
	
}
