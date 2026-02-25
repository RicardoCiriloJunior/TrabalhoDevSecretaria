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

        String nota = req.getParameter("nota");
        String matricula = req.getParameter("matricula");

        HttpSession session = req.getSession();
        long id_Disciplina = (Long) session.getAttribute("idDisciplina");

        double notaDouble = Double.parseDouble(nota);

        Notas notas = new Notas(notaDouble, matricula, id_Disciplina);

        try {
            notasService.atribuirNota(notas);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}