<%@ page import="org.example.model.Aluno" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Admin - Professores</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/addAluno.css">
    <script src="https://kit.fontawesome.com/4148abb434.js" crossorigin="anonymous"></script>

</head>
<body>
<%
    List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
%>

    <header class="cabecalho-admin">
        <div class="logo">
            <img src="<%=request.getContextPath()%>/assets/imgs/MmonstrosSA.png" alt="Logo Monstros" class="logo-redonda">
        </div>
        <nav class="navegacao-admin">
            <a href="<%=request.getContextPath()%>/admin/alunos" class="item-ativo">Alunos</a>
            <a href="<%=request.getContextPath()%>/admin/professores">Professores</a>
        </nav>
    </header>

    <main class="conteudo-principal">
        <h1 class="titulo-sessao">Alunos</h1>

        <div class="quadro-quantidade">
            <span class="legenda-quantidade">Quantidade de Alunos</span>
            <h2 class="numero-professores"><%=alunos.size()%></h2>
        </div>

        <div class="barra-ferramentas">
            <form class="caixa-pesquisa" action="/admin/alunos">
                <i class="fa-solid fa-magnifying-glass"></i>
                <button type="submit" hidden="hidden"></button>
                <input type="text" name="busca" placeholder="Buscar">
            </form>
        </div>

        <div class="container-tabela">
            <table class="tabela-professores">
                <thead>
                    <tr>
                        <th>Nome do Aluno</th>
                        <th>Email do Aluno</th>
                        <th>CPF</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Aluno aluno : alunos) {
                    %>
                        <tr>
                            <td><%=aluno.getNome()%></td>
                            <td><%=aluno.getEmail()%></td>
                            <td><%=aluno.getCpf()%></td>
                            <td>
                                <span class="delete-button">🗑️</span>
                                <span class="edit-button">✏️</span>
                            </td>
                        </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </main>

</body>
</html>
