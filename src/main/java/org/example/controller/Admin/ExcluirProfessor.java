package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.example.service.ProfessorService;

import java.io.IOException;
@MultipartConfig
@WebServlet("/admin/excluir-professor")
public class ExcluirProfessor extends HttpServlet {

    ProfessorService professorService;

    @Override
    public void init() {
        professorService = new ProfessorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id != null && !id.isBlank()) {

            long idLong = Long.parseLong(id);

            professorService.deletarProfessor(idLong);
        }

        resp.sendRedirect(req.getContextPath() + "/admin/professores");
    }
}