package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.example.service.AlunoService;

import java.io.IOException;

@WebServlet("/admin/excluir-aluno")
public class ExcluirAlunoController extends HttpServlet {

    AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String matricula = req.getParameter("matricula");

        if(matricula != null && !matricula.isBlank()){
            alunoService.deletarAluno(matricula);
        }

        resp.sendRedirect(req.getContextPath() + "/admin/alunos");
    }
}