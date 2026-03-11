package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.service.AtividadesService;

import java.io.IOException;

@WebServlet("/excluir-tarefa")
public class ExcluirTarefaController extends HttpServlet {
    private final AtividadesService atividadesService = new AtividadesService ();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Object matriculaObj = session.getAttribute("matriculaAluno");
        if (session == null || matriculaObj == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        String idAtividade = req.getParameter("idAtividade");
        if (idAtividade == null || idAtividade.isBlank()) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        long id = Long.parseLong(idAtividade);

        atividadesService.deletarAtividade(id);


        resp.sendRedirect(req.getContextPath() + "/aluno/exibir-tarefas");
    }
}
