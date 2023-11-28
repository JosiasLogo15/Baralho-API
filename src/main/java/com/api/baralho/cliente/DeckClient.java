package com.api.baralho.cliente;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(
		name = "DeckClient",
		url = "https://deckofcardsapi.com"
		)
public interface DeckClient {
	
	@RequestMapping(value = "/api/deck/new/shuffle/?deck_count=1", method = RequestMethod.GET)
	String obterBaralho();
}
