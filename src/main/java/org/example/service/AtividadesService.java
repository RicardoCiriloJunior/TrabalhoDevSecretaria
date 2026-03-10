package org.example.service;

import java.util.List;

import org.example.model.Atividades;
import org.example.repository.AtividadesRepository;
import org.example.util.ConnectionFactory;

public class AtividadesService {

    private ConnectionFactory connectionFactory = new ConnectionFactory ();
    private final AtividadesRepository repository = new AtividadesRepository (connectionFactory);

    public Long adicionarAtividade(Atividades atividade) {
        return repository.save(atividade);
    }

    public List<Atividades> listarAtividadesPorAluno(String matricula) {
        return repository.findByMatr_aluno (matricula);
    }

    public boolean atualizarAtividade(Atividades atividade) {
        return repository.update(atividade);
    }

    public boolean deletarAtividade(long id) {
        return repository.deleteByID(id);
    }
    public List<Atividades> findByMatricula(String matricula) {
        return repository.findByMatricula(matricula);
    }


    public List<Atividades> listarTodasAtividades() {
        return repository.findAll();
    }
}