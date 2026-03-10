package org.example.service;

import org.example.model.Aluno;
import org.example.model.Professor;
import org.example.repository.DisciplinaRepository;
import org.example.repository.ProfessorRepository;
import org.example.util.ConnectionFactory;
import org.example.util.Senhas;

import java.util.List;

public class ProfessorService {

    private ConnectionFactory connectionFactory = new ConnectionFactory ();

    private ProfessorRepository professorRepository = new ProfessorRepository (connectionFactory);

    private DisciplinaRepository disciplinaRepository = new DisciplinaRepository (connectionFactory);

    public Professor encontrarProfessorPorEmail(String email) {
        if (email.matches("^.*@monstrossa\\.com")) {
            return professorRepository.findByEmail(email);
        }
        return null;
    }

    public Professor encontrarProfessorPorCpf(String cpf) {
        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        cpf = cpf.replace(" ", "");

        long cpfFormatado = Long.parseLong(cpf);

        return professorRepository.findByCpf(cpfFormatado);

    }
    public Professor encontrarProfessorPorId(long id) {
        return professorRepository.findById(id);
    }


    public Professor encontrarProfessorPorNome(String nome) {
        return professorRepository.findByNome(nome);
    }

    public Professor encontrarProfessorPorDisciplina(String disciplina) {
        long idDisciplina = disciplinaRepository.findByDisciplina(disciplina).getId();

        return professorRepository.findByDisciplina(idDisciplina);
    }

    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    public boolean deletarProfessor(long id) {
        Professor professor = professorRepository.findById(id);

        if (professor != null) {
            return professorRepository.deleteById(id);
        } else {
            return false;
        }
    }

    public boolean adicionaProfessor(Professor professor) {
        String senhaCripto = Senhas.gerarHash(professor.getSenha());
        professor.setSenha(senhaCripto);
        return professorRepository.save(professor) != 0;
    }

    public boolean alterarSenha(Professor professor, String senha) {
        professor.setSenha(senha);

        return professorRepository.update(professor);
    }
    public boolean alterarProfessor(Professor professor) {

        return professorRepository.update(professor);
    }


    public Professor loginprofessor(String email, String senha) {
        Professor professor = professorRepository.findByEmail (email);
        if ( professor != null && Senhas.verificar(senha,professor.getSenha())){
            return professor;
        }
        return null;
    }

    public int countProfessor() {

        return professorRepository.countProfessor();}

    public List<Professor> buscarProfessor(String busca){
        return professorRepository.buscarProfessor(busca);
    }
}
