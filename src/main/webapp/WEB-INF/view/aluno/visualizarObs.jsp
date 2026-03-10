<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Observacoes" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Observações</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/observacoesAluno.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="layout">

    <jsp:include page="../components/sidebarAluno.jsp">
        <jsp:param name="tabActive" value="visualizarObs"/>
    </jsp:include>

    <main class="content">

        <h1>Observações</h1>

        <div class="filters">
        </div>

        <%
            List<Observacoes> lista = (List<Observacoes>) request.getAttribute("observacoesRecebidas");
            Map<Long, String> nomesProfessores = (Map<Long, String>) request.getAttribute("nomesProfessores");
            Map<Long, String> nomesDisciplinas = (Map<Long, String>) request.getAttribute("nomesDisciplinas");

            if (lista == null || lista.isEmpty()) {
        %>
        <p class="sem-obs">Nenhuma observação recebida.</p>
        <%
        } else {
            for (Observacoes obs : lista) {
                String nomeProf = nomesProfessores.get(obs.getId_professor());
                String nomeDisc = nomesDisciplinas.get(obs.getId_disciplina());
        %>
        <div class="card light">
            <div class="card-header">
                <div>
                    <p>Professor: <%= nomeProf %></p>
                    <p>Disciplina: <%= nomeDisc %></p>
                </div>
            </div>
            <p class="message"><%= obs.getObservacao() %></p>
        </div>
        <%
                }
            }
        %>

    </main>
</div>

</body>
</html>