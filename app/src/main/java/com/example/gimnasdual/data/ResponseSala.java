package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSala {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("codi")
    @Expose
    private String codi;
    @SerializedName("aforament")
    @Expose
    private long aforament;
    @SerializedName("descripcio")
    @Expose
    private String descripcio;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseSala() {
    }

    /**
     *
     * @param id
     * @param descripcio
     * @param codi
     * @param image
     * @param $id
     * @param aforament
     * @param nom
     */
    public ResponseSala(String $id, long id, String nom, String codi, long aforament, String descripcio, String image) {
        super();
        this.$id = $id;
        this.id = id;
        this.nom = nom;
        this.codi = codi;
        this.aforament = aforament;
        this.descripcio = descripcio;
        this.image = image;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseSala with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseSala withId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ResponseSala withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public ResponseSala withCodi(String codi) {
        this.codi = codi;
        return this;
    }

    public long getAforament() {
        return aforament;
    }

    public void setAforament(long aforament) {
        this.aforament = aforament;
    }

    public ResponseSala withAforament(long aforament) {
        this.aforament = aforament;
        return this;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public ResponseSala withDescripcio(String descripcio) {
        this.descripcio = descripcio;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ResponseSala withImage(String image) {
        this.image = image;
        return this;
    }

}