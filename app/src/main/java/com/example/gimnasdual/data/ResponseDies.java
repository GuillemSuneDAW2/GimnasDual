package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDies {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("dia")
    @Expose
    private String dia;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseDies() {
    }

    /**
     *
     * @param id
     * @param dia
     * @param $id
     */
    public ResponseDies(String $id, long id, String dia) {
        super();
        this.$id = $id;
        this.id = id;
        this.dia = dia;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseDies with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseDies withId(long id) {
        this.id = id;
        return this;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public ResponseDies withDia(String dia) {
        this.dia = dia;
        return this;
    }

}