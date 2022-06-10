package es.proyecto.animuslucrandi.repositorios;

import java.util.List;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

public interface AsociacionConIdDAOCustom {

  List<AsociacionConId> getAsociacionesConNegocios(boolean poseeFarmacia, boolean poseeOptica);
  
}
