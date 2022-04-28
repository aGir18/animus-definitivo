package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import libreria.animus.Farmacia;

@Entity
public class FarmaciaConId extends Farmacia {
  
  @Id
  @GeneratedValue
  private long id;

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public FarmaciaConId(String nombre, String nif, int numeroPuntosSigre) {
    super(nombre, nif, numeroPuntosSigre);
  }

}
