<%@ page import="org.example.model.Observacoes" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 01/03/2026
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ include file="../components/sidebarProfessor.jsp"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Painel do Professor</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/professor/inicio.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<div class="layout">
    <!-- CONTEÚDO -->
    <main class="content">

        <h1>Início</h1>
        <p class="welcome">Bem vindo, professor!</p>

        <!-- CARDS SUPERIORES -->
        <div class="cards">

            <div class="card blue">
                <div class="card-header">
                    <i class="fa-solid fa-graduation-cap"></i>
                    <span>Alunos</span>
                </div>
                <h2>${totalAlunos}</h2>
            </div>

            <div class="card green">
                <div class="card-header">
                    <i class="fa-solid fa-book"></i>
                    <span>Obs enviadas</span>
                </div>
                <h2>${totalObsEnviadas}</h2>
            </div>

            <div class="card yellow">
                <div class="card-header">
                    <i class="fa-solid fa-star"></i>
                    <span>Média Geral</span>
                </div>
                <h2>${mediaGeral}</h2>
            </div>

            <div class="card red">
                <div class="card-header">
                    <i class="fa-solid fa-file"></i>
                    <span>Recuperações</span>
                </div>
                <h2>${totalRecuperacoes}</h2>
            </div>

        </div>

        <div class="bottom">
            <h2 class="section">Visualizar observações</h2>

            <div class="observations">
                <%
                    List<Observacoes> observacoes = (List<Observacoes>) request.getAttribute("observacoes");
                    if (observacoes == null || observacoes.isEmpty()) {
                %>
                <div class="obs-card">
                    <h4>Nenhuma observação enviada.</h4>
                </div>
                <% } else {
                    for (Observacoes obs : observacoes) { %>
                <div class="obs-card">
                    <h4><%= ((Map<String, String>) request.getAttribute("nomesAlunos")).get(obs.getMatricula()) %></h4>
                    <p><i class="fa-solid fa-comment"></i> <%= obs.getObservacao() %></p>
                </div>
                <%  }
                } %>
            </div>
        </div>
    </main>
</div>

</body>
</html>