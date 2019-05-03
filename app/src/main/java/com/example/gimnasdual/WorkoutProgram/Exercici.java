package com.example.gimnasdual.WorkoutProgram;

import java.util.List;

public class Exercici {

    private String nom;
    private List<Serie> series;

    public Exercici() {
    }

    public Exercici(String nom, List<Serie> series) {
        this.nom = nom;
        this.series = series;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void setSeries(List<Serie> series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Exercici{" +
                "nom='" + nom + '\'' +
                ", series=" + series +
                '}';
    }
}
