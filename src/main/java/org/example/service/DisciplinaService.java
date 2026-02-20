package org.example.service;

import org.example.model.Disciplina;
import org.example.repository.DisciplinaRepository;

import java.util.List;

public class DisciplinaService {

    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas () { return disciplinaRepository.findAll (); }

    public Disciplina encontrarDisciplina(String disciplina) { return disciplinaRepository.findByDisciplina (disciplina); }

    public boolean deletarDisciplinaPorNome (String disciplina){
        Disciplina verificacao = disciplinaRepository.findByDisciplina (disciplina);
        if (verificacao != null){
            return disciplinaRepository.deleteByDisciplina (disciplina);
        }
        else {
            return false;
        }
    }

    public boolean deletarDisciplinaPorId (long id){
        Disciplina verificacao = disciplinaRepository.findById (id);
        if (verificacao != null){
            return disciplinaRepository.deleteByID (id);
        }
        else {
            return false;
        }
    }

    public boolean alterarDisciplina (Disciplina disciplina, String nomeDisciplina){
        disciplina.setDisciplina (nomeDisciplina);
        return disciplinaRepository.update (disciplina);
    }

    public boolean adicionarDisciplina (Disciplina disciplina) { return disciplinaRepository.save (disciplina) != 0; }

}
