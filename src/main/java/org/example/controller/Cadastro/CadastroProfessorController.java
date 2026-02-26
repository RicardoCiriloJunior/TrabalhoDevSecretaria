package org.example.controller.Cadastro;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Professor;
import org.example.service.ProfessorService;

@WebServlet(name = "...", urlPatterns = {"/..."})
public class CadastroProfessorController extends HttpServlet {

    private ProfessorService professorService;

    //Construtor
    public CadastroProfessorController(ProfessorService professorService){
        this.professorService = professorService;    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        long cpfLong = Long.parseLong(cpf);

        Professor professor = new Professor(nome, senha,email, cpfLong);

        try{
            professorService.adicionaProfessor(professor);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}