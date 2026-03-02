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
public class BuscarProfessorController extends HttpServlet {
    private ProfessorService professorService;

    @Override
    public void init() {
        professorService = new ProfessorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String busca = req.getParameter("busca");
        List<Professor> professorBusca = professorService.buscarProfessor(busca);

        req.setAttribute("professores", professorBusca);
        req.getRequestDispatcher("/admin-professores.jsp").forward(req, resp);


    }
}
