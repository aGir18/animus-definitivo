package es.proyecto.animuslucrandi.entidades;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import libreria.animus.Negocio;

@Entity
@Table(name = "NEGOCIOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPO_NEGOCIO", discriminatorType = DiscriminatorType.STRING)
public class NegocioConId extends Negocio {
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="ID_ASOCIACION", referencedColumnName="ID")
  private AsociacionConId asociacion;
  
  public AsociacionConId getAsociacion() {
    return asociacion;
  }
  
  public void setAsociacion(AsociacionConId asociacion) {
    this.asociacion = asociacion;
  }
  
  public NegocioConId() {};

	public NegocioConId(String nombre, String nif) {
		super(nombre, nif);
	}
	
}
