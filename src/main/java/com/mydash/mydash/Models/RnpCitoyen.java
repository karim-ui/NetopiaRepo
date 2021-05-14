package com.mydash.mydash.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
public class RnpCitoyen {
    @Id
    private String cin;
    private String idcs;
    private String nom;
    private String prenom;
    private String ville;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date date_naissance;
    private String sex;

    public RnpCitoyen(String cin, String idcs, String nom, String prenom, String ville, Date date_naissance, String sex) {
        this.cin = cin;
        this.idcs = idcs;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.date_naissance = date_naissance;
        this.sex = sex;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getIdcs() {
        return idcs;
    }

    public void setIdcs(String idcs) {
        this.idcs = idcs;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public RnpCitoyen() {
    }
}
