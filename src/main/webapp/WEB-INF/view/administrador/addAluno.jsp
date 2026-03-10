<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Admin - Professores</title>
    <link rel="stylesheet" href="assets/css/addAluno.css">
</head>
<body>

    <header class="cabecalho-admin">
        <div class="logo">
            <img src="assets/imgs/MmonstrosSA.png" alt="Logo Monstros" class="logo-redonda">
        </div>
        <nav class="navegacao-admin">
            <a href="<%=request.getContextPath()%>/redirecionar?page=addAlunoAdmin" class="item-ativo">Alunos</a>
            <a href="<%=request.getContextPath()%>/redirecionar?page=addProfessor">Professores</a>
        </nav>
    </header>

    <main class="conteudo-principal">
        <h1 class="titulo-sessao">Alunos</h1>

        <div class="quadro-quantidade">
            <span class="legenda-quantidade">Quantidade de Alunos</span>
            <h2 class="numero-professores">88</h2>
        </div>

        <div class="barra-ferramentas">
            <div class="caixa-pesquisa">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" placeholder="Buscar">
            </div>
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
                    <tr>
                        <td>Giovanna Medeiros Veloso</td>
                        <td>giovanna.veloso@gmail.com</td>
                        <td>65456787656</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>Davi Dias</td>
                        <td>davi.dias@gmail.com</td>
                        <td>8765678987</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>Daniel Zanqueta</td>
                        <td>daniel.zanqueta@gmail.com</td>
                        <td>76545678765</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>Murilo Rosa</td>
                        <td>murilo.rosa@gmail.com</td>
                        <td>87656787678</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <div class="paginacao">
            <button class="botao-pag"><</button>
            <button class="botao-pag pagina-ativa">1</button>
            <button class="botao-pag">></button>
        </div>
    </main>

</body>
</html>
