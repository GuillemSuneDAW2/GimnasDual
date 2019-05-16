package com.example.gimnasdual.model.FirebaseWorkout;

import java.io.Serializable;

public class Serie implements Serializable {

    private int repeticions;
    private double pes;

    public Serie() {
    }

    public Serie(int repeticions, double pes) {
        this.repeticions = repeticions;
        this.pes = pes;
    }

    public int getRepeticions() {
        return repeticions;
    }

    public void setRepeticions(int repeticions) {
        this.repeticions = repeticions;
    }

    public double getPes() {
        return pes;
    }

    public void setPes(double pes) {
        this.pes = pes;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "repeticions=" + repeticions +
                ", pes=" + pes +
                '}';
    }
}