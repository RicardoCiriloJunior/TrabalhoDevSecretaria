package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirecionar")
public class Redirect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        Object matriculaAlunoObject = session.getAttribute("matriculaAluno");
        Object professorNomeObject = session.getAttribute("professorNome");
        Object emailAdmin = session.getAttribute("emailAdmin");

        if (matriculaAlunoObject == null && professorNomeObject == null && emailAdmin == null) {
            System.out.println("Aluno e professor não logados");
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        String page = req.getParameter("page");

        if (page == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }


        switch (page) {
            case "inicioAluno" -> redirecionar("WEB-INF/view/aluno/inicio.jsp", req, resp);
            case "tarefasAluno" -> redirecionar("WEB-INF/view/aluno/tarefas.jsp", req, resp);
            case "materiasAluno" -> redirecionar("WEB-INF/view/atividades/menu-atividades.jsp", req, resp);
            case "expressividadeAtividade" -> redirecionar("WEB-INF/view/atividades/expressividade-vocal.jsp", req, resp);
            case "engenhariaAtividade" -> redirecionar("WEB-INF/view/atividades/engenharia-sustos.jsp", req, resp);
            case "psicologiaAtividade" -> redirecionar("WEB-INF/view/atividades/psicologia-medo.jsp", req, resp);
            case "tecnologiaAtividade" -> redirecionar("WEB-INF/view/atividades/quebra-cabeca.jsp", req, resp);
            case "inicioProfessor" -> redirecionar("WEB-INF/view/professor/inicio.jsp", req, resp);
            case "enviarObsProfessor" -> redirecionar("/WEB-INF/view/professor/enviarObs.jsp", req, resp);
            case "lancarNotasProfessor" -> redirecionar("/WEB-INF/view/professor/lancarNotas.jsp", req, resp);
            case "addProfessorAdmin" -> redirecionar("/WEB-INF/view/administrador/addProfessor.jsp", req, resp);
            case "addAlunoAdmin" -> redirecionar("/WEB-INF/view/administrador/addAluno.jsp", req, resp);
            case "visualizarObs" -> redirecionar("WEB-INF/view/aluno/visualizarObs.jsp", req, resp);
        }
    }
    public static void redirecionar(String path, HttpServletRequest req, HttpServletResponse resp ) throws IOException, ServletException{
           req.getRequestDispatcher(path).forward(req, resp);
    }

}
