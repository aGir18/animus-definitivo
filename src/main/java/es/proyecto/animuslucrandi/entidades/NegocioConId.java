package es.proyecto.animuslucrandi.entidades;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import libreria.animus.Negocio;
import libreria.animus.NegocioIntLib;

public class NegocioConId extends Negocio implements NegocioIntLib {
	
	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nif;
	private String nombre;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_NEGOCIO")
	private AsociacionConId asociacion;
		
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getNif() {
	  return nif;
	}
	
	@Override
	public String getNombre() {
	  return nombre;
	}
	
	@Override
	public void setNif(String nif) {
	  this.nif = nif;
}
	
	@Override
	public void setNombre(String nombre) {
	  this.nombre = nombre;
	}
	
	public NegocioConId(String nombre, String nif) {
		super(nombre, nif);
	}
	
}
