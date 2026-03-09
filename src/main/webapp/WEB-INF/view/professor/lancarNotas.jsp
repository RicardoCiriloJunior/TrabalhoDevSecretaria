<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 04/03/2026
  Time: 07:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Lançar Notas</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/professor/lancarNotas.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="layout">

    <!-- SIDEBAR -->
    <jsp:include page="../components/sidebarProfessor.jsp">
        <jsp:param name="tabActive" value="lancarNotas"/>
    </jsp:include>

    <!-- CONTEÚDO -->
    <main class="content">

        <h1>Lançar notas</h1>

        <!-- CARD QUANTIDADE -->
        <div class="info-card">
            <p>Quantidade de alunos</p>
            <h2>${totalAlunos}</h2>
        </div>

        <!-- TÍTULO + BUSCA -->
        <div class="top-table">
            <h3>Alunos</h3>

            <div class="search">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" placeholder="Buscar">
            </div>
        </div>

        <!-- TABELA -->
        <div class="table">

            <div class="table-header">
                <span>Matrícula</span>
                <span>Nome do aluno</span>
                <span>Email do Usuário</span>
                <span>Média</span>
                <span>Ações</span>
            </div>

            <!-- Exemplo estático (igual seu HTML original) -->
            <div class="table-row">
                <span>iwxsbuwb7ge3zge78ws9h9dsh29hd</span>
                <span>Giovanna Medeiros Veloso</span>
                <span>giovanna.veloso@gmail.com</span>
                <span>10</span>
                <span class="edit"><i class="fa-solid fa-pen"></i></span>
            </div>

            <div class="table-row">
                <span>iwxsbuwb7ge3zge78ws9h9dsh29hd</span>
                <span>Davi Dias</span>
                <span>davi.dias@gmail.com</span>
                <span>7</span>
                <span class="edit"><i class="fa-solid fa-pen"></i></span>
            </div>

        </div>

        <!-- MODAL -->
        <div class="modal" id="gradeModal">

            <div class="modal-content">
                <h2>Lançar Nota</h2>

                <input type="number" id="gradeInput" placeholder="Digite a nota" min="0" max="10">

                <div class="modal-buttons">
                    <button class="cancel" id="cancelBtn">Cancelar</button>
                    <button class="save" id="saveBtn">Salvar</button>
                </div>
            </div>

        </div>

    </main>

</div>

<script src="/assets/js/popup.js"></script>
</body>
</html>