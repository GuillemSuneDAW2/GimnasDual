package com.example.gimnasdual.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseSoci {

    @SerializedName("$id")
    @Expose
    private String $id;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("nom")
    @Expose
    private String nom;
    @SerializedName("cognoms")
    @Expose
    private String cognoms;
    @SerializedName("dni")
    @Expose
    private String dni;
    @SerializedName("correu")
    @Expose
    private String correu;
    @SerializedName("naixement")
    @Expose
    private String naixement;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseSoci() {
    }

    /**
     *
     * @param id
     * @param naixement
     * @param correu
     * @param cognoms
     * @param dni
     * @param $id
     * @param nom
     */
    public ResponseSoci(String $id, long id, String nom, String cognoms, String dni, String correu, String naixement) {
        super();
        this.$id = $id;
        this.id = id;
        this.nom = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.correu = correu;
        this.naixement = naixement;
    }

    public String get$id() {
        return $id;
    }

    public void set$id(String $id) {
        this.$id = $id;
    }

    public ResponseSoci with$id(String $id) {
        this.$id = $id;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ResponseSoci withId(long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ResponseSoci withNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public ResponseSoci withCognoms(String cognoms) {
        this.cognoms = cognoms;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ResponseSoci withDni(String dni) {
        this.dni = dni;
        return this;
    }

    public String getCorreu() {
        return correu;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public ResponseSoci withCorreu(String correu) {
        this.correu = correu;
        return this;
    }

    public String getNaixement() {
        return naixement;
    }

    public void setNaixement(String naixement) {
        this.naixement = naixement;
    }

    public ResponseSoci withNaixement(String naixement) {
        this.naixement = naixement;
        return this;
    }

}