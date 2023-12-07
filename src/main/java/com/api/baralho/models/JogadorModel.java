package com.api.baralho.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "jogador")
public class JogadorModel {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
	private List<CartaModel> cards;
	
	private Integer pontos;
	
		public JogadorModel(List<CartaModel> cards) {
			super();
			this.cards = cards;
			contaPontos();
		}

	public void contaPontos() {
		int pontosJogador = 0;
		for (CartaModel cartaModel : cards) {
			try {
				int valor = Integer.parseInt(cartaModel.getValue());
				pontosJogador += valor;
			}catch(NumberFormatException e) {
				switch (cartaModel.getValue()) {
				case "A": 
					pontosJogador += 1;
					break;
				case "K":
					pontosJogador += 13;
					break;
				case "Q": 
					pontosJogador += 12;
					break;
				case "J":
					pontosJogador += 11;
					break;
				}
			}												
		}
	this.pontos = pontosJogador;
	}


	
	
}
