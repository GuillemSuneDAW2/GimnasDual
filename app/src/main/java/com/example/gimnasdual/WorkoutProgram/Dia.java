package com.example.gimnasdual.WorkoutProgram;

import java.util.List;

public class Dia {

    private String data;
    private List<Exercici> exercicis;

    public Dia() {
    }

    public Dia(String data, List<Exercici> exercicis) {
        this.data = data;
        this.exercicis = exercicis;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Exercici> getExercicis() {
        return exercicis;
    }

    public void setExercicis(List<Exercici> exercicis) {
        this.exercicis = exercicis;
    }

    @Override
    public String toString() {
        return "Dia{" +
                "data='" + data + '\'' +
                ", exercicis=" + exercicis +
                '}';
    }
}
