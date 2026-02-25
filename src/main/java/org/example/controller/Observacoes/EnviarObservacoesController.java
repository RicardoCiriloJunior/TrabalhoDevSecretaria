package org.example.controller.Observacoes;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Aluno;
import org.example.model.Observacoes;
import org.example.service.AlunoService;
import org.example.service.ObservacoesService;

@WebServlet
public class EnviarObservacoesController extends HttpServlet {

    private ObservacoesService observacoesService;

    private AlunoService alunoService;

    //Construtor
    public EnviarObservacoesController(ObservacoesService observacoesService, AlunoService alunoService){
        this.observacoesService = observacoesService;
        this.alunoService = alunoService;
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String nome = req.getParameter("nome");
        String observacao = req.getParameter("observacao");

        Aluno aluno = alunoService.encontrarAlunoPorNome(nome);
        String matricula = aluno.getMatricula();


        Observacoes obs = new Observacoes(matricula, observacao);

        try{
            observacoesService.adicionarObservacao(obs);

        }catch (Exception e){
            e.printStackTrace();
        }
    }}
