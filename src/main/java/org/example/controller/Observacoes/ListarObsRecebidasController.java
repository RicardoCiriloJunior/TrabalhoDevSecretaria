package org.example.controller.Observacoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Disciplina;
import org.example.model.Observacoes;
import org.example.model.Professor;
import org.example.service.DisciplinaService;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/aluno/visualizarObs")
public class ListarObsRecebidasController extends HttpServlet {

    private ObservacoesService observacoesService;
    private ProfessorService professorService;
    private DisciplinaService disciplinaService;

    @Override
    public void init() throws ServletException {
        observacoesService = new ObservacoesService();
        professorService = new ProfessorService();
        disciplinaService = new DisciplinaService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("matriculaAluno") == null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }

        String matricula = (String) session.getAttribute("matriculaAluno");

        List<Observacoes> observacoesRecebidas = observacoesService.listarObsRecebidas(matricula);


        Map<Long, String> nomesProfessores = new HashMap<>();

        Map<Long, String> nomesDisciplinas = new HashMap<>();

        for (Observacoes obs : observacoesRecebidas) {
            long idProf = obs.getId_professor();
            long idDisc = obs.getId_disciplina();

            if (!nomesProfessores.containsKey(idProf)) {
                Professor prof = professorService.encontrarProfessorPorId(idProf);
                nomesProfessores.put(idProf, prof != null ? prof.getNome() : "Professor não encontrado!");
            }

            if (!nomesDisciplinas.containsKey(idDisc)) {
                Disciplina disc = disciplinaService.encontarDiscPorId(idDisc);
                nomesDisciplinas.put(idDisc, disc != null ? disc.getDisciplina() : "Disciplina não encontrada!");
            }
        }

        req.setAttribute("observacoesRecebidas", observacoesRecebidas);
        req.setAttribute("nomesProfessores", nomesProfessores);
        req.setAttribute("nomesDisciplinas", nomesDisciplinas);

        req.getRequestDispatcher("/WEB-INF/view/aluno/visualizarObs.jsp").forward(req, resp);
    }
}