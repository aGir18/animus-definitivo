package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.proyecto.animuslucrandi.entidades.OpticaConId;

@RepositoryRestResource(path = "opticas", itemResourceRel = "optica", collectionResourceRel = "opticas")
public interface OpticaDAO extends JpaRepository<OpticaConId, Long>{

}
