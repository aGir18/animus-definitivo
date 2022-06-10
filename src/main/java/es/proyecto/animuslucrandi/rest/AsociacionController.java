package es.proyecto.animuslucrandi.rest;


import java.util.List;
import java.util.Set;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;
import es.proyecto.animuslucrandi.repositorios.AsociacionConIdDAO;

@RepositoryRestController
public class AsociacionController {

  private AsociacionConIdDAO asociacionDao;
  
  public AsociacionController(AsociacionConIdDAO asociacionDao) {
    this.asociacionDao = asociacionDao;
  }
  
  //@GetMapping("/asociaciones/search/{id}/por-tipo-negocios")
  @GetMapping("/asociaciones/search/por-tipo-negocios")
  @ResponseBody
  public CollectionModel<PersistentEntityResource> getAsociacionesConNegocios(
      @RequestParam("poseeFarmacia") boolean poseeFarmacia, 
      @RequestParam("poseeOptica") boolean poseeOptica,
      PersistentEntityResourceAssembler assembler) {
    
    Set<AsociacionConId> asociaciones = asociacionDao.getAsociacionesConNegocios(poseeFarmacia, poseeOptica);
    
    return assembler.toCollectionModel(asociaciones);
  }  
}
