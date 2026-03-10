package org.example.controller.Atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Atividades;
import org.example.service.AtividadesService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarAtividadesController extends HttpServlet {
    private AtividadesService atividadesService;

    @Override
    public void init() {
        atividadesService = new AtividadesService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String matricula = (String) session.getAttribute("matricula");

        List<Atividades> atividades = atividadesService.findByMatricula(matricula);

        req.setAttribute("atividades", atividades);

        req.getRequestDispatcher("/admin-Atividadess.jsp").forward(req, resp);
    }

}
