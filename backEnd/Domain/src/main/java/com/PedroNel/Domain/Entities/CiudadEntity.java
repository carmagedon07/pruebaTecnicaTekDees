package com.PedroNel.Domain.Entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Ciudades", schema = "public")
public class CiudadEntity {

    @Id
    @Column(name = "id_Ciudad")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    public CiudadEntity() {
    }

    public CiudadEntity(int id, String nombreCiudad) {
        this.id = id;
        this.nombreCiudad = nombreCiudad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CiudadEntity)) return false;
        CiudadEntity that = (CiudadEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
