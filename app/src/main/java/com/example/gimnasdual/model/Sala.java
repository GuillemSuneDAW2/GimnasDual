package com.example.gimnasdual.model;

public class Sala {
    private int id;
    private String nom;
    private String codi;
    private int aforament;
    private String descripcio;
    private int image;

    public Sala() {
    }

    public Sala(int id, String nom, String codi, int aforament, String descripcio, int image) {
        this.id = id;
        this.nom = nom;
        this.codi = codi;
        this.aforament = aforament;
        this.descripcio = descripcio;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public int getAforament() {
        return aforament;
    }

    public void setAforament(int aforament) {
        this.aforament = aforament;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", codi='" + codi + '\'' +
                ", aforament=" + aforament +
                ", descripcio='" + descripcio + '\'' +
                ", image=" + image +
                '}';
    }
}
