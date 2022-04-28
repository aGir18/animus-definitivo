package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.proyecto.animuslucrandi.entidades.AsociacionConId;

public interface AsociacionDAO extends JpaRepository<AsociacionConId, Long> {

}
