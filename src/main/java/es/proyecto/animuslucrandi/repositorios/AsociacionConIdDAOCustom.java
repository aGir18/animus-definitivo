package es.proyecto.animuslucrandi.repositorios;

import java.util.List;
import java.util.Set;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

public interface AsociacionConIdDAOCustom {

  Set<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica);
  
}
