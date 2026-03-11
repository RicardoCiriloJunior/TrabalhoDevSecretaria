package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Atividades;
import org.example.service.AtividadesService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/aluno/exibir-tarefas")
public class ExibirTarefasController extends HttpServlet {

    private final AtividadesService atividadesService = new AtividadesService ();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession ();
        Object matriculaObj = session.getAttribute("matriculaAluno");
        if (session == null || matriculaObj == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        String matricula = (String) matriculaObj;



        List<Atividades> atividades = atividadesService.listarAtividadesPorAluno (matricula);

        List<Atividades> psicologia = new ArrayList<> ();

        List<Atividades> expressividade = new ArrayList<> ();

        List<Atividades> engenharia = new ArrayList<> ();

        List<Atividades> tecnologia = new ArrayList<> ();

        System.out.println(atividades);

        for(Atividades a : atividades){

            if(a.getIdDisciplina () == 2){
                psicologia.add (a);

            }

            if(a.getIdDisciplina () == 3){
                expressividade.add(a);
            }

            if(a.getIdDisciplina () == 4){
                engenharia.add(a);
            }

            if(a.getIdDisciplina () == 1){
                tecnologia.add(a);
            }
        }

        req.setAttribute("psicologia", psicologia);
        req.setAttribute("expressividade", expressividade);
        req.setAttribute ("engenharia", engenharia);
        req.setAttribute ("tecnologia", tecnologia);

        req.getRequestDispatcher("/WEB-INF/view/aluno/tarefas.jsp").forward(req, resp);

    }
}
