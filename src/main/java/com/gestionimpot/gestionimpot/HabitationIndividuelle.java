package com.gestionimpot.gestionimpot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HabitationIndividuelle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String proprietaire;

	private String adresse;

	private double surface;

	private int nbreDePiece;

	private boolean havePiscine;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
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

	public int getNbreDePiece() {
		return nbreDePiece;
	}

	public void setNbreDePiece(int nbreDePiece) {
		this.nbreDePiece = nbreDePiece;
	}

	public boolean isHavePiscine() {
		return havePiscine;
	}

	public void setHavePiscine(boolean havePiscine) {
		this.havePiscine = havePiscine;
	}

}
