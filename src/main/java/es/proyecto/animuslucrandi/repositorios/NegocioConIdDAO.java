package es.proyecto.animuslucrandi.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import es.proyecto.animuslucrandi.entidades.NegocioConId;

@RepositoryRestResource(path = "negocios", itemResourceRel = "negocio", collectionResourceRel = "negocios")
public interface NegocioConIdDAO extends JpaRepository<NegocioConId, Long>{

  @RestResource(path="por-nombre")
  @Query("SELECT p FROM NegocioConId p WHERE UPPER(p.nombre) LIKE UPPER(concat('%', :txt, '%'))")
  List<NegocioConId> findByNombreIgnoreCase(String txt);
    
  //Si yo NO quisiera borrarlo: 
  //@RestResource(exported = false)
  //void delete(Cliente cliente);
   
  
}
