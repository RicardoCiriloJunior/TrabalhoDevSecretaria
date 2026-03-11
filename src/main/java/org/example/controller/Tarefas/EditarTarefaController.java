package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Atividades;
import org.example.service.AtividadesService;

import java.io.IOException;
import java.time.LocalDate;
@WebServlet("/editar-tarefa")
public class EditarTarefaController extends HttpServlet {

    private final AtividadesService atividadesService = new AtividadesService ();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String status = (String) req.getAttribute ("novoStatus");
        String id = req.getParameter ("idAtividade");

        long idAtividade = Long.parseLong (id);

        Atividades atividade =   atividadesService.listarAtividadePorId (idAtividade);

        atividade.setStatus (status);

        atividadesService.atualizarAtividade (atividade);

        req.getRequestDispatcher("/WEB-INF/view/aluno/tarefas.jsp").forward(req, resp);
    }
}
