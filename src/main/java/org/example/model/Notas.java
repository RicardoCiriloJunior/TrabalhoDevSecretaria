package org.example.model;

public class Notas {
    private long id;
    private long id_disciplina;
    private String matricula;
    private int ano;
    private double nota;
    
    // Construtores
    
    public Notas(){}

    public Notas(long id) {
        this.id = id;
    }

    public Notas(long id_disciplina, String matricula, int ano, double nota) {
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.ano = ano;
        this.nota = nota;
    }
    public Notas(long id,long id_disciplina, String matricula, int ano, double nota) {
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.ano = ano;
        this.nota = nota;
        this.id = id;
    }
    public Notas(double nota, String matricula, long id_disciplina) {
        this.nota = nota;
        this.matricula = matricula;
        this.id_disciplina = id_disciplina;
    }
    
    // Getters


    public long getId() {
        return id;
    }

    public long getId_disciplina() {
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


    public void setId(long id) {
        this.id = id;
    }

    public void setId_disciplina(long id_disciplina) {
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
