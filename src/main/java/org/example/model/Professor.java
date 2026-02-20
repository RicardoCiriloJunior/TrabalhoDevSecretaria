package org.example.model;

public class Professor {
    private long id;
    private long id_disciplina;
    private String email;
    private String senha;
    private String nome;

    // Construtores

    public Professor(){}

    public Professor(long id) {
        this.id = id;
    }

    public Professor(long id_disciplina, String email, String senha, String nome){
        this.id_disciplina = id_disciplina;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public Professor(long id, long id_disciplina, String email, String nome, String senha) {
        this.id = id;
        this.id_disciplina = id_disciplina;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public Professor(String email, String senha){
        this.email = email;
        this.senha = senha;
    }

    // Geterrs


    public long getId() {
        return id;
    }

    public long getId_disciplina() {
        return id_disciplina;
    }

    public String getEmail () {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    // Setters


    public void setId(long id) {
        this.id = id;
    }

    public void setId_disciplina(long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // To string

    @Override
    public String toString() {
        return "Professor{" +
                "id_disciplina=" + id_disciplina +
                ", usuario='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
