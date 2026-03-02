package org.example.controller.Notas;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Media;
import org.example.service.NotasService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class MediaGeralController {
    private NotasService notasService;

    public MediaGeralController(NotasService notasService){
        this.notasService = notasService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //input hidden

        long idDisciplina = Long.parseLong(request.getParameter("idDisciplina"));

        double media = notasService.mediaGeral(idDisciplina);

        request.setAttribute("mediaGeral", media);

        request.getRequestDispatcher(".jsp").forward(request, response);
    }
}
