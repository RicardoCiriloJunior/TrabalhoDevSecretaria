package org.example.controller;

import org.example.model.Professor;
import org.example.service.ProfessorService;

import java.util.List;

public class ProfessorController {

    private ProfessorService professorService;

    // Construtor
    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    // Métodos

    public Professor encontrarProfessorPorEmail(String email){
        return professorService.encontrarProfessorPorEmail(email);
    }

    public Professor encontarProfessorPorNome(String nome){
        return professorService.encontrarProfessorPorNome(nome);
    }

    public Professor encontrarProfessorPorDisciplina(String disciplina){
        return professorService.encontrarProfessorPorDisciplina(disciplina);
    }

    public List<Professor> listarTodos(){
        return professorService.listarTodos();
    }

    public boolean deletarProfessor(long id){
        return professorService.deletarProfessor(id);
    }

    public boolean adicionarProfessor(Professor professor){
        return professorService.adicionaProfessor(professor);
    }

    public boolean alterarSenha(Professor professor, String senha){
        return professorService.alterarSenha(professor, senha);
    }

}
