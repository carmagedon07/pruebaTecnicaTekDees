package com.PedroNel.Domain.DTO;

import com.PedroNel.Domain.Entities.CategoriaEntity;

import javax.persistence.*;

// Esta clase ayuda a la trasferecia de datos del cliente a las consultas del servidor
//contiene la mayoria de atibutos del entity Producto excepto el atributo Id
public class ProductoDTO1 {

    private int codigoBarras;

    private String nombreProducto;

    private String descripcion;

    private float precio;

    private int cantidadStock;

    private int idCategoria;

    public ProductoDTO1() {
    }

    public ProductoDTO1(int codigoBarras, String nombreProducto, String descripcion, float precio, int cantidadStock, int idCategoria) {
        this.codigoBarras = codigoBarras;
        this.nombreProducto = nombreProducto;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.idCategoria = idCategoria;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
