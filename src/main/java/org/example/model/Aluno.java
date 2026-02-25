package org.example.model;

public class Aluno {
    private String matricula;
    private String nome;
    private String email;
    private String senha;
    private String recSenha;
    private String cpf;

    // Construtores

    public Aluno(){}

    public Aluno(String matricula, String nome, String senha, String email){
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
    public Aluno(String nome, String senha, String email, String cpf, String matricula){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
        this.matricula = matricula;
    }
    public Aluno( String senha, String email){
        this.senha = senha;
        this.email = email;
    }


    // Getters e Setters

    public String getEmail(){
        return email;
    }

    public String getNome(){
        return nome;
    }

    public String getRecSenha () { return recSenha; }

    public String getSenha () { return senha; }

    public String getMatricula(){
        return matricula;
    }


    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setRecSenha(String recSenha) { this.recSenha = recSenha; }

    // To string


    @Override
    public String toString() {
        return "Aluno{" +
                "matricula='" + matricula + '\'' +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", recSenha='" + recSenha + '\'' +
                '}';
    }
}
