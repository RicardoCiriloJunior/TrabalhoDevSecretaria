package org.example.model;

public class Media {

    private String matricula;
    private double media;

    public Media(String matricula, double media) {
        this.matricula = matricula;
        this.media = media;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getMedia() {
        return media;
    }
}