package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.proyecto.animuslucrandi.entidades.NegocioConId;

@RepositoryRestResource(path = "negocios", itemResourceRel = "negocio", collectionResourceRel = "negocios")
public interface NegocioConIdDAO extends JpaRepository<NegocioConId, Long>{

}
