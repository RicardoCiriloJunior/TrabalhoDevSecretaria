package org.example.controller;
import org.example.model.Notas;
import org.example.service.NotasService;

import java.util.List;

public class NotasController {

    private NotasService notasService;


    // Construtor
    public NotasController(NotasService notasService){
        this.notasService = notasService;
    }

    // Métodos

    public List<Notas> listarTodasNotas(){
        return notasService.listarTodas();
    }

    public boolean atribuirNota(Notas nota){
        return notasService.atribuirNota(nota);
    }


    public boolean alterarNota(Notas nota, double valor){
        return notasService.alterarNota(nota, valor);
    }

    public boolean deletarNota(String matricula){
        return notasService.deletarNota(matricula);
    }

    public List<Notas> filtrarNotas(double nota){
        return notasService.filtrarPorNota(nota);
    }

    public List<Notas> filtarPorDisciplinas(String disciplina){
        return notasService.filtrarPorDisciplina(disciplina);
    }

}
