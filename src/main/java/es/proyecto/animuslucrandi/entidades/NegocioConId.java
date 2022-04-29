package es.proyecto.animuslucrandi.entidades;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import libreria.animus.Negocio;

public class NegocioConId extends Negocio {
	
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public NegocioConId(String nombre, String nif) {
		super(nombre, nif);
	}
	
}
