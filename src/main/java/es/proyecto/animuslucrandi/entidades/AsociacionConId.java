package es.proyecto.animuslucrandi.entidades;

import java.util.List;

import javax.persistence.Entity;

import libreria.animus.Asociacion;
import libreria.animus.Negocio;

@Entity
public class AsociacionConId extends Asociacion {

  public AsociacionConId(String nombre) {
    super(nombre);
  }
  
	//@OneToMany(cascade = CascadeType.ALL, targetEntity = NegocioConId.class, mappedBy = "asociacion")
	//private Collection<NegocioConId> negocios;
  
}
