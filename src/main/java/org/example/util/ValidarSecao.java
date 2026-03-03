package org.example.util;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class ValidarSecao {
    public static void validarUsuarioLogado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Object matricula = session.getAttribute("matriculaAluno");
        if (matricula == null || matricula.equals("")) {
            req.getRequestDispatcher(req.getContextPath()).forward(req, resp);
        };
    }
    public static void validarProfessorLogado(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Object matricula = session.getAttribute("idProfesor");
        if (matricula == null || matricula.equals("")) {
            req.getRequestDispatcher(req.getContextPath()).forward(req, resp);
        };
    }
}
