package es.proyecto.animuslucrandi.repositorios;

import java.util.Set;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

public interface AsociacionDaoCustom {

  Set<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica);
  
}
