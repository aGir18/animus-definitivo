package es.proyecto.animuslucrandi.entidades;

import javax.persistence.Entity;

import libreria.animus.Optica;

@Entity
//@Table(name = "OPTICAS")
public class OpticaConId extends Optica {
 
	public OpticaConId(String nombre, String nif, int numeroAutorefractometros) {
	  super(nombre, nif, numeroAutorefractometros);
	}
	
}
