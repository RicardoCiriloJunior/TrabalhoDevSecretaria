package org.example.controller.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.service.AlunoService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarAlunoController extends HttpServlet {
    private AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Aluno> aluno = alunoService.listarTodos();

        req.setAttribute("Alunos", aluno);

        req.getRequestDispatcher("/admin-Alunos.jsp").forward(req, resp);
    }

}
