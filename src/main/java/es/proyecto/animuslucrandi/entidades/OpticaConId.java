package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import libreria.animus.Optica;

@Entity
public class OpticaConId extends Optica{
  
  @Id
  @GeneratedValue
  private long id;

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }

  public OpticaConId(String nombre, String nif, int numeroAutorefractometros) {
    super(nombre, nif, numeroAutorefractometros);
  }

}
