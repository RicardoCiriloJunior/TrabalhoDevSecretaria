package org.example.controller.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.repository.ProfessorRepository;
import org.example.service.ProfessorService;
import org.example.service.AlunoService;

public class LoginController {

    private AlunoService alunoService;
    private ProfessorService professorService;

    //Construtor
    public LoginController(AlunoService alunoService){
        this.alunoService = alunoService;    }
    public LoginController(ProfessorService professorService){
        this.professorService = professorService;    }

    // Verificar o email antes

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String email = req.getParameter("nome");
        String senha = req.getParameter("senha");

        Aluno aluno = new Aluno(email, senha);
        Professor professor = new Professor(email, senha);

        try{
            if(alunoService.adicionaAluno(aluno)){
                System.out.println("Aluno logado!");
            }else{
                professorService.adicionaProfessor(professor);
                System.out.println("Professor logado!");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
