package org.example.controller.Cadastro;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.util.GeradorUUID;
import org.example.service.AlunoService;
import org.example.util.Verificacao;

import java.io.IOException;

@WebServlet(name = "cadastroServlet", urlPatterns = {"/cadastro"})
public class CadastroAlunoController extends HttpServlet {

    private AlunoService alunoService;
    private GeradorUUID geradorUUID;
    private Verificacao verificacao;

    @Override
    public void init() throws ServletException {
        alunoService = new AlunoService();
        geradorUUID = new GeradorUUID();
        verificacao =  new Verificacao();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");
        String confirmaSenha = req.getParameter("confirmarSenha");

        if (!Verificacao.validarCpf(cpf)) {
            System.out.println("O cpf está incorreto!");
            req.setAttribute("erroCpf", "Precisa ser um cpf válido!");
            req.setAttribute("nome", nome);
            req.setAttribute("email", email);
            req.setAttribute("senha", senha);
            req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
            return;
        } else if (!Verificacao.validarEmail(email)) {
            System.out.println("O email está incorreto!");
            req.setAttribute("erroEmail", "Precisa ser um email válido!");
            req.setAttribute("nome", nome);
            req.setAttribute("cpf", cpf);
            req.setAttribute("email", email);
            req.setAttribute("senha", senha);
            req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
            return;
        } else if (!Verificacao.validarSenha(senha)){
            System.out.println("A senha está incorreta!");
            req.setAttribute("erroSenha", "Ops! A senha está incorreta! Ela precisa ter no mínimo 8 dígitos e um número");
            req.setAttribute("nome", nome);
            req.setAttribute("cpf", cpf);
            req.setAttribute("email", email);
            req.setAttribute("senha", senha);
            req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
            return;
        } else if (!senha.equals(confirmaSenha)) {
            System.out.println("A senha está incorreta!");
            req.setAttribute("erroSenha", "Ops! A senha está incorreta!");
            req.setAttribute("nome", nome);
            req.setAttribute("cpf", cpf);
            req.setAttribute("email", email);
            req.setAttribute("senha", senha);
            req.getRequestDispatcher("/cadastro.jsp").forward(req, resp);
            return;
        }

        long cpfLong = Long.parseLong(cpf);

        String matricula = geradorUUID.gerarUUID().toString();

        Aluno aluno = new Aluno(matricula,nome, senha, email, cpfLong);

        try {
            alunoService.adicionaAluno(aluno);
            System.out.println("Aluno cadastrado com matrícula: " + matricula);
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}