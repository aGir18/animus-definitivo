package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import libreria.animus.OpticaInterfaz;

@Entity
//@Table(name = "OPTICAS")
@Access(value=AccessType.FIELD)
@DiscriminatorValue("OPTICA")
public class OpticaConId extends NegocioConId implements OpticaInterfaz {

  private int numeroAutorefractometros;

  @Override
  public int getNumeroAutorefractometros() {
    return numeroAutorefractometros;
  }

  @Override
  public void setNumeroAutorefractometros(int numeroAutorefractometros) {
    this.numeroAutorefractometros = numeroAutorefractometros;
  }
  
  public OpticaConId(String nombre, String nif) {
    super(nombre, nif);
  }
 
}
