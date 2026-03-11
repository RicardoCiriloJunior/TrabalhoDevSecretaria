package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.AtividadesService;

import java.io.IOException;

@WebServlet("/excluir-tarefa")
public class ExcluirTarefaController extends HttpServlet {
    private final AtividadesService atividadesService = new AtividadesService ();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getAttribute ("acao").equals ("confirmar")){
            String idAtividade = req.getParameter ("idAtividade");
            long id = Long.parseLong (idAtividade);

            atividadesService.deletarAtividade (id);
        }

        

        req.getRequestDispatcher("/WEB-INF/view/aluno/tarefas.jsp").forward(req, resp);
    }
}
