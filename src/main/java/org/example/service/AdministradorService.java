package org.example.service;

import org.example.model.Administrador;
import org.example.repository.AdministradorRepository;
import org.example.util.ConnectionFactory;

public class AdministradorService {

    private ConnectionFactory connection = new ConnectionFactory ();

    private AdministradorRepository administradorRepository = new AdministradorRepository(connection);

    public boolean entrarNaConta (Administrador adm){
        Administrador login = administradorRepository.findByLogin(adm.getLogin(), adm.getSenha());
        return login != null;
    }
}
