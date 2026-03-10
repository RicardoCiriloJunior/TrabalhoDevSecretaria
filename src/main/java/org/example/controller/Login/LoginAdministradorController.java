package org.example.controller.Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        HttpSession session = req.getSession();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            req.setAttribute("erroLogin", "Credenciais inválidas!");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        Administrador adm = new Administrador(email, senha);

        try {
            administradorService.entrarNaConta(adm);
            session.setAttribute("emailAdmin", email);
            resp.sendRedirect(req.getContextPath() + "/admin/professores");
        } catch (Exception e) {
            req.setAttribute("erroLogin", "Credenciais inválidas!");
            resp.sendRedirect(req.getContextPath() + "/");
            e.printStackTrace();
        }
    }}