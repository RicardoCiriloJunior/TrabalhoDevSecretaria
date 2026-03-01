package org.example.service;

import org.example.repository.AlunoRepository;
import org.example.repository.ObservacoesRepository;
import org.example.model.Observacoes;
import org.example.util.ConnectionFactory;

import java.util.List;


public class ObservacoesService {

    private ConnectionFactory connectionFactory = new ConnectionFactory ();

    private ObservacoesRepository observacoesRepository = new ObservacoesRepository (connectionFactory);

    private AlunoRepository alunoRepository = new AlunoRepository (connectionFactory);

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
