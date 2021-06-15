package com.PedroNel.Domain.Servicies.Interfaces;

import com.PedroNel.Domain.DTO.CategoriaDTO1;
import com.PedroNel.Domain.DTO.ProductoDTO1;
import com.PedroNel.Domain.Entities.CategoriaEntity;
import com.PedroNel.Domain.Entities.ProductoEntity;

import java.util.Set;

public interface ProductoService {

    public int consultarLastIdProducto();

    //insertar categoria
    public void insProducto(ProductoDTO1 prodD);

    // contador por nombre del producto
    public int counterbyNameProduct(String nombreCategoria);

    public String actualizacionProducto(ProductoDTO1 prodD,int id);

    // eliminar producto por id del mismo
    public void eliminarproducto(int id);

    //public Set<CategoriaEntity> Listar(int offset, int lim);
}
