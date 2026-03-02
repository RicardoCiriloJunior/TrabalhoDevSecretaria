package org.example.controller.Notas;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Notas;
import org.example.service.NotasService;


public class AtribuirNotasController extends HttpServlet {

    private NotasService notasService;


    // Construtor
    public AtribuirNotasController(NotasService notasService){
        this.notasService = notasService;
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

        String matricula = req.getParameter("matricula");

        double nota = Double.parseDouble(req.getParameter("nota"));

        HttpSession session = req.getSession();
        long id_Disciplina = (Long) session.getAttribute("idDisciplina");

        Notas notas = new Notas(nota, matricula, id_Disciplina);

        try {
            notasService.atribuirNota(notas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}