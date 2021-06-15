package com.PedroNel.Domain.Servicies.Interfaces;


import com.PedroNel.Domain.DTO.CategoriaDTO1;
import com.PedroNel.Domain.Entities.CategoriaEntity;

import java.util.Set;

public interface CategoriaService {

    public int consultarLastId();

    public CategoriaEntity insCategoria(CategoriaDTO1 cate);

    public int counterbyName(String nombreCategoria);

    public String actualizacionCategoria(CategoriaDTO1 cateD,int id);

    public void eliminarCategoria(int id);

    public Set<CategoriaEntity>Listar(int offset,int lim);
}
