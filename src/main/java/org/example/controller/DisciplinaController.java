package org.example.controller;

import org.example.model.Disciplina;
import org.example.service.DisciplinaService;

import java.util.List;

public class DisciplinaController {

    private DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService){
        this.disciplinaService = disciplinaService;
    }

    //Métodos

    public List<Disciplina> listarTodas(){
        return disciplinaService.listarTodas();
    }

    public Disciplina encontrarDisciplinas(String disciplina){
        return disciplinaService.encontrarDisciplina(disciplina);
    }

    public boolean deletarDisciplinaPorNome(String disciplina){
        return disciplinaService.deletarDisciplinaPorNome(disciplina);
    }

    public boolean deletarDisciplinaPorId(long id){
        return disciplinaService.deletarDisciplinaPorId(id);
    }

    public boolean alterarDisciplina(Disciplina disciplina, String nomeDisciplina){
        return disciplinaService.alterarDisciplina(disciplina,nomeDisciplina);
    }

    public boolean adicionarDisciplina(Disciplina disciplina){
        return disciplinaService.adicionarDisciplina(disciplina);
    }
}
