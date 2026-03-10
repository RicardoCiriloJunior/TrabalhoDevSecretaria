package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import org.example.model.Aluno;
import org.example.service.AlunoService;

import java.io.IOException;

@MultipartConfig
@WebServlet("/admin/atualizar-aluno")
public class AtualizarAlunoController extends HttpServlet {

    AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String matricula = req.getParameter("matricula");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");

        if(matricula == null || nome == null || email == null){
            resp.sendRedirect(req.getContextPath()+"/admin/alunos");
            return;
        }

        Aluno aluno = alunoService.encontrarAlunoPorMatricula(matricula);

        aluno.setNome(nome);
        aluno.setEmail(email);

        alunoService.alterarAluno(aluno);

        resp.sendRedirect(req.getContextPath()+"/admin/alunos");
    }
}