package es.proyecto.animuslucrandi.entidades;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import libreria.animus.Asociacion;

@Entity
public class AsociacionConId extends Asociacion {

  @OneToMany(targetEntity=NegocioConId.class)
  private Collection<NegocioConId> negociosAsociacion;
  
  
  public Collection<NegocioConId> getNegociosAsociacion() {
    return negociosAsociacion;
  }
  
  public void setNegociosAsociacion(Collection<NegocioConId> negociosAsociacion) {
    this.negociosAsociacion = negociosAsociacion;
  }
  
  // Establece la relacion en los dos sentidos
  public void addNegocioConId(NegocioConId negocio) {
    getNegociosAsociacion().add(negocio);
    negocio.setAsociacion(this);
  }
  
  public AsociacionConId() {
    super(null);
  }
  
  public AsociacionConId(String nombre) {
    super(nombre);
  }
  
	//@OneToMany(cascade = CascadeType.ALL, targetEntity = NegocioConId.class, mappedBy = "asociacion")
	//private Collection<NegocioConId> negocios;
  
}
