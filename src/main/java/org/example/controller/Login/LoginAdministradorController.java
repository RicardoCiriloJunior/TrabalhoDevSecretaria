package org.example.controller.Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Administrador;
import org.example.service.AdministradorService;

import java.io.IOException;

@WebServlet(name = "admLogin", urlPatterns = {"/admLogin"})
public class LoginAdministradorController extends HttpServlet {

    private  AdministradorService administradorService;

    @Override
    public void init() throws ServletException {
        administradorService = new AdministradorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        if(nome.isEmpty() || nome == null || senha.isEmpty() || senha == null){
            req.setAttribute("erroLogin", "Credenciais inválidas!");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }

        Administrador adm = new Administrador(nome, senha);

        try{
            administradorService.entrarNaConta(adm);
            resp.sendRedirect(req.getContextPath() + "");


        }catch (Exception e){
            req.setAttribute("erroLogin", "Credenciais inválidas!");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}

