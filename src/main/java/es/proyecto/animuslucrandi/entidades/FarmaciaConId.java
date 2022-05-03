package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import libreria.animus.FarmaciaInterfaz;

@Entity
@Access(value=AccessType.FIELD)
@DiscriminatorValue("FARMACIA")
public class FarmaciaConId extends NegocioConId implements FarmaciaInterfaz {

  private int numeroPuntosSigre;

  @Override
  public int getNumeroPuntosSigre() {
    return numeroPuntosSigre;
  }

  @Override
  public void setNumeroPuntosSigre(int numeroPuntosSigre) {
    this.numeroPuntosSigre = numeroPuntosSigre;
  }

  public FarmaciaConId(String nombre, String nif) {
    super(nombre, nif);
  }
  
}
