package es.proyecto.animuslucrandi.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

@Transactional(readOnly = true)
public class AsociacionDaoImpl implements AsociacionDaoCustom {

  @Autowired
  AsociacionConIdDAO asociacionDao;
  
  @PersistenceContext
  EntityManager entityManager;
  
  @Override
  public List<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica) {
    List<AsociacionConId> asociaciones = asociacionDao.findAll();
    System.out.println("La longitud es " + asociaciones);
    
    
    return asociaciones;
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
