package org.example.controller.Cadastro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.util.GeradorUUID;
import org.example.service.AlunoService;

import java.io.IOException;

@WebServlet(name = "cadastroServlet", urlPatterns = {"/cadastro"})
public class CadastroAlunoController extends HttpServlet {

    private AlunoService alunoService;
    private GeradorUUID geradorUUID;

    @Override
    public void init() throws ServletException {
        alunoService = new AlunoService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmarSenha");

        if (!senha.equals(confirmaSenha)) {
            req.setAttribute("erro", "Confirmar senha está incorreto!");
            req.getRequestDispatcher("/WEB-INF/view/cadastro.jsp").forward(req, resp);
            return;
        } else if (!alunoService.emailValidoParaAluno(email)) {
            req.setAttribute("erro", "O email está incorreto!");
            req.getRequestDispatcher("/WEB-INF/view/cadastro.jsp").forward(req, resp);
            return;
        }

        long cpfLong = Long.parseLong(cpf);

        String matricula = geradorUUID.gerarUUID().toString();

        Aluno aluno = new Aluno(matricula,nome, senha, email, cpfLong);

        try {
            alunoService.adicionaAluno(aluno);
            System.out.println("Aluno cadastrado com matrícula: " + matricula);
            resp.sendRedirect(req.getContextPath() + "/login");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}