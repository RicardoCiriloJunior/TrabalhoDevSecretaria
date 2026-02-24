package org.example.controller.Login;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Administrador;
import org.example.service.AdministradorService;

@WebServlet(name = "...", urlPatterns = {"/..."})
public class LoginAdministradorController extends HttpServlet {

    private final AdministradorService administradorService;

    //Construtor
    public LoginAdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        Administrador adm = new Administrador(nome, senha);

        try{
            administradorService.entrarNaConta(adm);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

