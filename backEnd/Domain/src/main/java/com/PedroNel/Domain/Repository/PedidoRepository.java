package com.PedroNel.Domain.Repository;

import com.PedroNel.Domain.Entities.CategoriaEntity;
import com.PedroNel.Domain.Entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PedidoRepository extends JpaRepository<PedidoEntity,Integer> {

    @Query(value = "\tSELECT * FROM public.pedidos\n" +
            "            ORDER BY id_pedido ASC\n" +
            "            offset :intOffset limit :intLimite",nativeQuery = true)
    Set<PedidoEntity> ConsultaPedidoPag(@Param("intLimite")int intLimite , @Param("intOffset")int intOffset );
}
