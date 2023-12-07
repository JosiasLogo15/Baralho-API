package com.api.baralho.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
@Entity
@Table(name = "baralho")
public class BaralhoModel {
	
	@JsonIgnore
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Boolean success;
	private String deck_id;
	
	@OneToMany(mappedBy = "baralho", cascade = CascadeType.ALL)
	private List<CartaModel> cards;
	private Integer remaining;
	
	private Boolean shuffled;
	
	public BaralhoModel(Boolean success, String deckId, List<CartaModel> cards, Integer remaining) {
		this.success = success;
		this.deck_id = deckId;
		this.cards = cards;
		this.remaining = remaining;
	}
	public BaralhoModel(Boolean success, String deckId, List<CartaModel> cards) {
		this.success = success;
		this.deck_id = deckId;
		this.cards = cards;
	}
	
	public BaralhoModel(Boolean success, String deckId, Boolean shuffled, Integer remaining) {
		this.success = success;
		this.deck_id = deckId;
		this.shuffled = shuffled;
		this.remaining = remaining;
	}
		
}
