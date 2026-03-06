package org.example;

import io.github.cdimascio.dotenv.Dotenv;
import org.mindrot.jbcrypt.BCrypt;

public class Main {
    public static void main(String[] args) {
       String[] senhas = {"jp123", "jm123", "ac123", "jrp123", "jj123", "bl123", "adn123", "cp123", "cg123", "anr123",
               "abr123", "amr123", "pl123", "mc123", "me123", "ml123", "ma123", "lds123", "ag123", "sb123", };
       String[] hashSenhas = new String[senhas.length];

       for (int i = 0; i < hashSenhas.length; i++) {
           hashSenhas[i] = BCrypt.hashpw(senhas[i], BCrypt.gensalt(13));
       }
       for ( String senha : hashSenhas) {
           System.out.println(senha);
       }
}}