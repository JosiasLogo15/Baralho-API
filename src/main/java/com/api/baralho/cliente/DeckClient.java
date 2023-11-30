package com.api.baralho.cliente;

import java.util.List;

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
	List<BaralhoModel> embaralhar();

	//@GetMapping(value = "/api/deck/{deck_id}/draw/?count=5")
	//BaralhoModel tirarCartas(@PathVariable("deck_id") String deck_id);
	
}
