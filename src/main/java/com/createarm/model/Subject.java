package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Subject extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nam")
    private String nam;
    @Basic
    @Column(name = "id_kaf")
    private Integer idKaf;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
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
        Subject subject = (Subject) o;
        return id == subject.id && Objects.equals(nam, subject.nam) && Objects.equals(idKaf, subject.idKaf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nam, idKaf);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "nam=" + nam + '|' +
                "id_kaf=" + idKaf;
    }
}
