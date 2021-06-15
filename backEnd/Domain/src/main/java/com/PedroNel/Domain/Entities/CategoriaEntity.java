package com.PedroNel.Domain.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Categorias", schema = "public")
public class CategoriaEntity {

    @Id
    @Column(name = "id_categoria")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategoria;

    @Column(name = "nombre_categoria")
    private String nombreCategoria;

    @Column(name = "descripcion")
    private String descripcion;

    public CategoriaEntity() {
    }

    public CategoriaEntity(int idCategoria, String nombreCategoria, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
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

    @Override
    public String toString() {
        return "CategoriaEntity{" +
                "idCategoria=" + idCategoria +
                ", nombreCategoria='" + nombreCategoria + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoriaEntity)) return false;
        CategoriaEntity that = (CategoriaEntity) o;
        return idCategoria == that.idCategoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCategoria);
    }
}
