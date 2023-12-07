package com.api.baralho.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "carta")
@Nonnull
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class CartaModel {
	
	@JsonIgnore
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String code;
	private String image;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "baralho_id")
	private BaralhoModel baralho;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "jogador_id")
	private JogadorModel jogador;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "imagens_id")
	private ImagesModel images;
	
	private String value;
	private String suit;
	
	public CartaModel(String code, String image, ImagesModel images, String value, String suit) {
		super();
		this.code = code;
		this.image = image;
		this.images = images;
		this.value = value;
		this.suit = suit;
	}
}
