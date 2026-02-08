package org.example.model;

public class Aluno {
    private long matricula;
    private String nome;
    private String email;
    private int ano;
    private String senha;
    private String recSenha;

    // Construtores

    public Aluno(){}

    public Aluno(long matricula, String nome, String senha, String email, int ano){
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.ano = ano;
    }

    public Aluno(long matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    // Getters e Setters

    public String getEmail(){
        return email;
    }

    public String getNome(){
        return nome;
    }


    public String getMatricula(){
        return email;
    }


    public int getAno(){
        return ano;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    // To string


    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", ano=" + ano +
                ", senha='" + senha + '\'' +
                ", recSenha='" + recSenha + '\'' +
                '}';
    }
}
