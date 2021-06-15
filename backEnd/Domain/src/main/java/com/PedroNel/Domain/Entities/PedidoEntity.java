package com.PedroNel.Domain.Entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Pedidos",schema = "public")
public class PedidoEntity {

    @Id
    @Column(name = "id_pedido")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "id_cliente")
    @OneToOne(cascade = CascadeType.ALL)
    private  ClienteEntity cliente;

    @ManyToMany
    @JoinTable(name = "Pedidos_Productos",
    joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_Producto")
    )
    private Set<ProductoEntity> productosPedidos;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "consecutivo_pedido")
    private String consecutivoPedido;

    public PedidoEntity() {
    }

    public PedidoEntity(int id, ClienteEntity cliente, Set<ProductoEntity> productosPedidos, boolean estado, String consecutivoPedido) {
        this.id = id;
        this.cliente = cliente;
        this.productosPedidos = productosPedidos;
        this.estado = estado;
        this.consecutivoPedido = consecutivoPedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public Set<ProductoEntity> getProductosPedidos() {
        return productosPedidos;
    }

    public void setProductosPedidos(Set<ProductoEntity> productosPedidos) {
        this.productosPedidos = productosPedidos;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getConsecutivoPedido() {
        return consecutivoPedido;
    }

    public void setConsecutivoPedido(String consecutivoPedido) {
        this.consecutivoPedido = consecutivoPedido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoEntity)) return false;
        PedidoEntity that = (PedidoEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "PedidoEntity{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", productosPedidos=" + productosPedidos +
                ", estado=" + estado +
                ", consecutivoPedido='" + consecutivoPedido + '\'' +
                '}';
    }
}
