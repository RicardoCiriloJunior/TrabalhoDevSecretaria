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

    public boolean atribuirNota(double nota, String matricula, long idDisciplina){
        Notas notasExistentes = notasRepository.findByMatriculaAndDisciplina(matricula, idDisciplina);
        if (notasExistentes == null) {
            Notas notas = new Notas(0, nota, matricula, idDisciplina);
            return notasRepository.save(notas) != null;
        } else if (nota != notasExistentes.getNota2()) {
            notasExistentes.setNota2(nota);
            return notasRepository.update(notasExistentes);
        } else if (nota == notasExistentes.getNota2()) {
            return true;
        }
        return false;
    }

    public boolean alterarNota(Notas nota, double valor){
        nota.setNota (valor);
        return notasRepository.update (nota);
    }

    public Notas encontrarPoridDisciplinaMatricula(String matricula, long idDisciplina){
        return notasRepository.findByMatriculaAndDisciplina(matricula, idDisciplina);
    }

    public List<Notas> filtrarPorDisciplina (String disciplina){
        long idDisciplina = disciplinaRepository.findByDisciplina (disciplina).getId ();
        return notasRepository.findByIdDisciplina (idDisciplina);
    }
    public double media(long idDisciplina, String matricula){
        return notasRepository.calcularMediaPorDisciplina(idDisciplina, matricula);
    }

    public double mediaGeral(long idDisciplina){
        return notasRepository.calcularMediaGeral(idDisciplina);
    }
}
