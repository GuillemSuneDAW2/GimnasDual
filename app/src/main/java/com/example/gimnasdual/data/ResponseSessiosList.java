package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseSessiosList {
    @SerializedName("lista")
    @Expose
    private List<ResponseSessios> listaSessio = null;

    public ResponseSessiosList(List<ResponseSessios> listaSessio) {
        this.listaSessio = listaSessio;
    }

    public List<ResponseSessios> getListaSessio() {
        return listaSessio;
    }

    public void setListaSessio(List<ResponseSessios> listaSessio) {
        this.listaSessio = listaSessio;
    }
}
