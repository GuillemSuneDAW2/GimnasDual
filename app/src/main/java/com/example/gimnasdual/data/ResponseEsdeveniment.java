package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseEsdeveniment {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("titol")
    @Expose
    private String titol;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("descripcio")
    @Expose
    private String descripcio;
    @SerializedName("lloc")
    @Expose
    private String lloc;
    @SerializedName("tipus")
    @Expose
    private String tipus;
    @SerializedName("image")
    @Expose
    private String image;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseEsdeveniment() {
    }

    /**
     *
     * @param id
     * @param descripcio
     * @param data
     * @param image
     * @param titol
     * @param lloc
     * @param $id
     * @param tipus
     */
    public ResponseEsdeveniment(String $id, long id, String titol, String data, String descripcio, String lloc, String tipus, String image) {
        super();
        this.$id = $id;
        this.id = id;
        this.titol = titol;
        this.data = data;
        this.descripcio = descripcio;
        this.lloc = lloc;
        this.tipus = tipus;
        this.image = image;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseEsdeveniment with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseEsdeveniment withId(long id) {
        this.id = id;
        return this;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public ResponseEsdeveniment withTitol(String titol) {
        this.titol = titol;
        return this;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ResponseEsdeveniment withData(String data) {
        this.data = data;
        return this;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public ResponseEsdeveniment withDescripcio(String descripcio) {
        this.descripcio = descripcio;
        return this;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }

    public ResponseEsdeveniment withLloc(String lloc) {
        this.lloc = lloc;
        return this;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public ResponseEsdeveniment withTipus(String tipus) {
        this.tipus = tipus;
        return this;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ResponseEsdeveniment withImage(String image) {
        this.image = image;
        return this;
    }

}