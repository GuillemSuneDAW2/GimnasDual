package com.example.gimnasdual.WorkoutProgram;

public class Serie {

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
