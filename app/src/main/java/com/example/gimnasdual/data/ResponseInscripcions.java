package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseInscripcions {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("sessio_Id")
    @Expose
    private long sessioId;
    @SerializedName("soci_Id")
    @Expose
    private long sociId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseInscripcions() {
    }

    /**
     *
     * @param id
     * @param sociId
     * @param sessioId
     * @param $id
     */
    public ResponseInscripcions(String $id, long id, long sessioId, long sociId) {
        super();
        this.$id = $id;
        this.id = id;
        this.sessioId = sessioId;
        this.sociId = sociId;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseInscripcions with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseInscripcions withId(long id) {
        this.id = id;
        return this;
    }

    public long getSessioId() {
        return sessioId;
    }

    public void setSessioId(long sessioId) {
        this.sessioId = sessioId;
    }

    public ResponseInscripcions withSessioId(long sessioId) {
        this.sessioId = sessioId;
        return this;
    }

    public long getSociId() {
        return sociId;
    }

    public void setSociId(long sociId) {
        this.sociId = sociId;
    }

    public ResponseInscripcions withSociId(long sociId) {
        this.sociId = sociId;
        return this;
    }

}