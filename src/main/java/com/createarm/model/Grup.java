package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Grup {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nomer")
    private String nomer;
    @Basic
    @Column(name = "id_cpec")
    private Integer idCpec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public Integer getIdCpec() {
        return idCpec;
    }

    public void setIdCpec(Integer idCpec) {
        this.idCpec = idCpec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grup grup = (Grup) o;
        return id == grup.id && Objects.equals(nomer, grup.nomer) && Objects.equals(idCpec, grup.idCpec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomer, idCpec);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "nomer=" + nomer + '|' +
                "id_cpec=" + idCpec;
    }
}
