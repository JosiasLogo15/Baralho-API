package com.api.baralho.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "imagens")
public class ImagesModel {
	
	@JsonIgnore
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String svg;
	private String png;
	
	public ImagesModel(String svg, String png) {
		super();
		this.svg = svg;
		this.png = png;
	}
}
