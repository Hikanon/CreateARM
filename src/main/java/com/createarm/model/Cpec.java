package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity(name = "cpec")
public class Cpec extends BaseEntity{
    @Basic
    @Column(name = "cod")
    private String cod;
    @Basic
    @Column(name = "liter")
    private String liter;
    @Basic
    @Column(name = "nam")
    private String nam;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getLiter() {
        return liter;
    }

    public void setLiter(String liter) {
        this.liter = liter;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
    }

    @Override
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
        Cpec cpec = (Cpec) o;
        return id == cpec.id && Objects.equals(cod, cpec.cod) && Objects.equals(liter, cpec.liter) && Objects.equals(nam, cpec.nam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod, liter, nam, id);
    }

    @Override
    public String toString() {
        return "cod=" + cod + '|' +
                "liter=" + liter + '|' +
                "nam=" + nam + '|' +
                "id=" + id;
    }
}
