package org.example.model;

public class Aluno {
    private long matricula;
    private String nome;
    private String email;
    private String senha;
    private String recSenha;

    private long cpf;

    // Construtores

    public Aluno(){}

    public Aluno(long matricula, String nome, String senha, String email, long cpf){
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.cpf = cpf;
    }
    public Aluno( String senha, String email){
        this.senha = senha;
        this.email = email;
    }

    public Aluno(long matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
    }

    // Getters e Setters

    public String getEmail(){
        return this.email;
    }

    public String getNome(){
        return this.nome;
    }

    public String getRecSenha () { return this.recSenha; }

    public String getSenha () { return this.senha; }

    public String getMatricula(){
        return this.email;
    }

    public long getCpf(){
        return this.cpf;
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
                ", cpf=" + cpf +
                ", senha='" + senha + '\'' +
                ", recSenha='" + recSenha + '\'' +
                '}';
    }
}
