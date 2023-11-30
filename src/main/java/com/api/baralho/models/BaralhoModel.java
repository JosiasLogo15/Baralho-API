package com.api.baralho.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Boolean success;
	private String deck_id;
	private Boolean shuffled;
	private CartaModelo cards;
	private Integer remaining;
	
	
	
}
