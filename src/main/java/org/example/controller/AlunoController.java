package org.example.controller;

import org.example.model.Aluno;
import org.example.service.AlunoService;

import java.util.List;

public class AlunoController {

    private AlunoService alunoService;

    //Construtor
    public AlunoController(AlunoService alunoService){
        this.alunoService = alunoService;    }

    //Métodos

    public List<Aluno> listarTodos(){
        return alunoService.listarTodos();
    }

    public Aluno encontarAlunoPorEmail(String email){
        return alunoService.encontrarAlunoPorEmail(email);
    }

    public Aluno encontrarAlunoPorNome(String nome){
        return alunoService.encontrarAlunoPorNome(nome);
    }

    public boolean deletarAluno(String matricula){
        return alunoService.deletarAluno(matricula);
    }

    public boolean alterarSenha(Aluno aluno, String senhaNova){
        return alunoService.alterarSenha(aluno, senhaNova);
    }

    public boolean alterarRecuperarSenha(Aluno aluno, String recupSenha){
        return alunoService.alterarRecuperarSenha(aluno, recupSenha);
    }

    public boolean adicionaAluno(Aluno aluno){
        return alunoService.adicionaAluno(aluno);
    }
}
