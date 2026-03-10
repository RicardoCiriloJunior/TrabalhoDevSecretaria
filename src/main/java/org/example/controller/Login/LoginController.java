package org.example.controller.Login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.service.ProfessorService;
import org.example.service.AlunoService;
import org.example.util.Verificacao;

import java.io.IOException;

@WebServlet(name = "loginServlet" , urlPatterns = {"/login"})
public class LoginController extends HttpServlet {

    private AlunoService alunoService;
    private ProfessorService professorService;

    @Override
    public void init() throws ServletException {
        alunoService = new AlunoService();
        professorService = new ProfessorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.out.println(email + senha);

        HttpSession session = req.getSession();

        try {
            if (Verificacao.validarEmail(email)) {

                Aluno aluno = alunoService.loginAluno(email, senha);

                if (aluno != null) {
                    System.out.println("Aluno logado!");
                    session.setAttribute("alunoNome", aluno.getNome());
                    session.setAttribute("matriculaAluno", aluno.getMatricula());
                    resp.sendRedirect(req.getContextPath() + "/redirecionar?page=inicioAluno");
                } else {
                    req.setAttribute("erroLogin", "Credenciais inválidas!");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }

            } else {
                Professor professor = professorService.loginprofessor(email, senha);

                if (professor != null) {
                    System.out.println("Professor logado!");
                    session.setAttribute("professorNome", professor.getNome());
                    session.setAttribute("idDisciplina", professor.getId_disciplina());
                    resp.sendRedirect(req.getContextPath() + "/professor/inicio");
                } else {
                    req.setAttribute("erroLogin", "Credenciais inválidas!");
                    req.getRequestDispatcher("/login.jsp").forward(req, resp);
                }
            }

        } catch (Exception e) {
            req.setAttribute("erroLogin", "Credenciais inválidas!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            e.printStackTrace();
        }
    }
}