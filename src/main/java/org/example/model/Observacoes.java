package org.example.model;

public class Observacoes {
    private long id;
    private long id_professor;
    private long id_disciplina;
    private String matricula;
    private String observacao;


    public Observacoes(){}

    public Observacoes(long id, long id_professor, long id_disciplina, String matricula, String observacao) {
        this.id = id;
        this.id_professor = id_professor;
        this.id_disciplina = id_disciplina;
        this.matricula = matricula;
        this.observacao = observacao;
    }

    public Observacoes(long id) {
        this.id = id;
    }

    public Observacoes(long id_disciplina, long id_professor, String matricula, String observacao){
        this.id_disciplina = id_disciplina;
        this.id_professor = id_professor;
        this.matricula = matricula;
        this.observacao = observacao;
    }

    // Getters


    public long getId() {
        return id;
    }

    public long getId_professor() {
        return id_professor;
    }

    public long getId_disciplina() {
        return id_disciplina;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getObservacao() {
        return observacao;
    }

    // Setters


    public void setId(long id) {
        this.id = id;
    }

    public void setId_professor(long id_professor) {
        this.id_professor = id_professor;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
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
