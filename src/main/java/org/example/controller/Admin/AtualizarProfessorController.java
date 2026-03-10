package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Professor;
import org.example.service.ProfessorService;

import java.io.IOException;
@MultipartConfig
@WebServlet("/admin/atualizar-professor")
public class AtualizarProfessorController extends HttpServlet {
    ProfessorService professorService;

    @Override
    public void init() throws ServletException {
        this.professorService = new ProfessorService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String idDisciplina = req.getParameter("id_disciplina");

        if (id == null || nome == null || email == null || idDisciplina == null ||
                id.isBlank() || nome.isBlank() || email.isBlank() || idDisciplina.isBlank()) {

            resp.setStatus(400);
            return;
        }

        long idLong = Long.parseLong(id);
        long disciplinaLong = Long.parseLong(idDisciplina);

        Professor professor = professorService.encontrarProfessorPorId(idLong);

        if (professor == null) {
            resp.setStatus(404);
            return;
        }

        professor.setNome(nome);
        professor.setEmail(email);
        professor.setId_disciplina(disciplinaLong);

        boolean atualizado = professorService.alterarProfessor(professor);

        if (!atualizado) {
            resp.setStatus(500);
            return;
        }

        resp.setStatus(200);
    }
}
