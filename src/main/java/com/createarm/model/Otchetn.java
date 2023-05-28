package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Otchetn extends BaseEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "nam")
    private String nam;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Otchetn otchetn = (Otchetn) o;
        return id == otchetn.id && Objects.equals(nam, otchetn.nam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nam);
    }

    @Override
    public String toString() {
        return "id=" + id + '|' +
                "nam=" + nam;
    }
}
