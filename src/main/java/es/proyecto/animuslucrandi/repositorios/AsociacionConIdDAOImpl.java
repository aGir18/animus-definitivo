package es.proyecto.animuslucrandi.repositorios;

import java.util.ArrayList;
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
import es.proyecto.animuslucrandi.entidades.NegocioConId;
import es.proyecto.animuslucrandi.entidades.OpticaConId;

@Transactional(readOnly = true)
public class AsociacionConIdDAOImpl implements AsociacionConIdDAOCustom {

  @Autowired
  AsociacionConIdDAO asociacionDao;
  FarmaciaConIdDAO farmaciaDao;
  OpticaConIdDAO opticaDao;
  

//  ANNADIDO POR PROBLEMAS

  @Autowired
  public AsociacionConIdDAOImpl(@Lazy AsociacionConIdDAO asociacionConIdDAO) {
    this.asociacionDao = asociacionConIdDAO;
  }
  
  @PersistenceContext
  EntityManager entityManager;
  
  
  @Override
  public Set<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica) {
    int contadorFarmacia = 0;
    int contadorOptica = 0;
    
    List<AsociacionConId> asociaciones = asociacionDao.findAll();
    Set<AsociacionConId> asociacionesFiltradas = new HashSet<AsociacionConId>();
//    List<FarmaciaConId> farmacias = farmaciaDao.findAll();
//    List<OpticaConId> opticas = opticaDao.findAll();
//    
//    if (poseeFarmacia) {      
//      for (FarmaciaConId farmacia : farmacias) {
//        asociacionesFiltradas.add(farmacia.getAsociacion());
//      }
//    }
//    
//    if (poseeOptica) {
//      for (OpticaConId optica : opticas) {
//        asociacionesFiltradas.add(optica.getAsociacion());
//      }
//    }   
    
    for (AsociacionConId asociacionConId : asociaciones) {
      for (NegocioConId negocio : asociacionConId.getNegociosAsociacion()) {
        
        if (poseeFarmacia && poseeOptica) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == OpticaConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia > 0 && contadorOptica > 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          } 
        
        else if (!poseeFarmacia && poseeOptica) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == OpticaConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia == 0 && contadorOptica > 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          } 
        
        else if (poseeFarmacia == true && !poseeOptica) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == OpticaConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia > 0 && contadorOptica == 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          }
        
        else if (!poseeFarmacia && !poseeOptica) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == OpticaConId.class) {
            contadorOptica = contadorOptica++;
            }
          
          if (contadorFarmacia == 0 && contadorOptica == 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          }
        }
  }
          
    return asociacionesFiltradas;
  }
  
}
