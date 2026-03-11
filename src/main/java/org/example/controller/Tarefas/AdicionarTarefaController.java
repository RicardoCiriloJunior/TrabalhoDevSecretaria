package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
@MultipartConfig
@WebServlet("/adicionar-tarefa")
public class AdicionarTarefaController extends HttpServlet {

    private final AtividadesService atividadesService = new AtividadesService ();
    private final DisciplinaService disciplinaService = new DisciplinaService ();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chegou requisição");
        if (req.getParameter ("acao").equals ("confirmar")) {
            System.out.println("entrou aqui");

            long materiaId = Long.parseLong(req.getParameter("materia"));
            HttpSession session = req.getSession();
            String matricula = (String) session.getAttribute("matriculaAluno");
            String titulo = req.getParameter ("titulo");
            String descricao = req.getParameter ("descricao");
            String dataEntrega = req.getParameter ("data");
            LocalDate dataEntregaFormatada = LocalDate.parse (dataEntrega);
            LocalDate dataCriacao = LocalDate.now ();
            String status = req.getParameter ("status");

            Atividades atividade = new Atividades (matricula, materiaId, titulo, descricao, status, dataEntregaFormatada, dataCriacao);
            System.out.println(atividade);
            atividadesService.adicionarAtividade (atividade);

            resp.sendRedirect(req.getContextPath() + "/aluno/exibir-tarefas");
        }

    }
}
