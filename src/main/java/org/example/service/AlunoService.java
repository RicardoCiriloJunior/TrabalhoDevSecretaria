package org.example.service;

import org.example.model.Aluno;
import org.example.repository.AlunoRepository;

import java.util.List;

public class AlunoService {

    private AlunoRepository alunoRepository;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll ();
    }

    public Aluno encontrarAlunoPorEmail(String email) {
        if (email.matches ("^.*@.*\\.com")) {
            return alunoRepository.findByEmail (email);
        }
        return null;
    }

    public Aluno encontrarAlunoPorNome(String nome){ return alunoRepository.findByNome (nome);}

    public boolean deletarAluno(String matricula) {
        Aluno aluno = alunoRepository.findByMatricula (matricula);
        if (aluno != null) {
            return alunoRepository.deleteByMatricula (matricula);
        }
        else{
            return false;

        }
    }

    public boolean alterarSenha(Aluno aluno, String senhaNova){
        aluno.setSenha (senhaNova);

        return alunoRepository.update (aluno);
    }

    public boolean alterarRecuperarSenha(Aluno aluno, String recupSenha){
        aluno.setRecSenha (recupSenha);

        return alunoRepository.update (aluno);
    }

    public boolean adicionaAluno (Aluno aluno){ return alunoRepository.save (aluno) != 0; }

    public boolean emailValidoParaAluno(String email) {
        boolean formatoValido = email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        return formatoValido && !email.endsWith("@monstrossa.com");
    }
}