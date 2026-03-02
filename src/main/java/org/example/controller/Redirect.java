package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/redirecionar")
public class Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");

        switch (page) {
            case "inicioAluno" -> req.getRequestDispatcher("/WEB-INF/view/aluno/inicio.jsp").forward(req, resp);
            case "boletimAluno" -> req.getRequestDispatcher("WEB-INF/view/aluno/boletim.jsp").forward(req, resp);
            case "tarefasAluno" -> req.getRequestDispatcher("WEB-INF/view/aluno/tarefas.jsp").forward(req, resp);
            case "materiasAluno" -> req.getRequestDispatcher("WEB-INF/view/atividades/menu-atividades.jsp").forward(req, resp);
        }
    }
}
