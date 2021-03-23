package com.aronika;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ARTIKEL")
public class Artikel implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int nr;
    private String name;
    private String beschreibung;
    private String bild;
    @Temporal(TemporalType.DATE)
    private Date verfuegbarAb;

    public Artikel() {
    }

    public Artikel(int nr, String name, String beschreibung, String bild) {
        this.nr = nr;
        this.name = name;
        this.beschreibung = beschreibung;
        this.bild = bild;
        this.verfuegbarAb = new Date(0);
    }

    public Artikel(int nr, String name, String beschreibung, String bild, Date verfuegbarAb) {
        this.nr = nr;
        this.name = name;
        this.beschreibung = beschreibung;
        this.bild = bild;
        this.verfuegbarAb = verfuegbarAb;
    }

    public Artikel(String name, String beschreibung, String bild, Date verfuegbarAb) {
        this.name = name;
        this.beschreibung = beschreibung;
        this.bild = bild;
        this.verfuegbarAb = verfuegbarAb;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return this.nr;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return this.beschreibung;
    }

    public void setBeschreibung(String b) {
        this.beschreibung = b;
    }

    public String getBild() {
        return this.bild;
    }

    public void setBild(String urlPfad) {
        this.bild = urlPfad;
    }

    public Date getVerfuegbarAb() {
        return this.verfuegbarAb;
    }

    public void setVerfuegbarAb(Date verfuegbarAb) {
        this.verfuegbarAb = verfuegbarAb;
    }

    @Override
    public String toString() {
        return "Artikel [nr=" + this.nr + ", name=" + this.name + ", beschreibung=" + this.beschreibung + ", bild=" + this.bild + ", verfuegbarAb=" + this.verfuegbarAb + "]";
    }

}