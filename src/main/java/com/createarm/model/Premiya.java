package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Premiya {
    @Basic
    @Column(name = "fami")
    private String fami;
    @Basic
    @Column(name = "imya")
    private String imya;
    @Basic
    @Column(name = "srball")
    private Float srball;
    @Basic
    @Column(name = "summa")
    private Integer summa;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public String getFami() {
        return fami;
    }

    public void setFami(String fami) {
        this.fami = fami;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public Float getSrball() {
        return srball;
    }

    public void setSrball(Float srball) {
        this.srball = srball;
    }

    public Integer getSumma() {
        return summa;
    }

    public void setSumma(Integer summa) {
        this.summa = summa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Premiya premiya = (Premiya) o;
        return id == premiya.id && Objects.equals(fami, premiya.fami) && Objects.equals(imya, premiya.imya) && Objects.equals(srball, premiya.srball) && Objects.equals(summa, premiya.summa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fami, imya, srball, summa, id);
    }
}
