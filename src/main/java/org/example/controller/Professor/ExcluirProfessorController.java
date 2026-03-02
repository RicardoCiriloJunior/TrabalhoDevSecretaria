package org.example.controller.Professor;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.ProfessorService;

import java.io.IOException;

@WebServlet
public class ExcluirProfessorController extends HttpServlet {
    private ProfessorService professorService;

    @Override
    public void init() {
        professorService = new ProfessorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // input hidden do id de professor

        long idProfessor = Long.parseLong(req.getParameter("idProfessor"));

        professorService.deletarProfessor(idProfessor);

    }
}
