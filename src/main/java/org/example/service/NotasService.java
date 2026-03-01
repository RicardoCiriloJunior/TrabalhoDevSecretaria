package org.example.service;

import org.example.model.Notas;
import org.example.repository.DisciplinaRepository;
import org.example.repository.NotasRepository;
import org.example.util.ConnectionFactory;

import java.util.List;

public class NotasService {

    private ConnectionFactory connectionFactory = new ConnectionFactory ();

    private NotasRepository notasRepository = new NotasRepository (connectionFactory);
    private DisciplinaRepository disciplinaRepository = new DisciplinaRepository (connectionFactory);


    public List<Notas> listarTodas (){return notasRepository.findAll ();}

    public boolean atribuirNota(Notas nota){return notasRepository.save (nota) != 0;}

    public boolean alterarNota(Notas nota, double valor){
        nota.setNota (valor);
        return notasRepository.update (nota);
    }

    public boolean deletarNota(String matricula){
        String aluno = notasRepository.findByMatricula (matricula).getMatricula ();
        return notasRepository.deleteByMatricula (aluno);
    }

    public List<Notas> filtrarPorNota (double nota){
        return notasRepository.findByNota (nota);
    }

    public List<Notas> filtrarPorDisciplina (String disciplina){
        long idDisciplina = disciplinaRepository.findByDisciplina (disciplina).getId ();
        return notasRepository.findByIdDisciplina (idDisciplina);
    }
}
