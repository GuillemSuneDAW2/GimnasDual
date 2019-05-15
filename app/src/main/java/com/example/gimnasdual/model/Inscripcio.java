package com.example.gimnasdual.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Inscripcio {

    @SerializedName("Soci_Id")
    @Expose
    private int idSoci;

    @SerializedName("Sessio_Id")
    @Expose
    private int idSessio;

    public Inscripcio() {

    }

    public Inscripcio(int idSoci, int idSessio) {
        this.idSoci = idSoci;
        this.idSessio = idSessio;
    }

    public int getIdSoci() {
        return idSoci;
    }

    public void setIdSoci(int idSoci) {
        this.idSoci = idSoci;
    }

    public int getIdSessio() {
        return idSessio;
    }

    public void setIdSessio(int idSessio) {
        this.idSessio = idSessio;
    }
}
