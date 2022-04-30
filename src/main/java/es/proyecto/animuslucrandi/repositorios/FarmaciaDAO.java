package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.proyecto.animuslucrandi.entidades.FarmaciaConId;

@RepositoryRestResource(path = "farmacias", itemResourceRel = "farmacia", collectionResourceRel = "farmacias")
public interface FarmaciaDAO extends JpaRepository<FarmaciaConId, Long>{

}
