package es.proyecto.animuslucrandi.repositorios;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import es.proyecto.animuslucrandi.entidades.FarmaciaConId;

public class FarmaciaListener {
	
//	private Logger log = LoggerFactory.getLogger(FarmaciaListener.class);
	private FarmaciaConIdDAO farmaciaDao;
	
	@Autowired
	public void init(FarmaciaConIdDAO farmaciaDao) {
		this.farmaciaDao = farmaciaDao;
	}
	
	@PrePersist
	public void preGuardarFarmacia(FarmaciaConId farmaciaCreada) throws Exception {
		if (farmaciaCreada.getNumeroPuntosSigre() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El número de puntos SIGRE no puede ser negativo");
		}
	}
	
	@PreUpdate
	public void preActualizarFarmacia(FarmaciaConId farmaciaActualizada) throws Exception {
		if (farmaciaActualizada.getNumeroPuntosSigre() < 0) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El número de puntos SIGRE no puede ser negativo");
		}
	}
	
}
