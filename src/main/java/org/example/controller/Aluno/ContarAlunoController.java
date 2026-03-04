package org.example.controller.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.AlunoService;

import java.io.IOException;

@WebServlet("/Aluno")
public class ContarAlunoController extends HttpServlet {

    private AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        long total = alunoService.countAluno();

        req.setAttribute("totalAlunos", total);

        req.getRequestDispatcher("/.jsp").forward(req, resp);
    }
}