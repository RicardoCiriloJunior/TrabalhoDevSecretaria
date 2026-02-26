package org.example.controller.Cadastro;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.service.AlunoService;

@WebServlet(name = "...", urlPatterns = {"/..."})
public class CadastroAlunoController extends HttpServlet {

    private AlunoService alunoService;

    //Construtor
    public CadastroAlunoController(AlunoService alunoService){
        this.alunoService = alunoService;    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        long cpfLong = Long.parseLong(cpf);

        Aluno aluno = new Aluno(nome, senha,email, cpfLong);

        try{
            alunoService.adicionaAluno(aluno);
        }catch (Exception e){
            e.printStackTrace();
        }
    }





}
