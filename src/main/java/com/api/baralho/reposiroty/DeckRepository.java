package com.api.baralho.reposiroty;

import org.springframework.data.repository.CrudRepository;

import com.api.baralho.models.BaralhoModel;

public interface DeckRepository  extends CrudRepository<BaralhoModel, Integer>{

}
