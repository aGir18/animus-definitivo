package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;

import es.proyecto.animuslucrandi.repositorios.OpticaListener;
import libreria.animus.OpticaInterfaz;

@Entity
//@Table(name = "OPTICAS")
@EntityListeners(OpticaListener.class)
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
  
  public OpticaConId() {};
  
  public OpticaConId(String nombre, String nif) {
    super(nombre, nif);
  }
 
}
