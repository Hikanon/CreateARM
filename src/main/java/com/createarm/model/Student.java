package com.createarm.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "id_grup")
    private Integer idGrup;
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
    @Column(name = "pol")
    private String pol;
    @Basic
    @Column(name = "rozhd")
    private Date rozhd;
    @Basic
    @Column(name = "ves")
    private Float ves;
    @Basic
    @Column(name = "rost")
    private Float rost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdGrup() {
        return idGrup;
    }

    public void setIdGrup(Integer idGrup) {
        this.idGrup = idGrup;
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

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public Date getRozhd() {
        return rozhd;
    }

    public void setRozhd(Date rozhd) {
        this.rozhd = rozhd;
    }

    public Float getVes() {
        return ves;
    }

    public void setVes(Float ves) {
        this.ves = ves;
    }

    public Float getRost() {
        return rost;
    }

    public void setRost(Float rost) {
        this.rost = rost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(idGrup, student.idGrup) && Objects.equals(fam, student.fam) && Objects.equals(nam, student.nam) && Objects.equals(otc, student.otc) && Objects.equals(pol, student.pol) && Objects.equals(rozhd, student.rozhd) && Objects.equals(ves, student.ves) && Objects.equals(rost, student.rost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idGrup, fam, nam, otc, pol, rozhd, ves, rost);
    }
}
