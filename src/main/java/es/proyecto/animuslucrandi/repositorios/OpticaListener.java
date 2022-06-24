package es.proyecto.animuslucrandi.repositorios;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import es.proyecto.animuslucrandi.entidades.FarmaciaConId;
import es.proyecto.animuslucrandi.entidades.OpticaConId;

public class OpticaListener {

	private OpticaConIdDAO opticaDao;
	
	@Autowired
	public void init(OpticaConIdDAO opticaDao) {
		this.opticaDao = opticaDao;
	}
	
	@PrePersist
	@PreUpdate
	public void preGuardarOptica(OpticaConId opticaCreada) throws Exception {
		if (opticaCreada.getNumeroAutorefractometros() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El número de autorefractometros no puede ser negativo");
		}
	}
	
	// @PreUpdate
	// public void preActualizarOptica(OpticaConId opticaActualizada) throws Exception {
	// 	if (opticaActualizada.getNumeroAutorefractometros() < 0) {
	// 		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El número de autorefractometros no puede ser negativo");
	// 	}
	// }
	
	
}
