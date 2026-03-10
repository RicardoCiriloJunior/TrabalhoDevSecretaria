package org.example.controller.Observacoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.model.Observacoes;
import org.example.model.Professor;
import org.example.service.AlunoService;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;

import java.io.IOException;

@WebServlet(name="enviarObs", urlPatterns = {"/enviarObs"})
public class EnviarObservacoesController extends HttpServlet {

    private ObservacoesService observacoesService;

    private AlunoService alunoService;

    private ProfessorService professorService;


    @Override
    public void init() throws ServletException {
        observacoesService = new ObservacoesService();
        alunoService = new AlunoService();
        professorService = new ProfessorService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String observacao = req.getParameter("observacao");

        String nomeProfessor = (String) req.getSession().getAttribute("professorNome");

        Professor prof = professorService.encontrarProfessorPorNome(nomeProfessor);

        long id_prof = prof.getId();
        long idDisciplina = prof.getId_disciplina();

        Aluno aluno = alunoService.encontrarAlunoPorNome(nome);

        if (aluno == null){
            req.setAttribute("erroObs","Erro! o nome digitado não foi encontrado!");
            req.getRequestDispatcher("/WEB-INF/view/professor/enviarObs.jsp").forward(req, resp);
            return;
        }
        String matricula = aluno.getMatricula();

        Observacoes obs = new Observacoes(id_prof, idDisciplina, matricula, observacao);

        try {
            observacoesService.adicionarObservacao(obs);
            resp.sendRedirect(req.getContextPath() + "/professor/inicio");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
