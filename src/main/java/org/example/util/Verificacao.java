package org.example.util;

import java.util.regex.Pattern;

public class Verificacao {

    public Verificacao(){};


    public static boolean validarCpf(String cpf){
        if (cpf == null) return false;
        String numeros = cpf.replace(".", "").replace("-", "");
        if (numeros.length() != 11 || numeros.matches("(\\d)\\1{10}")) return false;
        return true;
    }
    public static boolean validarEmail(String email) {
        boolean formatoValido = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        return formatoValido && !email.endsWith("@monstrossa.com");
    }
    public static boolean validarSenha(String senha){
        if (senha == null) return false;
        String regex = "^(?=.*\\d).{8,}$";
        return Pattern.matches(regex, senha);
    }

}
