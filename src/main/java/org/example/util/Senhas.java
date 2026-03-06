package org.example.util;

import org.mindrot.jbcrypt.BCrypt;

public class Senhas {
    public static String gerarHash(String senha) {
        if (senha == null || senha.isBlank()) return null;
        return BCrypt.hashpw(senha, BCrypt.gensalt(13));
    }

    public static boolean verificar(String senhaNormal, String hash) {
        if (senhaNormal == null || hash == null) return false;

        return BCrypt.checkpw(senhaNormal, hash);
    }
}
