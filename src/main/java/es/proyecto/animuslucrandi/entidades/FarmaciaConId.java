package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;

import libreria.animus.Farmacia;

@Entity
public class FarmaciaConId extends Farmacia {

	public FarmaciaConId(String nombre, String nif, int numeroPuntosSigre) {
	  super(nombre, nif, numeroPuntosSigre);
	}

}
