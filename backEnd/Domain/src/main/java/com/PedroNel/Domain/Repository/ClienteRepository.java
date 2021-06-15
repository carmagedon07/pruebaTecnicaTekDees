package com.PedroNel.Domain.Repository;

import com.PedroNel.Domain.Entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity,Integer> {
}
