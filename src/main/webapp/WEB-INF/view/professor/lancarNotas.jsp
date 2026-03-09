<%@ page import="org.example.model.Aluno" %>
<%@ page import="org.example.model.Notas" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
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
            <form class="search" action="<%=request.getContextPath()%>/professor/lancarNotas" method="get">
                <button class="fa-solid fa-magnifying-glass" type="submit"></button>
                <input type="text" name="busca" placeholder="Buscar">
            </form>
        </div>

        <!-- TABELA -->
        <div class="table">
            <div class="table-header">
                <span>Nome do aluno</span>
                <span>Email do Usuário</span>
                <span>Nota 1</span>
                <span>Nota 2</span>
                <span>Média</span>
                <span>Ações</span>
            </div>

            <%
                List<Aluno> alunoList = (List<Aluno>) request.getAttribute("alunoList");
                Map<String, Notas> notasAlunos = (Map<String, Notas>) request.getAttribute("notasAlunos");

                if (alunoList == null || alunoList.isEmpty()) {
            %>
            <div class="table-row">
                <span>Não tem alunos cadastrados</span>
            </div>
            <%
            } else {
                for (Aluno aluno : alunoList) {
                    Notas notas = notasAlunos != null ? notasAlunos.get(aluno.getMatricula()) : null;
                    double nota1 = notas != null ? notas.getNota() : 0;
                    double nota2 = notas != null ? notas.getNota2() : 0;
                    double media = (nota1 + nota2) / 2;
            %>
            <div class="table-row">
                <span><%=aluno.getNome()%></span>
                <span><%=aluno.getEmail()%></span>
                <span><%=notas != null ? nota1 : "-"%></span>
                <span><%=notas != null ? nota2 : "-"%></span>
                <span><%=notas != null ? media : "-"%></span>
                <span class="edit"><i class="fa-solid fa-pen"></i></span>
            </div>
            <%
                    }
                }
            %>
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

<script src="<%=request.getContextPath()%>/assets/js/popup.js"></script>
</body>
</html>