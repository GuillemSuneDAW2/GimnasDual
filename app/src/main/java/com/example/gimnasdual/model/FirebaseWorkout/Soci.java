package com.example.gimnasdual.model.FirebaseWorkout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Soci implements Serializable {

    private String nom;
    private List<Dia> dies;

    public Soci() {
    }

    public Soci(String nom) {
        this.nom = nom;
    }

    public Soci(String nom, List<Dia> dies) {
        this.nom = nom;
        this.dies = dies;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Dia> getDies() {
        return dies;
    }

    public void setDies(List<Dia> dies) {
        this.dies = dies;
    }

    public void afegirDies(Dia dia) {
        if (this.dies == null){
            this.dies = new ArrayList<>();
        }
        this.dies.add(dia);
    }

    @Override
    public String toString() {
        return "Soci{" +
                "nom='" + nom + '\'' +
                ", dies=" + dies +
                '}';
    }
}