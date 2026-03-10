package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Aluno;
import org.example.service.AlunoService;

import java.io.IOException;
import java.util.List;

@WebServlet("/admin/alunos")
public class AdminAlunosController extends HttpServlet {
    AlunoService alunoService;

    @Override
    public void init() throws ServletException {
        this.alunoService = new AlunoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("emailAdmin") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        String busca = req.getParameter("busca");
        List<Aluno> alunos;

        if (busca != null && !busca.isEmpty() && !busca.isBlank()) {
            alunos = alunoService.buscaAluno(busca);
        } else {
            alunos = alunoService.listarTodos();
        }

        req.setAttribute("alunos", alunos);

        req.getRequestDispatcher("/WEB-INF/view/administrador/addAluno.jsp").forward(req, resp);
    }
}
