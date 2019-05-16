package com.example.gimnasdual.model.FirebaseWorkout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Dia implements Serializable {

    private String data;
    private List<Exercici> exercicis;

    public Dia() {
    }

    public Dia(String data) {
        this.data = data;
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

    public void addExercicis(Exercici exercici) {
        if (this.exercicis == null) {
            this.exercicis = new ArrayList<>();
        }
        this.exercicis.add(exercici);
    }

    @Override
    public String toString() {
        return "Dia{" +
                "data='" + data + '\'' +
                ", exercicis=" + exercicis +
                '}';
    }
}