package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

@RepositoryRestResource(path = "asociaciones", itemResourceRel = "asociacion", collectionResourceRel = "asociaciones")
public interface AsociacionConIdDAO extends JpaRepository<AsociacionConId, Long> {

}
