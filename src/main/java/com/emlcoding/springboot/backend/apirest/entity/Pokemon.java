package com.emlcoding.springboot.backend.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name="pokemons")

public class Pokemon implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name="pokedex_num")
	private Long pokedexNum;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String description;
	
	@NotEmpty
	private String sprite;
	
	@NotEmpty
	private String image;
	
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Pokemon parent;
	
	@OneToMany(mappedBy="parent")
	private List<Pokemon> evoluciones;

	public Pokemon() {
		this.evoluciones = new ArrayList<>();
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getPokedexNum() {
		return pokedexNum;
	}



	public void setPokedexNum(Long pokedexNum) {
		this.pokedexNum = pokedexNum;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getSprite() {
		return sprite;
	}



	public void setSprite(String sprite) {
		this.sprite = sprite;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public List<Pokemon> getEvoluciones() {
		return evoluciones;
	}



	public void setEvoluciones(List<Pokemon> evoluciones) {
		this.evoluciones = evoluciones;
	}



	private static final long serialVersionUID = 2914731243797020390L;

}

