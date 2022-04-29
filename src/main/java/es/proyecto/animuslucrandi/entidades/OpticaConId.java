package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import libreria.animus.Negocio;
import libreria.animus.OpticaIntLib;

@Entity
public class OpticaConId extends NegocioConId implements OpticaIntLib {
  
  private int numeroAutorefractometros;

	@Override
	public int getNumeroAutorefractometros() {
		return numeroAutorefractometros;
	}

	@Override
	public void setNumeroAutorefractometros(int numeroAutorefractometros) {
		this.numeroAutorefractometros = numeroAutorefractometros;
	}
	
	public OpticaConId(String nombre, String nif, int numeroAutorefractometros) {
		super(nombre, nif);
		this.numeroAutorefractometros = numeroAutorefractometros;
	}
}
