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
            case "inicioAluno" -> redirecionar("/WEB-INF/view/aluno/inicio.jsp", req, resp);
            case "boletimAluno" -> redirecionar("WEB-INF/view/aluno/boletim.jsp", req, resp);
            case "tarefasAluno" -> redirecionar("WEB-INF/view/aluno/tarefas.jsp", req, resp);
            case "materiasAluno" -> redirecionar("WEB-INF/view/atividades/menu-atividades.jsp", req, resp);
            case "expressividadeAtividade" -> redirecionar("WEB-INF/view/atividades/expressividade-vocal.jsp", req, resp);
            case "engenhariaAtividade" -> redirecionar("WEB-INF/view/atividades/engenharia-sustos.jsp", req, resp);
            case "psicologiaAtividade" -> redirecionar("WEB-INF/view/atividades/psicologia-medo.jsp", req, resp);
        }
    }
    public static void redirecionar(String path, HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException{
           req.getRequestDispatcher(path).forward(req, resp);
    }
}
