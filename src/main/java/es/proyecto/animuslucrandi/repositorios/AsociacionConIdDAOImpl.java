package es.proyecto.animuslucrandi.repositorios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;
import es.proyecto.animuslucrandi.entidades.FarmaciaConId;
import es.proyecto.animuslucrandi.entidades.OpticaConId;

@Transactional(readOnly = true)
public class AsociacionConIdDAOImpl implements AsociacionConIdDAOCustom {

  @Autowired
  AsociacionConIdDAO asociacionDao;
  FarmaciaConIdDAO farmaciaDao;
  OpticaConIdDAO opticaDao;

  @Autowired
  public AsociacionConIdDAOImpl(@Lazy AsociacionConIdDAO asociacionConIdDAO, FarmaciaConIdDAO farmaciaConIdDAO, OpticaConIdDAO opticaConIdDAO) {
    this.asociacionDao = asociacionConIdDAO;
    this.farmaciaDao = farmaciaConIdDAO;
    this.opticaDao = opticaConIdDAO;
  }
  
  @PersistenceContext
  EntityManager entityManager;
  
  
  @Override
  public Set<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica) {

    Set<AsociacionConId> asociacionesFiltradas = new HashSet<AsociacionConId>();
    List<FarmaciaConId> farmacias = farmaciaDao.findAll();
    List<OpticaConId> opticas = opticaDao.findAll();
    
    if (poseeFarmacia && poseeOptica) {      
      for (FarmaciaConId farmacia : farmacias) {
        asociacionesFiltradas.add(farmacia.getAsociacion());
      }
      for (OpticaConId optica : opticas) {
        asociacionesFiltradas.add(optica.getAsociacion());
      }
    }
    
    if (!poseeFarmacia && poseeOptica) {   
      for (OpticaConId optica : opticas) {
        asociacionesFiltradas.add(optica.getAsociacion());
      }
      for (FarmaciaConId farmaciaEliminar : farmacias) {
        asociacionesFiltradas.remove(farmaciaEliminar.getAsociacion());
      }
    }
    
    if (poseeFarmacia && !poseeOptica) {
      for (FarmaciaConId farmacia : farmacias) {
        asociacionesFiltradas.add(farmacia.getAsociacion());
      }
      for (OpticaConId opticaEliminar : opticas) {
        asociacionesFiltradas.remove(opticaEliminar.getAsociacion());
      }
    }
    
    

    return asociacionesFiltradas;
  }
  
}
