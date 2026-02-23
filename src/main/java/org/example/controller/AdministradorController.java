package org.example.controller;

import org.example.service.AdministradorService;
import org.example.model.Administrador;

public class AdministradorController {

    private AdministradorService administradorService;

    //Construtor
    public AdministradorController(AdministradorService administradorService){
        this.administradorService = administradorService;
    }

    //Métodos

    public boolean entrarNaConta(Administrador adm){
        return administradorService.entrarNaConta(adm);
    }




}

