package org.example.controller;

import org.example.model.Observacoes;
import org.example.service.ObservacoesService;

import java.util.List;

public class ObservacoesController {

    private ObservacoesService observacoesService;

    //Construtor
    public ObservacoesController(ObservacoesService observacoesService){
        this.observacoesService = observacoesService;
    }


    // Métodos

    public List<Observacoes> listarTodos(){
        return observacoesService.listarTodos();
    }

    public boolean deletarObservacao(long id){
        return observacoesService.deletarObservacao(id);
    }

    public boolean adicionarObservacao(Observacoes observacoes){
        return observacoesService.adicionarObservacao(observacoes);
    }

    public Observacoes encontrarObservacoesPorMatricula(String matricula){
        return observacoesService.encontrarObservacaoPorMatricula(matricula);
    }
}
