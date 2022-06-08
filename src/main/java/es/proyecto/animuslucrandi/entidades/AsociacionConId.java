package es.proyecto.animuslucrandi.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import libreria.animus.Asociacion;

@Entity
public class AsociacionConId extends Asociacion {

  private List<NegocioConId> negociosAsociacion = new ArrayList<>();
  
  @OneToMany(cascade = CascadeType.ALL, targetEntity=NegocioConId.class, mappedBy = "asociacion")
  public List<NegocioConId> getNegociosAsociacion() {
    return negociosAsociacion;
  }
  
  public void setNegociosAsociacion(List<NegocioConId> negociosAsociacion) {
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
