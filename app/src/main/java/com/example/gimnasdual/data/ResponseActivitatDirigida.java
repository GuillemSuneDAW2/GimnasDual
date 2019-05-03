package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseActivitatDirigida {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("descripcio")
    @Expose
    private String descripcio;
    @SerializedName("tipologia")
    @Expose
    private String tipologia;
    @SerializedName("intensitat")
    @Expose
    private String intensitat;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("category_Id")
    @Expose
    private long categoryId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseActivitatDirigida() {
    }

    /**
     *
     * @param id
     * @param tipologia
     * @param descripcio
     * @param categoryId
     * @param intensitat
     * @param image
     * @param $id
     * @param nom
     */
    public ResponseActivitatDirigida(String $id, long id, String nom, String descripcio, String tipologia, String intensitat, String image, long categoryId) {
        super();
        this.$id = $id;
        this.id = id;
        this.nom = nom;
        this.descripcio = descripcio;
        this.tipologia = tipologia;
        this.intensitat = intensitat;
        this.image = image;
        this.categoryId = categoryId;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseActivitatDirigida with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseActivitatDirigida withId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ResponseActivitatDirigida withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public ResponseActivitatDirigida withDescripcio(String descripcio) {
        this.descripcio = descripcio;
        return this;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public ResponseActivitatDirigida withTipologia(String tipologia) {
        this.tipologia = tipologia;
        return this;
    }

    public String getIntensitat() {
        return intensitat;
    }

    public void setIntensitat(String intensitat) {
        this.intensitat = intensitat;
    }

    public ResponseActivitatDirigida withIntensitat(String intensitat) {
        this.intensitat = intensitat;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ResponseActivitatDirigida withImage(String image) {
        this.image = image;
        return this;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public ResponseActivitatDirigida withCategoryId(long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

}