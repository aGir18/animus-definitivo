package es.proyecto.animuslucrandi.entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import libreria.animus.Asociacion;
import libreria.animus.Negocio;

@Entity
public class AsociacionConId extends Asociacion {

  @Id
  @GeneratedValue
  private long id;
    
  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public AsociacionConId(String nombre, List<Negocio> negocios) {
    super(nombre, negocios);
  }

}
