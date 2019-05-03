package com.example.gimnasdual.WorkoutProgram;

import java.util.List;

public class Soci {

    private String nom;
    private List<Dia> dies;

    public Soci() {
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

    @Override
    public String toString() {
        return "Soci{" +
                "nom='" + nom + '\'' +
                ", dies=" + dies +
                '}';
    }
}
