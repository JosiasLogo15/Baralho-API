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

@Entity
@Table(name = "carta")
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@Getter
@Setter
public class CartaModelo {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String code;
	private String image;
	private ImagesModel images;
	private String value;
	private String suit;
}
