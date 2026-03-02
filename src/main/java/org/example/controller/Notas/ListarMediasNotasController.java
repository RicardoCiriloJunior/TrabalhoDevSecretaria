package org.example.controller.Notas;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Media;
import org.example.service.NotasService;

import java.io.IOException;
import java.util.List;

@WebServlet
public class ListarMediasNotasController extends HttpServlet {

    private NotasService notasService;


    // Construtor
    public ListarMediasNotasController(NotasService notasService){
        this.notasService = notasService;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      //input hidden

        long idDisciplina = Long.parseLong(request.getParameter("idDisciplina"));

        List<Media> medias = notasService.media(idDisciplina);

        request.setAttribute("medias", medias);

        request.getRequestDispatcher(".jsp").forward(request, response);
    }

}