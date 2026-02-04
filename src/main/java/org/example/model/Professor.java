package org.example.model;

public class Professor {
    private int id_disciplina;
    private String usuario;
    private String senha;
    private String nome;

    // Construtores

    public Professor(){}

    public Professor(int id_disciplina, String usuario, String senha, String nome){
        this.id_disciplina = id_disciplina;
        this.usuario = usuario;
        this.nome = nome;
        this.senha = senha;
    }

    public Professor(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }

    // Geterrs


    public int getId_disciplina() {
        return id_disciplina;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    // Setters


    public void setId_disciplina(int id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
                ", usuario='" + usuario + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
