package com.emlcoding.springboot.backend.apirest.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "games")
public class Game implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty
	@Column(name = "name_es")
	private String nameEs;
	
	@NotEmpty
	@Column(name = "name_en")
	private String nameEn;
	
	@NotEmpty
	private String cover;
	
	@NotEmpty
	@Column(name = "date_release")
	private LocalDate dateRelease;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(name = "pokemon_games", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
	private List<Pokemon> pokemons;
	
	
	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNameEs() {
		return nameEs;
	}




	public void setNameEs(String nameEs) {
		this.nameEs = nameEs;
	}




	public String getNameEn() {
		return nameEn;
	}




	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}




	public String getCover() {
		return cover;
	}




	public void setCover(String cover) {
		this.cover = cover;
	}




	public LocalDate getDateRelease() {
		return dateRelease;
	}




	public void setDateRelease(LocalDate dateRelease) {
		this.dateRelease = dateRelease;
	}




	public List<Pokemon> getPokemons() {
		return pokemons;
	}




	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}




	private static final long serialVersionUID = 1L;

	
}
