package org.example.service;

import org.example.model.Administrador;
import org.example.repository.AdministradorRepository;

public class AdministradorService {

    private AdministradorRepository administradorRepository;

    public boolean entrarNaConta (Administrador adm) {
        Administrador login = administradorRepository.findByLogin(adm.getLogin(), adm.getSenha());
        return login != null;
    }
}
