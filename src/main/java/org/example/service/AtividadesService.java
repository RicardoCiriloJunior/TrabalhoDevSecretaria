package org.example.service;

import java.util.List;

import org.example.model.Atividades;
import org.example.repository.AtividadesRepository;

public class AtividadesService {
    private final AtividadesRepository repository;

    public AtividadesService(AtividadesRepository repository) {
        this.repository = repository;
    }

    public Long AdicionarAtividade(Atividades atividade) {
        return repository.save(atividade);
    }

    public List<Atividades> ListarAtividadesPorAluno(String matricula) {
        return repository.findByMatr_aluno (matricula);
    }

    public boolean atualizarAtividade(Atividades atividade) {
        return repository.update(atividade);
    }

    public boolean deletarAtividade(long id) {
        return repository.deleteByID(id);
    }

    public List<Atividades> listarTodasAtividades() {
        return repository.findAll();
    }
}