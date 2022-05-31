package es.proyecto.animuslucrandi.rest;


import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import es.proyecto.animuslucrandi.repositorios.AsociacionConIdDAO;

@RepositoryRestController
@RequestMapping(path = "/asociaciones")
public class AsociacionController {

  private AsociacionConIdDAO asociacionDao;
  
  public AsociacionController(AsociacionConIdDAO asociacionDao) {
    this.asociacionDao = asociacionDao;
  }
  
  @GetMapping("/search/contiene-negocios")
  @ResponseBody
  public CollectionModel<PersistentEntityResource> getClientesConFechaPosterior(@RequestParam("poseeFarmacia") boolean poseeFarmacia,
      @RequestParam("poseeOptica") boolean poseeOptica, PersistentEntityResourceAssembler assembler) {

    
//List<Cliente> clientes = clienteDAO.getClientesConFechaPosterior(fecha);

    return null;
  }
  
//  @GetMapping("/search/con-fecha-nacimiento-anterior-a")
//  @ResponseBody
//  public CollectionModel<PersistentEntityResource> getClientesConFechaAnterior(@RequestParam("fecha") Instant fecha,
//      PersistentEntityResourceAssembler assembler) {
//
//    List<Cliente> clientes = clienteDAO.getClientesConFechaAnterior(fecha);
//
//    return assembler.toCollectionModel(clientes);
//  }
  
}
