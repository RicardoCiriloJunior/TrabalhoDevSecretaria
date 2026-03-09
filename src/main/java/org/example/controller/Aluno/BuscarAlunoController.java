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
public class BuscarAlunoController extends HttpServlet {
    private AlunoService alunoService;

    @Override
    public void init() {
        alunoService = new AlunoService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String busca = req.getParameter("busca");
        List<Aluno> alunoBusca = alunoService.buscaAluno(busca);



        req.setAttribute("Alunos", alunoBusca);
        req.getRequestDispatcher(".jsp").forward(req, resp);


    }
}
