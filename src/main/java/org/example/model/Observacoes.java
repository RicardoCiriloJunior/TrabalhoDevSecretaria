package org.example.model;

public class Observacoes {
    private int id_professor;
    private int id_disciplina;
    private String matricula;
    private String observacao;


    public Observacoes(){}



    public Observacoes(int id_disciplina, int id_professor, String matricula, String observacao){
        this.id_disciplina = id_disciplina;
        this.id_professor = id_professor;
        this.matricula = matricula;
        this.observacao = observacao;
    }

    // Getters

    public int getId_professor() {
        return id_professor;
    }

    public int getId_disciplina() {
        return id_disciplina;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getObservacao() {
        return observacao;
    }

    // Setters

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }

    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    // toString

    @Override
    public String toString() {
        return "Observacoes{" +
                "id_professor=" + id_professor +
                ", id_disciplina=" + id_disciplina +
                ", matricula='" + matricula + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
