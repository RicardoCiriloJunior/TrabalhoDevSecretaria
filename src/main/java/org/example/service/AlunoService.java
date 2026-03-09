package org.example.service;

import org.example.model.Aluno;
import org.example.repository.AlunoRepository;
import org.example.util.ConnectionFactory;
import org.example.util.Senhas;

import java.util.List;

public class AlunoService {

    private ConnectionFactory connection = new ConnectionFactory ();

    private AlunoRepository alunoRepository = new AlunoRepository (connection);

    private Senhas senhas;

    public List<Aluno> listarTodos() {
        return alunoRepository.findAll ();
    }

    public Aluno loginAluno(String email, String senha) {
            Aluno aluno = alunoRepository.findByEmail (email);
            if ( aluno != null && Senhas.verificar(senha,aluno.getSenha())){
                return aluno;
            }
            return null;
    }

    public Aluno encontrarAlunoPorCpf(String cpf){
        cpf = cpf.replace (".", "");
        cpf = cpf.replace ("-","");
        cpf = cpf.replace (" ", "");

        long cpfFormatado = Long.parseLong (cpf);

        return alunoRepository.findByCpf (cpfFormatado);

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

    public boolean adicionaAluno (Aluno aluno){
        String senhaCripto = Senhas.gerarHash(aluno.getSenha());
        aluno.setSenha(senhaCripto);
        return alunoRepository.save (aluno) != null; }


    public int countAluno(){
        return alunoRepository.countAluno();
    }

    public List<Aluno> buscaAluno(String busca){
        return alunoRepository.buscarAluno(busca);
    }

    public Aluno findByMatricula(String matricula){
        return alunoRepository.findByMatricula(matricula);
    }

}