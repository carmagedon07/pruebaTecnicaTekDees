package com.PedroNel.Domain.Repository;

import com.PedroNel.Domain.Entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity,Integer > {

    //update
    //delet
    //query

    // otros

    //consulta del ultimo id de la tabla categoria
    @Query(value = "SELECT * FROM public.categorias\n" +
            "            ORDER BY id_categoria DESC\n" +
            "            offset 0 limit 1",nativeQuery = true)
    CategoriaEntity lastIdCategoria();

    @Query(value = "\tSELECT * FROM public.categorias\n" +
            "            ORDER BY id_categoria ASC\n" +
            "            offset :intOffset limit :intLimite",nativeQuery = true)
    Set<CategoriaEntity>ConsultaCategoriaPag(@Param("intLimite")int intLimite , @Param("intOffset")int intOffset );


    @Modifying
    @Transactional()
    @Query(value = "INSERT INTO public.categorias(\n" +
            "\tid_categoria)\n" +
            "\tVALUES (0)",nativeQuery = true)
    public void insertarPrimerId();

    @Query(value = "\t select count(*)\n" +
            "  from public.categorias\n" +
            "  where nombre_categoria= :nombre",nativeQuery = true)
    public int  contadorByNombre(@Param("nombre")String nombre);

    @Query(value = "\t select count(*)\n" +
            "  from public.categorias\n" +
            "  where id_categoria= :idCategoria",nativeQuery = true)
    public int  contadorById(@Param("idCategoria")int idCategoria);

    @Modifying
    @Transactional
    @Query(value = "UPDATE public.categorias\n" +
            "\tSET  descripcion= :strDescripcion, nombre_categoria= :strNombreCategoria\n" +
            "\tWHERE id_categoria = :idCategoria;",nativeQuery = true)
    public void actualizacionCategori(@Param("idCategoria")int idCategoria,
                                      @Param("strNombreCategoria")String strNombreCategoria,
                                      @Param("strDescripcion")String strDescripcion );


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM public.categorias\n" +
            "\tWHERE id_categoria= :idCategoria",nativeQuery = true)
    public void eliminarCategoriabById(@Param("idCategoria")int idCategoria);

}
