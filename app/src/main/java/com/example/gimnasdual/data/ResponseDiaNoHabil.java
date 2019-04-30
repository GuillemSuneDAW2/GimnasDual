package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDiaNoHabil {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("data")
    @Expose
    private String data;
    @SerializedName("motiu")
    @Expose
    private String motiu;
    @SerializedName("horari")
    @Expose
    private String horari;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseDiaNoHabil() {
    }

    /**
     *
     * @param id
     * @param data
     * @param horari
     * @param $id
     * @param motiu
     */
    public ResponseDiaNoHabil(String $id, long id, String data, String motiu, String horari) {
        super();
        this.$id = $id;
        this.id = id;
        this.data = data;
        this.motiu = motiu;
        this.horari = horari;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseDiaNoHabil with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseDiaNoHabil withId(long id) {
        this.id = id;
        return this;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ResponseDiaNoHabil withData(String data) {
        this.data = data;
        return this;
    }

    public String getMotiu() {
        return motiu;
    }

    public void setMotiu(String motiu) {
        this.motiu = motiu;
    }

    public ResponseDiaNoHabil withMotiu(String motiu) {
        this.motiu = motiu;
        return this;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public ResponseDiaNoHabil withHorari(String horari) {
        this.horari = horari;
        return this;
    }

}