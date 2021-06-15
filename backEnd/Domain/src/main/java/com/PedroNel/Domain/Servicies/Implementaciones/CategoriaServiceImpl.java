package com.PedroNel.Domain.Servicies.Implementaciones;

import com.PedroNel.Domain.DTO.CategoriaDTO1;
import com.PedroNel.Domain.Entities.CategoriaEntity;
import com.PedroNel.Domain.Repository.CategoriaRepository;
import com.PedroNel.Domain.Servicies.Interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;


    @Override
    public int consultarLastId() {

        try {


            return categoriaRepository.lastIdCategoria().getIdCategoria();

        }catch (Exception e)
        {
            categoriaRepository.insertarPrimerId();

            return categoriaRepository.lastIdCategoria().getIdCategoria();
        }

    }

    @Override
    public CategoriaEntity insCategoria(CategoriaDTO1 cateD) {

        int id,count;
        String nombre,descripcion;
        CategoriaEntity categ =new CategoriaEntity();



        id =consultarLastId();
        id++;

        nombre =cateD.getNombreCategoria();
        descripcion = cateD.getDescripcion();

        categ.setIdCategoria(id);
        categ.setNombreCategoria(nombre);
        categ.setDescripcion(descripcion);

        return categoriaRepository.save(categ);
    }

    @Override
    public int counterbyName(String nombreCategoria) {

        return categoriaRepository.contadorByNombre(nombreCategoria);
    }

    @Override
    public String actualizacionCategoria(CategoriaDTO1 cateD,int id) {

        int counter;
        String nombrecategoria,descripcion;

        counter = categoriaRepository.contadorById(id);

        if(counter==1){

            nombrecategoria = cateD.getNombreCategoria();
            descripcion =cateD.getDescripcion();

            categoriaRepository.actualizacionCategori(id,nombrecategoria,descripcion);

            return "Actualizada la categoria";

        }else{
            return "No Existe la categoria";
        }
    }

    @Override
    public void eliminarCategoria(int id) {
        categoriaRepository.eliminarCategoriabById(id);
    }

    @Override
    public Set<CategoriaEntity> Listar(int offset,int lim) {
        return categoriaRepository.ConsultaCategoriaPag(offset,lim);
    }


}
