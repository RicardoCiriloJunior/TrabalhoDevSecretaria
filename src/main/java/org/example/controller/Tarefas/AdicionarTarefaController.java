package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Atividades;
import org.example.model.Disciplina;
import org.example.service.AtividadesService;
import org.example.service.DisciplinaService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
@WebServlet("/adicionar-tarefa")
public class AdicionarTarefaController extends HttpServlet {

    private final AtividadesService atividadesService = new AtividadesService ();
    private final DisciplinaService disciplinaService = new DisciplinaService ();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getAttribute ("acao").equals ("confirmar")) {

            String materia = (String) req.getAttribute ("materia");
            long materiaId = disciplinaService.encontrarDisciplina (materia).getId ();

            HttpSession session = req.getSession();
            String matricula = (String) session.getAttribute("matriculaAluno");
            String titulo = (String) req.getAttribute ("titulo");
            String descricao = (String) req.getAttribute ("descricao");
            String dataEntrega = (String) req.getAttribute ("data");
            LocalDate dataEntregaFormatada = LocalDate.parse (dataEntrega);
            LocalDate dataCriacao = LocalDate.now ();
            String urgencia = (String) req.getAttribute ("urgencia");

            Atividades atividade = new Atividades (matricula, materiaId, titulo, descricao, urgencia, dataEntregaFormatada, dataCriacao);

            atividadesService.adicionarAtividade (atividade);

            req.getRequestDispatcher("/WEB-INF/view/aluno/tarefas.jsp").forward(req, resp);
        }

    }
}
