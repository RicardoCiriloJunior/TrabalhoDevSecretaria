package org.example.controller.Notas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Notas;
import org.example.service.NotasService;

@WebServlet("/atribuir-nota")
public class AtribuirNotasController extends HttpServlet {

    private  NotasService notasService = new NotasService();


    @Override
    public void init() throws ServletException {
        notasService = new NotasService();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String matricula = req.getParameter("matricula");
        long idDisciplina;

        HttpSession session = req.getSession();
        if (session.getAttribute("id_Disciplina") != null){
             idDisciplina = (Long) session.getAttribute("id_Disciplina");
        } else {
            idDisciplina = Long.parseLong(req.getParameter("id_Disciplina"));
        }
        double nota = Double.parseDouble(req.getParameter("nota"));

        Notas notas = new Notas(nota, matricula, idDisciplina);

        try {
            notasService.atribuirNota(notas);
            System.out.println("Nota atribuída! " + notas.getNota());
        } catch (Exception e) {


            e.printStackTrace();
        }

    }
}