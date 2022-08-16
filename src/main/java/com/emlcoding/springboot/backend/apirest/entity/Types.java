package com.emlcoding.springboot.backend.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class Types implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name_es")
	private String nameEs;
	
	@Column(name = "name_en")
	private String nameEn;
	
	private String color;
	
	
	
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



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	private static final long serialVersionUID = 1L;

}
