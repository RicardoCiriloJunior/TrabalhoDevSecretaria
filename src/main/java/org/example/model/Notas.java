package org.example.model;

public class Notas {
    private long id;
    private long id_disciplina;
    private String matricula;
    private double nota;
    private double nota2;
    
    // Construtores
    
    public Notas(){}

    public Notas(long id) {
        this.id = id;
    }

    public Notas(long id_disciplina, String matricula, double nota) {
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.nota = nota;
    }
    public Notas(long id,long id_disciplina, String matricula,double nota, double nota2) {
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.nota = nota;
        this.nota2 = nota2;
        this.id = id;
    }
    public Notas(double nota, double nota2, String matricula, long id_disciplina) {
        this.nota = nota;
        this.nota2 = nota2;
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

    public double getNota() {
        return nota;
    }

    public double getNota2() {
        return nota2;
    }
    // Setters


    public void setId(long id) {
        this.id = id;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }
    // To string


    @Override
    public String toString() {
        return "Notas{" +
                "id_disciplina=" + id_disciplina +
                ", matricula='" + matricula + '\'' +
                ", nota=" + nota + '\'' +
                ", nota2=" + nota2 +
                '}';
    }
}
