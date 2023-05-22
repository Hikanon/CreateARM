package com.createarm.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Marks {
    @Basic
    @Column(name = "mark")
    private int mark;
    @Basic
    @Column(name = "nam")
    private String nam;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getNam() {
        return nam;
    }

    public void setNam(String nam) {
        this.nam = nam;
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
        Marks marks = (Marks) o;
        return mark == marks.mark && id == marks.id && Objects.equals(nam, marks.nam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark, nam, id);
    }
}
