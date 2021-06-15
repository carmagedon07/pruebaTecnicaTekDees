package com.PedroNel.Domain.DTO;

import javax.persistence.Column;

// Esta clase es similar a Categoria entity ,No tendra el campo Id
// se utlizara para optimizar las transferencias Rest de categoria
public class CategoriaDTO1 {

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "descripcion")
    private String descripcion;

    public CategoriaDTO1() {
    }

    public CategoriaDTO1(String nombreCategoria, String descripcion) {
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
