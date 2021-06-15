package com.PedroNel.Domain.Repository;

import com.PedroNel.Domain.Entities.CiudadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<CiudadEntity,Integer> {
}
