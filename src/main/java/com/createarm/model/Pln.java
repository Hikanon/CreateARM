package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Pln {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_subj")
    private Integer idSubj;
    @Basic
    @Column(name = "semestr")
    private Integer semestr;
    @Basic
    @Column(name = "id_otch")
    private Integer idOtch;
    @Basic
    @Column(name = "id_cpec")
    private Integer idCpec;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdSubj() {
        return idSubj;
    }

    public void setIdSubj(Integer idSubj) {
        this.idSubj = idSubj;
    }

    public Integer getSemestr() {
        return semestr;
    }

    public void setSemestr(Integer semestr) {
        this.semestr = semestr;
    }

    public Integer getIdOtch() {
        return idOtch;
    }

    public void setIdOtch(Integer idOtch) {
        this.idOtch = idOtch;
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
        Pln pln = (Pln) o;
        return id == pln.id && Objects.equals(idSubj, pln.idSubj) && Objects.equals(semestr, pln.semestr) && Objects.equals(idOtch, pln.idOtch) && Objects.equals(idCpec, pln.idCpec);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSubj, semestr, idOtch, idCpec);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "id_subj=" + idSubj + '|' +
                "semestr=" + semestr + '|' +
                "id_otch=" + idOtch + '|' +
                "id_cpec=" + idCpec;
    }
}
