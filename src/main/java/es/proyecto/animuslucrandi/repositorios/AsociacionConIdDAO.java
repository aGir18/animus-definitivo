package es.proyecto.animuslucrandi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

@RepositoryRestResource(path = "asociaciones", itemResourceRel = "asociacion", collectionResourceRel = "asociaciones")
public interface AsociacionConIdDAO extends JpaRepository<AsociacionConId, Long>, AsociacionConIdDAOCustom {

  // @RestResource(exported = false)
  // void delete(AsociacionConId asociacion);
  
  @RestResource(path="por-nombre")
  List<AsociacionConId> findByNombreIgnoreCase(@Param("nombre")String txt);
  
}
