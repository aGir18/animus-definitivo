package es.proyecto.animuslucrandi.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import es.proyecto.animuslucrandi.entidades.FarmaciaConId;

public interface FarmaciaDAO extends JpaRepository<FarmaciaConId, Long>{

}
