package com.PedroNel.Domain.Repository;

import com.PedroNel.Domain.Entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductoRepository extends JpaRepository<ProductoEntity,Integer> {

    //insert



    //update
    //delet
    //query

    // otros
    @Query(value = "\tSELECT id_producto FROM public.productos\n" +
            "            ORDER BY id_producto DESC\n" +
            "            offset 0 limit 1",nativeQuery = true)
    int lastIdProducto();

    // agregar el primer id producto si la tabla esta vacia
    @Modifying
    @Transactional()
    @Query(value = "INSERT INTO public.productos(\n" +
            "\tid_producto)\n" +
            "\tVALUES (0)",nativeQuery = true)
    public void insertarPrimerIdProducto();

    // cuenta cuantos elementos existe por nombre del producto

    @Query(value = "\t select count(*)\n" +
            "  from public.productos\n" +
            "  where nombre_producto= :nombreProducto",nativeQuery = true)
    public int  contadorByNombre(@Param("nombreProducto")String nombreProducto);

    //Cuenta el producto por id
    @Query(value = "\t select count(*)\n" +
            "  from public.productos\n" +
            "  where id_producto= :idProducto",nativeQuery = true)
    public int  contadorById(@Param("idProducto")int idProducto);

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.categorias\n" +
            "\tSET  descripcion= :strDescripcion, nombre_categoria= :strNombreCategoria\n" +
            "\tWHERE id_categoria = :idCategoria;",nativeQuery = true)
    public void actualizacionCategori(@Param("idCategoria")int idCategoria,
                                      @Param("strNombreCategoria")String strNombreCategoria,
                                      @Param("strDescripcion")String strDescripcion );

    // metodo para actualizar el producto
    @Modifying
    @Transactional
    @Query(value = "UPDATE public.productos\n" +
            "\tSET cantidad_stock= :cantidadStock, codigo_barras= :codigoBarras, descripcion= :strDescripcion, " +
            "nombre_producto= :nombreProducto, precio= :precio, id_categoria= idCategoria\n" +
            "\tWHERE id_producto=idProducto",nativeQuery = true)
    public void actualizacionProducto(@Param("cantidadStock")int cantidadStock,
                                      @Param("codigoBarras")int codigoBarras,
                                      @Param("nombreProducto")String nombreProducto ,
                                      @Param("precio")float precio ,
                                      @Param("idCategoria")int idCategoria ,
                                      @Param("idProducto")int idProducto );
    // eliminacion de un producto
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.productos\n" +
            "\tWHERE id_producto= :idProducto",nativeQuery = true)
    public void eliminarProductobById(@Param("idProducto")int idProducto);

    // insertar un producto


    @Modifying
    @Transactional
    @Query(value="INSERT INTO public.productos(\n" +
            "            id_producto, cantidad_stock, codigo_barras, descripcion, nombre_producto, precio, id_categoria)\n" +
            "    VALUES (:idProducto, :cantidadStock, :codigoBarras, :strDescripcion, :nombreProducto, :precio, :idCategoria)"
            ,nativeQuery = true)
    void insertarProducto(@Param("idProducto")int idProducto,
                          @Param("cantidadStock")int cantidadStock,
                          @Param("codigoBarras")int codigoBarras,
                          @Param("strDescripcion")String strDescripcion,
                          @Param("nombreProducto")String nombreProducto,
                          @Param("precio")float precio,
                          @Param("idCategoria")int idCategoria );
}
