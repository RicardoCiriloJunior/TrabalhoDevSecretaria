package org.example.controller.Notas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
        String tipo = req.getParameter("tipo");
        long idDisciplina = getIdDisciplina(req);
        boolean atribuida;


        double nota = Double.parseDouble(req.getParameter("nota"));


        try {
            if (tipo.equals("n2")) {
                atribuida = notasService.atribuirNota2(nota, matricula, idDisciplina);
            } else if (tipo.equals("n1")) {
                atribuida = notasService.atribuirNota1(nota, matricula, idDisciplina);
            } else {
                return;
            }
            System.out.println(atribuida ? "Nota atribuida!" : "A nota não foi atribuída");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private static long getIdDisciplina(HttpServletRequest req) {
        long idDisciplina;
        HttpSession session = req.getSession();
        if (session.getAttribute("id_Disciplina") != null){
            idDisciplina = (Long) session.getAttribute("id_Disciplina");
        } else {
            idDisciplina = Long.parseLong(req.getParameter("id_Disciplina"));
        }
        return idDisciplina;
    }
}