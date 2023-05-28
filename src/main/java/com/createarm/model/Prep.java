package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Prep {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fam")
    private String fam;
    @Basic
    @Column(name = "nam")
    private String nam;
    @Basic
    @Column(name = "otc")
    private String otc;
    @Basic
    @Column(name = "id_kaf")
    private Integer idKaf;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFam() {
        return fam;
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    public String getOtc() {
        return otc;
    }

    public void setOtc(String otc) {
        this.otc = otc;
    }

    public Integer getIdKaf() {
        return idKaf;
    }

    public void setIdKaf(Integer idKaf) {
        this.idKaf = idKaf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prep prep = (Prep) o;
        return id == prep.id && Objects.equals(fam, prep.fam) && Objects.equals(nam, prep.nam) && Objects.equals(otc, prep.otc) && Objects.equals(idKaf, prep.idKaf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fam, nam, otc, idKaf);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "fam=" + fam + '|' +
                "nam=" + nam + '|' +
                "otc=" + otc + '|' +
                "id_kaf=" + idKaf;
    }
}
