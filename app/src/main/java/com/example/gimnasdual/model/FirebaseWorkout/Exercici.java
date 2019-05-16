package com.example.gimnasdual.model.FirebaseWorkout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Exercici implements Serializable {

    private String nom;
    private List<Serie> series;

    public Exercici() {
    }

    public Exercici(String nom) {
        this.nom = nom;
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

    public void addSeries(Serie serie) {
        if (this.series == null) {
            this.series = new ArrayList<>();
        }
        this.series.add(serie);
    }

    @Override
    public String toString() {
        return "Exercici{" +
                "nom='" + nom + '\'' +
                ", series=" + series +
                '}';
    }
}