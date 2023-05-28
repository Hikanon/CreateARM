package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Sessia extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_pln")
    private Integer idPln;
    @Basic
    @Column(name = "id_stud")
    private Integer idStud;
    @Basic
    @Column(name = "id_mark")
    private Integer idMark;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdPln() {
        return idPln;
    }

    public void setIdPln(Integer idPln) {
        this.idPln = idPln;
    }

    public Integer getIdStud() {
        return idStud;
    }

    public void setIdStud(Integer idStud) {
        this.idStud = idStud;
    }

    public Integer getIdMark() {
        return idMark;
    }

    public void setIdMark(Integer idMark) {
        this.idMark = idMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sessia sessia = (Sessia) o;
        return id == sessia.id && Objects.equals(idPln, sessia.idPln) && Objects.equals(idStud, sessia.idStud) && Objects.equals(idMark, sessia.idMark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPln, idStud, idMark);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "id_pln=" + idPln + '|' +
                "id_stud=" + idStud + '|' +
                "id_mark=" + idMark;
    }
}
