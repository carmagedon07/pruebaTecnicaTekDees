package com.PedroNel.Domain.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Clientes",schema = "public")
public class ClienteEntity {

    @Id
    @Column(name = "id_cliente")
    private int id;
    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(name = "numero_documento")
    private int numeroDocumento;

    @Column(name = "nombre")
    private  String Nombre;

    @Column(name = "apellido")
    private String apellidos;

    @Column(name = "direcion")
    private String direcion;

    @JoinColumn(name = "id_Ciudad")
    @OneToOne(cascade = CascadeType.ALL)
    private CiudadEntity ciudadResidencia;

    @Column(name = "correoElectronico")
    private String correoElectronico;


    public ClienteEntity() {
    }

    public ClienteEntity(int id, String tipoDocumento, int numeroDocumento, String nombre, String apellidos, String direcion, CiudadEntity ciudadResidencia, String correoElectronico) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        Nombre = nombre;
        this.apellidos = apellidos;
        this.direcion = direcion;
        this.ciudadResidencia = ciudadResidencia;
        this.correoElectronico = correoElectronico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(int numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public CiudadEntity getCiudadResidencia() {
        return ciudadResidencia;
    }

    public void setCiudadResidencia(CiudadEntity ciudadResidencia) {
        this.ciudadResidencia = ciudadResidencia;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClienteEntity)) return false;
        ClienteEntity that = (ClienteEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ClienteEntity{" +
                "id=" + id +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento=" + numeroDocumento +
                ", Nombre='" + Nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direcion='" + direcion + '\'' +
                ", ciudadResidencia=" + ciudadResidencia +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
