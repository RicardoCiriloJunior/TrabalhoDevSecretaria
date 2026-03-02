package org.example.model;

public class Professor {
    private long id;
    private long id_disciplina;
    private long cpf;
    private String email;
    private String senha;
    private String nome;

    // Construtores

    public Professor(){}

    public Professor(long id) {
        this.id = id;
    }

    public Professor(long id_disciplina, String email, String senha, String nome, long cpf){
        this.id_disciplina = id_disciplina;
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Professor(long id, long id_disciplina, String email, String nome, String senha, long cpf) {
        this.id = id;
        this.id_disciplina = id_disciplina;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.cpf = cpf;
    }

    public Professor(String email, String senha, long cpf){
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
    }

    public Professor(String nome,String senha, String email, long cpf){
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.nome = nome;

    }

    // Geterrs

    public long getId() {
        return this.id;
    }

    public long getId_disciplina() {
        return this.id_disciplina;
    }

    public String getEmail () {
        return this.email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getNome() {
        return this.nome;
    }

    public long getCpf() { return this.cpf; }

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
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
