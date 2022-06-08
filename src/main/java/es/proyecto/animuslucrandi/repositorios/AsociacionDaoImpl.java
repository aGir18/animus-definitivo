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
import es.proyecto.animuslucrandi.entidades.NegocioConId;

@Transactional(readOnly = true)
public class AsociacionDaoImpl implements AsociacionDaoCustom {

  @Autowired
  AsociacionConIdDAO asociacionDao;
  
//  AÑADIDO POR PROBLEMAS
  @Autowired
  public AsociacionDaoImpl(@Lazy AsociacionConIdDAO asociacionConIdDAO) {
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
    
    
    for (AsociacionConId asociacionConId : asociaciones) {
      for (NegocioConId negocio : asociacionConId.getNegociosAsociacion()) {
        
        if (poseeFarmacia == true && poseeOptica == true) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == NegocioConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia > 0 && contadorOptica > 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          } 
        
        else if (poseeFarmacia == false && poseeOptica == true) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == NegocioConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia == 0 && contadorOptica > 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          } 
        
        else if (poseeFarmacia == true && poseeOptica == false) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == NegocioConId.class) {
            contadorOptica = contadorOptica++;
            }
          if (contadorFarmacia > 0 && contadorOptica == 0) {
            asociacionesFiltradas.add(asociacionConId);
            }
          }
        
        else if (poseeFarmacia == false && poseeOptica == false) {
          if (negocio.getClass() == FarmaciaConId.class) {
            contadorFarmacia = contadorFarmacia++;
            }
          if (negocio.getClass() == NegocioConId.class) {
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
//    public List<Producto> getProductosDelClienteActivos(Long id) {
//      List<Producto> productos = clienteDAO.findById(id).get().getProductos().stream()
//          .filter(j -> j.getActivo() == true).collect(Collectors.toList());
//
//      return productos;
//    }
    
    /*
     * @Override
  public List<CazaConId> getCazasPorFecha(Instant fecha) {
    List<CazaConId> cazas = cazaDAO.findAll().stream().filter(c -> c.getFechaEvento().equals(fecha)).collect(Collectors.toList());
    return cazas;
  }

  @Override
  public List<CazaConId> getCazasPorFechaPosterior(Instant fecha) {
    List<CazaConId> cazas = cazaDAO.findAll().stream().filter(c -> c.getFechaEvento().isAfter(fecha)).collect(Collectors.toList());
    return cazas;
  }

@Override
  public List<AusenciaConID> getAusenciasPersona(long id) {
    List<AusenciaConID> listadoAusenciasAusenciaConIDs = new ArrayList<AusenciaConID>();
    System.err.println("persona" + persona.findById(id).get().getId());
    ausencia.findAll().forEach(a -> {
      System.out.println("ausencia" + a);
      System.err.println("idausencia" + a.getPersona().getId());
      
      if (a.getPersona() != null && a.getPersona().equals(persona.findById(id).get())) {
        listadoAusenciasAusenciaConIDs.add(a);
      }
    });
    return listadoAusenciasAusenciaConIDs;
  }


   @Override
    public List<MovimientoConId> getMovimientosPorCategorias(String categoria, Long usuarioId) {
        Query query = entityManager.createNativeQuery(
                "SELECT c.* FROM cuentas as c " +
                        "WHERE c.id_usuario= ?1", CuentaConId.class);
        query.setParameter(1, usuarioId);
        List<CuentaConId> cuentas = query.getResultList();

        List<MovimientoConId> movimientos = new ArrayList<>();
        for (CuentaConId cuenta:cuentas) {
            for (Movimiento movimiento : cuenta.getMovimientos()) {
                MovimientoConId movimientoConId = (MovimientoConId) movimiento ;
                if(movimiento.getCategoria().getNombreCategoria().equals(categoria)){
                    movimientos.add(movimientoConId);
                }
            }
        }

        return movimientos;
    }

@Override
  public SesionConId addCliente(Long idCliente, Long idHorario) {
    ClienteConId cliente = clienteDAO.findById(idCliente).get();
    SesionConId sesionConId = sesionDAO.findById(idHorario).get();
    if (sesionConId.getEntrenamiento() instanceof EntrenamientoConSala) {
      EntrenamientoConSala entrenamientoConSala = (EntrenamientoConSala) sesionConId.getEntrenamiento();
      SalaConId salaConId = entrenamientoConSala.getSala();
      int clientesApuntados = sesionConId.getClientes().size();
      int numEquipamiento = salaConId.getEquipamientos().size();
      if (numEquipamiento <= clientesApuntados) {
        
        return null;
      
      }
      
    }
    
    if (!sesionConId.getClientes().contains(cliente)) {
      sesionConId.addCliente(cliente);
      return sesionConId;
      
    }
    return null;
    
  }


     * 
     * */
    
    


}
