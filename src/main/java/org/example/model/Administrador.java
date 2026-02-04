package org.example.model;

public class Administrador {
    private String login;
    private String senha;

    // Construtores

    public Administrador(){}

    public Administrador(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // To string

    @Override
    public String toString() {
        return "Administrador{" +
                "login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
