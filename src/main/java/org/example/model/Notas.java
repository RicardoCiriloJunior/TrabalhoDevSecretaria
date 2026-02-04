package org.example.model;

public class Notas {
    private int id_disciplina;
    private String matricula;
    private int ano;
    private double nota;
    
    // Construtores
    
    public Notas(){}
    public Notas(int id_disciplina, String matricula, int ano, double nota) {
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.ano = ano;
        this.nota = nota;
    }
    
    // Getters


    public int getId_disciplina() {
        return id_disciplina;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getAno() {
        return ano;
    }

    public double getNota() {
        return nota;
    }
    
    // Setters


    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setMatriculas(String matricula) {
        this.matricula = matricula;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // To string


    @Override
    public String toString() {
        return "Notas{" +
                "id_disciplina=" + id_disciplina +
                ", matricula='" + matricula + '\'' +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}
