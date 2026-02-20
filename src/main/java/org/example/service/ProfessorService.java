package org.example.service;

import org.example.model.Professor;
import org.example.repository.DisciplinaRepository;
import org.example.repository.ProfessorRepository;

import java.util.List;

public class ProfessorService {

    private ProfessorRepository professorRepository;

    private DisciplinaRepository disciplinaRepository;

    public Professor encontrarProfessorPorEmail(String email) {
        if (email.matches ("^.*@monstrossa\\.com")) {
            return professorRepository.findByEmail (email);
        }
        return null;
    }

    public Professor encontrarProfessorPorNome(String nome){ return professorRepository.findByNome (nome); }

    public Professor encontrarProfessorPorDisciplina(String disciplina){
        long idDisciplina = disciplinaRepository.findByDisciplina (disciplina).getId ();

        return professorRepository.findByDisciplina (idDisciplina);
    }

    public List<Professor> listarTodos (){ return professorRepository.findAll (); }

    public boolean deletarProfessor(long id) {
        Professor professor = professorRepository.findById (id);

        if (professor != null){
            return professorRepository.deleteById (id);
        }
        else {
            return false;
        }
    }

    public boolean adicionaProfessor(Professor professor){ return professorRepository.save (professor) != 0; }

    public boolean alterarSenha(Professor professor, String senha){
        professor.setSenha (senha);

        return professorRepository.update (professor);
    }
}
