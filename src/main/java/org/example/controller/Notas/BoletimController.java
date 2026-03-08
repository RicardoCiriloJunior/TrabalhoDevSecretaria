package org.example.controller.Notas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Notas;
import org.example.service.AlunoService;
import org.example.service.NotasService;

import java.io.IOException;

@WebServlet("/aluno/boletim")
public class BoletimController extends HttpServlet {

    private final NotasService notasService = new NotasService ();

    private final AlunoService alunoService = new AlunoService ();


    public void doGet (HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
        HttpSession session = req.getSession();
        String aluno = (String) session.getAttribute("matriculaAluno");

        if (aluno == null){
            resp.sendRedirect (req.getContextPath ());
        }
        else {
            req.setAttribute ("nome", alunoService.encontrarAlunoPorMatricula (aluno).getNome ());

            Notas nota1 = notasService.encontrarPoridDisciplinaMatricula (aluno,2);

            Notas nota2 = notasService.encontrarPoridDisciplinaMatricula (aluno,3);

            Notas nota3 = notasService.encontrarPoridDisciplinaMatricula (aluno,4);

            Notas nota4 = notasService.encontrarPoridDisciplinaMatricula (aluno,1);



            req.setAttribute ("nota1M1", nota1 != null ? nota1.getNota () : 0);
            req.setAttribute ("nota2M1", nota1 != null ? nota1.getNota2 () : 0);

            req.setAttribute ("nota1M2", nota2 != null ? nota2.getNota () : 0);
            req.setAttribute ("nota2M2", nota2 != null ? nota2.getNota2 () : 0);

            req.setAttribute ("nota1M3", nota3 != null ? nota3.getNota () : 0);
            req.setAttribute ("nota2M3", nota3 != null ? nota3.getNota2 () : 0);

            req.setAttribute ("nota1M4", nota4 != null ? nota4.getNota () : 0);
            req.setAttribute ("nota2M4", nota4 != null ? nota4.getNota2 () : 0);


            int cont = 0;

            req.setAttribute ("media1", notasService.media (2, aluno));
            if (notasService.media (2, aluno) > 7){
                req.setAttribute ("situacao1", "Aprovado");
                cont ++;
            }else {
                req.setAttribute ("situacao1", "Reprovado");
            }
            req.setAttribute ("media2", notasService.media (3,aluno));
            if (notasService.media (3, aluno) > 7){
                req.setAttribute ("situacao2", "Aprovado");
                cont ++;
            }else {
                req.setAttribute ("situacao2", "Reprovado");
            }
            req.setAttribute ("media3", notasService.media (4,aluno));
            if (notasService.media (4, aluno) > 7){
                req.setAttribute ("situacao3", "Aprovado");
                cont ++;
            }else {
                req.setAttribute ("situacao3", "Reprovado");
            }
            req.setAttribute ("media4", notasService.media (1,aluno));
            if (notasService.media (1, aluno) > 7){
                req.setAttribute ("situacao4", "Aprovado");
                cont ++;
            }else {
                req.setAttribute ("situacao4", "Reprovado");
            }

            if (cont == 4){
                req.setAttribute ("situacaoFinal", "Aprovado");
            }else {
                req.setAttribute ("situacaoFinal", "Reprovado");
            }

            req.getRequestDispatcher("WEB-INF/view/aluno/boletim.jsp").forward(req, resp);
        }


    }
}
