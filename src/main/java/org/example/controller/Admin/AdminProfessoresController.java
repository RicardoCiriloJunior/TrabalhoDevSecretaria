package org.example.controller.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Professor;
import org.example.service.ProfessorService;

import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet("/admin/professores")
public class AdminProfessoresController extends HttpServlet {
    ProfessorService professorService;

    @Override
    public void init() throws ServletException {
        this.professorService = new ProfessorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("emailAdmin") == null) {
            resp.sendRedirect("/login");
            return;
        }
        List<Professor> professores;
        String busca = req.getParameter("busca");
        if (busca != null && !busca.isEmpty() && !busca.isBlank()) {
            professores = professorService.buscarProfessor(busca);
        } else  {
            professores = professorService.listarTodos();
        }
        req.setAttribute("professores", professores);

        req.getRequestDispatcher("/WEB-INF/view/administrador/addProfessor.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String cpf = req.getParameter("cpf");
        String idDisciplina = req.getParameter("id_disciplina");

        // validação básica
        if (nome == null || email == null || senha == null || cpf == null || idDisciplina == null ||
                nome.isBlank() || email.isBlank() || senha.isBlank() || cpf.isBlank() || idDisciplina.isBlank()) {

            resp.sendRedirect("/admin/professores");
            return;
        }

        long cpfLong = Long.parseLong(cpf);
        long idDisciplinaLong = Long.parseLong(idDisciplina);

        Professor professor = new Professor(
                idDisciplinaLong,
                email,
                senha,
                nome,
                cpfLong
        );

        professorService.adicionaProfessor(professor);

        resp.sendRedirect("/admin/professores");
    }
}
