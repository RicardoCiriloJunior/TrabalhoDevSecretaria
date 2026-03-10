package org.example.controller.Observacoes;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Aluno;
import org.example.model.Observacoes;
import org.example.model.Professor;
import org.example.service.AlunoService;
import org.example.service.ObservacoesService;
import org.example.service.ProfessorService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarObsRecebidasController extends HttpServlet {

    private ObservacoesService observacoesService;
    private AlunoService alunoService;

    @Override
    public void init() throws ServletException {
        observacoesService = new ObservacoesService();
        alunoService = new AlunoService();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String nomeAluno = (String) session.getAttribute("alunoNome");

        Aluno aluno = alunoService.encontrarAlunoPorNome(nomeAluno);

        List<Observacoes> observacoesRecebidas = observacoesService.listarObsRecebidas(aluno.getMatricula());

        req.setAttribute("observacoesRecebidas", observacoesRecebidas);

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }
}
