<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Painel Admin - Professores</title>
    <link rel="stylesheet" href="assets/css/addProfessor.css">
</head>
<body>

    <header class="cabecalho-admin">
        <div class="logo">
            <img src="assets/imgs/MmonstrosSA.png" alt="Logo Monstros" class="logo-redonda">
        </div>
        <nav class="navegacao-admin">
            <a href="WEB-INF\view\aluno\inicio.jsp">Alunos</a>
            <a href="WEB-INF\view\professor\inicio.jsp" class="item-ativo">Professores</a>
        </nav>
    </header>

    <main class="conteudo-principal">
        <h1 class="titulo-sessao">Professores</h1>

        <div class="quadro-quantidade">
            <span class="legenda-quantidade">Quantidade de professores</span>
            <h2 class="numero-professores">30</h2>
        </div>

        <div class="barra-ferramentas">
            <div class="caixa-pesquisa">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" placeholder="Buscar">
            </div>
            <button class="botao-adicionar">+ Adicionar novo professor</button>
        </div>

        <div class="container-tabela">
            <table class="tabela-professores">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome do professores</th>
                        <th>Email do professor</th>
                        <th>Disciplina</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>1</td>
                        <td>Giovanna Medeiros Veloso</td>
                        <td>giovanna.veloso@gmail.com</td>
                        <td>Psicologia do Medo Infantil</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Davi Dias</td>
                        <td>davi.dias@gmail.com</td>
                        <td>Expressividade Vocal Avançada</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Daniel Zanqueta</td>
                        <td>daniel.zanqueta@gmail.com</td>
                        <td>Engenharia de Sustos e Rendimento Energético</td>
                        <td>🗑️</td> <td>✏️</td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Murilo Rosa</td>
                        <td>murilo.rosa@gmail.com</td>
                        <td>Tecnologia de Portais Interdimensionais</td>
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
