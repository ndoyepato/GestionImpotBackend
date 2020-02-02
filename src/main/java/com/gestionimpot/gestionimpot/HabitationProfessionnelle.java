package com.gestionimpot.gestionimpot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabitationProfessionnelle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String proprietaire;
	private String adresse;
	private double surface;
	private int nbreEmploye;
	
	public Integer getId() {
		return id;
	} 

	public void setId(Integer id) {
		this.id = id;
	}
   
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public double getSurface() {
		return surface;
	}

	public void setSurface(double surface) {
		this.surface = surface;
	}

	public int getNbreEmploye() {
		return nbreEmploye;
	}

	public void setNbreEmploye(int nbreEmploye) {
		this.nbreEmploye = nbreEmploye;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
}
