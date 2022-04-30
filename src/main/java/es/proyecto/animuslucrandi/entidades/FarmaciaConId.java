package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;

import libreria.animus.FarmaciaIntLib;

@Entity
public class FarmaciaConId extends NegocioConId implements FarmaciaIntLib {

	private int numeroPuntosSigre;
	
	@Override
	public int getNumeroPuntosSigre() {
		return numeroPuntosSigre;
	}

	@Override
	public void setNumeroPuntosSigre(int numeroPuntosSigre) {
		this.numeroPuntosSigre = numeroPuntosSigre;
	}
  
	public FarmaciaConId(String nombre, String nif, int numeroPuntosSigre) {
		super(nombre, nif);
		this.numeroPuntosSigre = numeroPuntosSigre;
	}

}
