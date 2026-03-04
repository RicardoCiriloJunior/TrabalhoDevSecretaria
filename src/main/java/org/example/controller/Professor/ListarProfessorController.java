package org.example.controller.Professor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Professor;
import org.example.service.ProfessorService;
import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarProfessorController extends HttpServlet {
    private ProfessorService professorService;

    @Override
    public void init() {
        professorService = new ProfessorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Professor> professor = professorService.listarTodos();

        req.setAttribute("professores", professor);

        req.getRequestDispatcher("/admin-professores.jsp").forward(req, resp);
    }

}
