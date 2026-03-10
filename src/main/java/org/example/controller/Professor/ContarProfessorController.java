package org.example.controller.Professor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.ProfessorService;

import java.io.IOException;

@WebServlet("/professores")
public class ContarProfessorController extends HttpServlet {

    private ProfessorService professorService;

    @Override
    public void init() {
        professorService = new ProfessorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        long total = professorService.countProfessor();

        req.setAttribute("totalProfessores", total);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}