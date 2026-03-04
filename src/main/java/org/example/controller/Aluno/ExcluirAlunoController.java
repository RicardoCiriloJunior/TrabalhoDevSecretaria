package org.example.controller.Aluno;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.AlunoService;

import java.io.IOException;

@WebServlet
public class ExcluirAlunoController extends HttpServlet {
    private AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // input hidden do id de Aluno

        String matricula = req.getParameter("matricula");

        alunoService.deletarAluno(matricula);

    }
}
