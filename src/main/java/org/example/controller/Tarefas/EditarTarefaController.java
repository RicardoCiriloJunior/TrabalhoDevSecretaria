package org.example.controller.Tarefas;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.service.AtividadesService;

import java.io.IOException;
import java.time.LocalDate;

public class EditarTarefaController extends HttpServlet {

    private final AtividadesService atividadesService = new AtividadesService ();

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String matricula = (String) req.getAttribute ("matriculaAluno");

        String titulo = req.getAttribute ("titulo") != null ? (String) req.getAttribute ("titulo") : "";

        String descricao = req.getAttribute ("descricao") != null ? (String) req.getAttribute ("descricao") : "";

        String status = req.getAttribute ("status") != null ? (String) req.getAttribute ("status") : "";

        LocalDate dataEntrega = req.getAttribute ("dataEntrega") != null ? (LocalDate) req.getAttribute ("dataEntrega") : null;

        atividadesService.listarAtividadesPorAluno (matricula);

    }
}
