package com.PedroNel.Domain.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Productos",schema = "public")
public class ProductoEntity {

    @Id
    @Column(name = "id_Producto")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "codigo_barras")
    private int codigoBarras;

    @Column(name = "nombre_producto")
    private String nombreProducto;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private float precio;

    @Column(name = "cantidad_stock")
    private int cantidadStock;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_categoria")
    private CategoriaEntity categoria;

    public ProductoEntity() {
    }

    public ProductoEntity(int id, int codigoBarras,String nombreProducto ,String descripcion, float precio, int cantidadStock, CategoriaEntity categoria) {
        this.id = id;
        this.codigoBarras = codigoBarras;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
        this.nombreProducto =nombreProducto;
    }


    public int getId() {
        return id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(int codigoBarras) {
        this.codigoBarras = codigoBarras;
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

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductoEntity)) return false;
        ProductoEntity that = (ProductoEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductoEntity{" +
                "id=" + id +
                "nombreProducto="+nombreProducto+'\'' +
                ", codigoBarras=" + codigoBarras +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadStock=" + cantidadStock +
                ", categoria=" + categoria +
                '}';
    }
}
