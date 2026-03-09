package org.example.controller.Professor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Professor;
import org.example.model.Observacoes;
import org.example.service.NotasService;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;
import org.example.service.AlunoService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/professor/inicio")
public class InicioProfessorController extends HttpServlet {

    private ObservacoesService observacoesService;
    private ProfessorService professorService;
    private AlunoService alunoService;
    private NotasService notasService;

    @Override
    public void init() throws ServletException {
        notasService = new NotasService();
        observacoesService = new ObservacoesService();
        professorService = new ProfessorService();
        alunoService = new AlunoService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();
        String nomeProfessor = (String) session.getAttribute("professorNome");
        Professor professor = professorService.encontrarProfessorPorNome(nomeProfessor);

        long id_professor = professor.getId();
        long id_disciplina = professor.getId_disciplina();
        long totalObsEnviadas = observacoesService.countObsEnviadas(id_professor);

        long totalAlunos = alunoService.countAluno();
        double mediaGeral  = notasService.mediaGeral(id_disciplina);
        long totalRecuperacoes  = notasService.countRecuperacoes(id_disciplina);
        List<Observacoes> observacoes = observacoesService.listarObsEnviadas(id_professor);

        Map<String, String> nomesAlunos = new HashMap<>();
        for (Observacoes obs : observacoes) {
            String nome = alunoService.findByMatricula(obs.getMatricula()).getNome();
            nomesAlunos.put(obs.getMatricula(), nome);
        }

        req.setAttribute("nomeProfessor",professor.getNome());
        req.setAttribute("totalObsEnviadas",totalObsEnviadas);
        req.setAttribute("nomesAlunos", nomesAlunos);
        session.setAttribute("totalAlunos",totalAlunos);
        req.setAttribute("mediaGeral",mediaGeral);
        req.setAttribute("totalRecuperacoes",totalRecuperacoes);
        req.setAttribute("observacoes",observacoes);

        req.getRequestDispatcher("/WEB-INF/view/professor/inicio.jsp").forward(req, resp);
    }
}