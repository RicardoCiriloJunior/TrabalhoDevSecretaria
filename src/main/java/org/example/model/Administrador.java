package org.example.model;

public class Administrador {
    private long id;
    private String login;
    private String senha;

    // Construtores

   

    public Administrador(long id) {
        this.id = id;
    }

    public Administrador(long id, String login, String senha){
        this.id = id;
        this.login = login;
        this.senha = senha;
    }

    public Administrador(String login, String senha){
        this.login = login;
        this.senha = senha;
    }

    // Getters e Setters


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
