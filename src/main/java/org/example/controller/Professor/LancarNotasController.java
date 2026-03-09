package org.example.controller.Professor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Aluno;
import org.example.model.Notas;
import org.example.service.AlunoService;
import org.example.service.NotasService;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/professor/lancarNotas")
public class LancarNotasController extends HttpServlet {

    private AlunoService alunoService;
    private NotasService notasService;

    @Override
    public void init() {
        alunoService = new AlunoService();
        notasService = new NotasService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();

        long id_discplina = (long) session.getAttribute("idDisciplina");

        int total = alunoService.countAluno();

        List<Aluno> alunosList = alunoService.listarTodos();

        Map<String, Notas> notasAlunos = new HashMap<>();
        for (Aluno aluno : alunosList) {
            Notas todasNotas = notasService.encontrarPoridDisciplinaMatricula(aluno.getMatricula(), id_discplina);
            if (todasNotas != null) {
                notasAlunos.put(aluno.getMatricula(), todasNotas);
            }
        }

        req.setAttribute("alunoList", alunosList);
        req.setAttribute("notasAlunos", notasAlunos);
        session.setAttribute("totalAlunos", total);
        req.getRequestDispatcher("/WEB-INF/view/professor/lancarNotas.jsp").forward(req, resp);
    }
}