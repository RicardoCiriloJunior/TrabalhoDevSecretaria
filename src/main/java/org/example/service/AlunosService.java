package org.example.service;

import org.example.repository.AlunoRepository;
import org.example.util.ConnectionFactory;

public class AlunosService {
    private final ConnectionFactory connectionFactory = new ConnectionFactory();
    private final AlunoRepository repository = new AlunoRepository(connectionFactory);


}
