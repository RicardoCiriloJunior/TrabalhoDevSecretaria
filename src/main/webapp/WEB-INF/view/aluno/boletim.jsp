<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/boletim.css">
    <title>Boletim - Aluno</title>
</head>
<body>

<jsp:include page="../components/sidebarAluno.jsp" >
    <jsp:param name="tabActive" value="boletim"/>
</jsp:include>

<div class="main">
    <div class="card">
        <div class="titulo">Boletim Escolar</div>

    <div class="info-aluno">
        <div class="col-esquerda">
            <p><strong>ALUNO(A):</strong> <%= request.getAttribute ("nome") %> </p>
        </div>
        <div class="col-direita">
            <p><strong>ANO LETIVO:</strong> 2026</p>
            <p><strong>SITUAÇÃO FINAL:</strong> <span class="status-destaque"><%= request.getAttribute("situacaoFinal") %></span></p>
        </div>
    </div>

    <table>
        <thead>
            <tr>
                <th>Disciplina</th>
                <th>1º Sem</th>
                <th>2º Sem</th>
                <th>Média</th>
                <th>Situação</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>Psicologia do Medo Infantil</td>
                <td><%= request.getAttribute("nota1M1") %></td>
                <td><%= request.getAttribute("nota2M1") %></td>
                <td><%= request.getAttribute("media1") %></td>
                <td><span class="status-aprovado"><%= request.getAttribute("situacao1") %></span></td>
            </tr>

            <tr>
                <td>Expressividade Vocal Avançada</td>
                <td><%= request.getAttribute("nota1M2") %></td>
                <td><%= request.getAttribute("nota2M2") %></td>
                <td><%= request.getAttribute("media2") %></td>
                <td><span class="status-aprovado"><%= request.getAttribute("situacao2") %></span></td>
            </tr>

            <tr>
                <td>Engenharia de Sustos e Rendimento Energético</td>
                <td><%= request.getAttribute("nota1M3") %></td>
                <td><%= request.getAttribute("nota2M3") %></td>
                <td><%= request.getAttribute("media3") %></td>
                <td><span class="status-aprovado"><%= request.getAttribute("situacao3") %></span></td>
            </tr>

            <tr>
                <td>Tecnologia de Portais Interdimensionais</td>
                <td><%= request.getAttribute("nota1M4") %></td>
                <td><%= request.getAttribute("nota2M4") %></td>
                <td><%= request.getAttribute("media4") %></td>
                <td><span class="status-aprovado"><%= request.getAttribute("situacao4") %></span></td>
            </tr>
        </tbody>
    </table>

    </div>
    <img src="../../../assets/imgs/meninasa.png" alt="meninasa" class="meninasa">
</div>

</body>
</html>