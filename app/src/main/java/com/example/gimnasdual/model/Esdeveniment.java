package com.example.gimnasdual.model;

public class Esdeveniment {
    private int id;
    private String titol;
    private String data;
    private String descripcio;
    private String lloc;
    private String tipus;
    private int image;

    public Esdeveniment() {
    }

    public Esdeveniment(int id, String titol, String data, String descripcio, String lloc, String tipus, int image) {
        this.id = id;
        this.titol = titol;
        this.data = data;
        this.descripcio = descripcio;
        this.lloc = lloc;
        this.tipus = tipus;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Esdeveniment{" +
                "id=" + id +
                ", titol='" + titol + '\'' +
                ", data='" + data + '\'' +
                ", descripcio='" + descripcio + '\'' +
                ", lloc='" + lloc + '\'' +
                ", tipus='" + tipus + '\'' +
                ", image=" + image +
                '}';
    }
}
