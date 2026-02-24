package org.example.controller.Observacoes;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Administrador;
import org.example.model.Observacoes;
import org.example.service.ObservacoesService;

@WebServlet
public class ObservacoesController extends HttpServlet {

    private ObservacoesService observacoesService;

    //Construtor
    public ObservacoesController(ObservacoesService observacoesService){
        this.observacoesService = observacoesService;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String nome = req.getParameter("nome");
        String senha = req.getParameter("senha");

        Administrador adm = new Administrador(nome, senha);

        try{
            administradorService.entrarNaConta(adm);

        }catch (Exception e){
            e.printStackTrace();
        }
    }}
