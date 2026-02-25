package org.example.controller.Login;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.service.ProfessorService;
import org.example.service.AlunoService;

public class LoginController {

    private AlunoService alunoService;
    private ProfessorService professorService;

    //Construtor
    public LoginController(AlunoService alunoService, ProfessorService professorService){
        this.alunoService = alunoService;
        this.professorService = professorService;
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String email = req.getParameter("nome");
        String senha = req.getParameter("senha");

        HttpSession session = req.getSession();

        try{
            if(alunoService.emailValidoParaAluno(email)){

                Aluno aluno = alunoService.loginAluno(email, senha);

                if(aluno !=  null){
                    System.out.println("Aluno logado!");
                    session.setAttribute("aluno", aluno.getNome());
                    session.setAttribute("matriculaAluno", aluno.getMatricula());
                }else{
                    System.out.println("Credenciais invalidas!");
                }

            }else{
                Professor professor =  professorService.loginProfessor(email,senha);

                if( professor != null){

                    System.out.println("Professor logado!");
                    session.setAttribute("professor", professor.getNome());
                    session.setAttribute("idDisciplina", professor.getId_disciplina());
                }else{
                    System.out.println("Credenciais invalidas");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
