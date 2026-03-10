package org.example.service;

import org.example.model.Disciplina;
import org.example.repository.DisciplinaRepository;
import org.example.util.ConnectionFactory;

import java.util.List;

public class DisciplinaService {

    private ConnectionFactory connectionFactory = new ConnectionFactory ();

    private DisciplinaRepository disciplinaRepository = new DisciplinaRepository (connectionFactory);

    public List<Disciplina> listarTodas () { return disciplinaRepository.findAll (); }

    public Disciplina encontrarDisciplina(String disciplina) { return disciplinaRepository.findByDisciplina (disciplina); }
    public Disciplina encontarDiscPorId(long id) { return disciplinaRepository.findById (id); }


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
