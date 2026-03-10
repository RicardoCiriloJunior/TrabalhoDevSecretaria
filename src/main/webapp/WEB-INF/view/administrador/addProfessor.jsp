<%@ page import="org.example.model.Professor" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Admin - Professores</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/addProfessor.css">
    <script src="https://kit.fontawesome.com/4148abb434.js" crossorigin="anonymous"></script>
</head>
<body>
<%
    List<Professor> professores = (List<Professor>) request.getAttribute("professores");
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
        <h1 class="titulo-sessao">Professores</h1>

        <div class="quadro-quantidade">
            <span class="legenda-quantidade">Quantidade de professores</span>
            <h2 class="numero-professores"><%=professores.size()%></h2>
        </div>

        <div class="barra-ferramentas">
            <form action="/admin/professores" class="caixa-pesquisa" method="get">
                <i class="fa-solid fa-magnifying-glass"></i>
                <button hidden="hidden" type="submit"></button>
                <input type="text" name="busca" placeholder="Buscar">
            </form>
            <button class="botao-adicionar">+ Adicionar novo professor</button>
        </div>

        <div class="container-tabela">
            <table class="tabela-professores">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do professores</th>
                        <th>Email do professor</th>
                        <th>ID da Disciplina</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Professor professor : professores) {
                    %>
                    <tr>
                        <td><%=professor.getId()%></td>
                        <td><%=professor.getNome()%></td>
                        <td><%=professor.getEmail()%></td>
                        <td><%=professor.getId_disciplina()%></td>
                        <td>
                            <span class="delete-button" data-id="<%=professor.getId()%>" data-nome="<%=professor.getNome()%>">🗑️</span>
                            <span class="edit-button"
                                  data-id="<%=professor.getId()%>"
                                  data-nome="<%=professor.getNome()%>"
                                  data-email="<%=professor.getEmail()%>"
                                  data-disciplina="<%=professor.getId_disciplina()%>">
                                ✏️
                            </span>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </main>
<div id="modalProfessor" class="modal">
    <div class="modal-content">

        <h2>Novo Professor</h2>

        <form id="formProfessor">

            <label for="nome">Nome</label>
            <input id="nome" type="text" name="nome" placeholder="Nome" required>

            <label for="email">Email</label>
            <input id="email" type="email" name="email" placeholder="Email" required>

            <label for="senha">Senha</label>
            <input id="senha" type="password" name="senha" placeholder="Senha" required>

            <label for="cpf">CPF</label>
            <input id="cpf" type="text" name="cpf" placeholder="CPF" required>

            <label for="id_disciplina">ID da Disciplina</label>
            <input id="id_disciplina" type="number" name="id_disciplina" placeholder="ID Disciplina" required>

            <div class="modal-buttons">
                <button type="button" id="cancelProfessor">Cancelar</button>
                <button type="submit" id="saveProfessor">Salvar</button>
            </div>

        </form>

    </div>
</div>
<div id="modalEditarProfessor" class="modal">
    <div class="modal-content">

        <h2>Editar Professor</h2>

        <form id="formEditarProfessor">

            <input type="hidden" name="id" id="edit_id">

            <label for="edit_nome">Nome</label>
            <input id="edit_nome" type="text" name="nome" placeholder="Nome" required>

            <label for="edit_email">Email</label>
            <input id="edit_email" type="email" name="email" placeholder="Email" required>

            <label for="edit_disciplina">ID da Disciplina</label>
            <input id="edit_disciplina" type="number" name="id_disciplina" placeholder="ID Disciplina" required>

            <div class="modal-buttons">
                <button type="button" id="cancelEditProfessor">Cancelar</button>
                <button type="submit">Atualizar</button>
            </div>

        </form>

    </div>
</div>
<div id="modalExcluirProfessor" class="modal">
    <div class="modal-content">

        <h2>Excluir Professor</h2>

        <p id="textoExcluirProfessor"></p>

        <form id="formExcluirProfessor">

            <input type="hidden" id="delete_id" name="id">

            <div class="modal-buttons">
                <button type="button" id="cancelDeleteProfessor">Cancelar</button>
                <button type="submit" id="btn-excluir">Confirmar</button>
            </div>

        </form>

    </div>
</div>
<script>
    const contextPath = "<%=request.getContextPath()%>"
</script>
<script src="<%=request.getContextPath()%>/assets/js/addProfessorPopup.js"></script>
</body>
</html>
