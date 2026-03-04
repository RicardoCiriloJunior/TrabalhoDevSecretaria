package org.example.controller.Observacoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Professor;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;

import java.io.IOException;

@WebServlet
public class ContarObsEnviadasController extends HttpServlet {

    private ObservacoesService observacoesService;
    private ProfessorService professorService;

    @Override
    public void init() throws ServletException {
        observacoesService = new ObservacoesService();
        professorService = new ProfessorService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nomeProfessor = (String) session.getAttribute("professorNome");

        Professor professor = professorService.encontrarProfessorPorNome(nomeProfessor);

        long id_professor = professor.getId();

        long total = observacoesService.countObsEnviadas(id_professor);

        req.setAttribute("totalObsEnviadas", total);

        req.getRequestDispatcher("/.jsp").forward(req, resp);
        }
}
