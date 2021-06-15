package com.PedroNel.Domain.Servicies.Implementaciones;

import com.PedroNel.Domain.DTO.CategoriaDTO1;
import com.PedroNel.Domain.DTO.ProductoDTO1;
import com.PedroNel.Domain.Entities.CategoriaEntity;
import com.PedroNel.Domain.Entities.ProductoEntity;
import com.PedroNel.Domain.Repository.ProductoRepository;
import com.PedroNel.Domain.Servicies.Interfaces.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository produRep;

    @Override
    public int consultarLastIdProducto() {

        try{
            return produRep.lastIdProducto();
        }catch (Exception e)
        {
            produRep.insertarPrimerIdProducto();


            return produRep.lastIdProducto();
        }

    }

    @Override
    public void insProducto(ProductoDTO1 prodD) {

        int id,count,codigoBarras,cantidadStock,idCategoria;
        String nombreProducto,descripcion;
        float precio;


         id=this.consultarLastIdProducto();
         id++;

        nombreProducto= prodD.getNombreProducto();
        descripcion= prodD.getDescripcion();
        codigoBarras = prodD.getCodigoBarras();
        cantidadStock=prodD.getCantidadStock();
        precio =prodD.getPrecio();
        idCategoria =prodD.getIdCategoria();

        produRep.insertarProducto(id,cantidadStock,codigoBarras,descripcion,nombreProducto,precio,idCategoria);


    }

    @Override
    public int counterbyNameProduct(String nombreCategoria) {

        return produRep.contadorByNombre(nombreCategoria);
    }



    @Override
    public String actualizacionProducto(ProductoDTO1 prodD, int id) {

        int counter,codigoBarras,cantidadStock,idCategoria;
        String nombreProducto,descripcion;
        float precio;


        counter = produRep.contadorById(id);

        if(counter==1){

            nombreProducto= prodD.getNombreProducto();
            descripcion= prodD.getDescripcion();
            codigoBarras = prodD.getCodigoBarras();
            cantidadStock=prodD.getCantidadStock();
            precio =prodD.getPrecio();
            idCategoria =prodD.getIdCategoria();

            produRep.actualizacionProducto(cantidadStock,codigoBarras,nombreProducto,precio,idCategoria,id);

            return "Actualizado el producto";

        }else{
            return "No Existe el producto";
        }

    }

    @Override
    public void eliminarproducto(int id) {

        produRep.eliminarProductobById(id);

    }
}
