package org.example.controller.Observacoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Observacoes;
import org.example.model.Professor;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarObsEnviadasController extends HttpServlet {

    private ObservacoesService observacoesService;
    private ProfessorService professorService;

    //Construtor
    public ListarObsEnviadasController(ObservacoesService observacoesService, ProfessorService professorService) {
        this.observacoesService = observacoesService;
        this.professorService = professorService;
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nomeProfessor = (String) session.getAttribute("professorNome");

        Professor professor = professorService.encontrarProfessorPorNome(nomeProfessor);

        List<Observacoes> observacoesEnviadas = observacoesService.listarObsEnviadas(professor.getId());

        req.setAttribute("observacoesEnviadas", observacoesEnviadas);

        req.getRequestDispatcher("/.jsp").forward(req, resp);
    }
}
