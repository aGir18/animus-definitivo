package es.proyecto.animuslucrandi.entidades;


import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import libreria.animus.AsociacionIntLib;

@Entity
public class AsociacionConId implements AsociacionIntLib {

	@Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL, targetEntity = NegocioConId.class, mappedBy = "asociacion")
	private Collection<NegocioConId> negocios;
    
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  @Override
  public String getNombre() {
    return nombre;
  }

}
