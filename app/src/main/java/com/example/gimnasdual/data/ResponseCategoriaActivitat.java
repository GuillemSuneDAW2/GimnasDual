package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCategoriaActivitat {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseCategoriaActivitat() {
    }

    /**
     *
     * @param id
     * @param image
     * @param $id
     * @param nom
     */
    public ResponseCategoriaActivitat(String $id, long id, String nom, String image) {
        super();
        this.$id = $id;
        this.id = id;
        this.nom = nom;
        this.image = image;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseCategoriaActivitat with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseCategoriaActivitat withId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ResponseCategoriaActivitat withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ResponseCategoriaActivitat withImage(String image) {
        this.image = image;
        return this;
    }

}