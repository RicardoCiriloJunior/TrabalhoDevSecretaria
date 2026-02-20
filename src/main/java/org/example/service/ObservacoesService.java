package org.example.service;

import org.example.repository.AlunoRepository;
import org.example.repository.ObservacoesRepository;
import org.example.model.Observacoes;

import java.util.List;


public class ObservacoesService {

    private ObservacoesRepository observacoesRepository;

    private AlunoRepository alunoRepository;

    public List<Observacoes> listarTodos() { return observacoesRepository.findAll (); }

    public boolean deletarObservacao (long id){
        Observacoes obsevacao = observacoesRepository.findById (id);

        if (obsevacao != null){
            return observacoesRepository.deleteById (id);
        }
        else {
            return false;
        }
    }

    public Observacoes encontrarObservacaoPorMatricula(String matricula){
        String verificaMatricula = alunoRepository.findByMatricula (matricula).getMatricula ();

        if (verificaMatricula == null){
            return null;
        }
        else{
            return observacoesRepository.findByMatricula (matricula);
        }
    }

    public boolean adicionarObservacao(Observacoes observacao) { return observacoesRepository.save (observacao) != 0; }




}
