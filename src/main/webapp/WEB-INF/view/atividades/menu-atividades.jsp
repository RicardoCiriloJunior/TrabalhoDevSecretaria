<!DOCTYPE html>
<!-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> -->
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Atividades!</title>
<!--    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/style.css">-->
<!--    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/menu-atividades.css">-->
    <link rel="stylesheet" href="../../../assets/css/atividades/style.css">
    <link rel="stylesheet" href="../../../assets/css/atividades/menu-atividades.css">
    <link rel="stylesheet" href="../../../assets/css/sidebarAluno.css">
    <script src="../../../assets/js/menu-atividades.js"></script>
</head>

<body>
<aside class="sidebar">
    <h1 class="aluno">Aluno</h1>

    <hr class="hr">

    <div class="user">
        <div class="avatar">
            <i class="fa-solid fa-user"></i>
        </div>
        <span>Aluno</span>
    </div>

    <nav class="nav">
        <a class="sidebar-link " href="<%=redirectPath%>inicioAluno">Início</a>
        <a class="sidebar-link " href="<%=redirectPath%>boletimAluno" >Boletim</a>
        <a class="sidebar-link " href="<%=redirectPath%>tarefasAluno" >Tarefas</a>
        <a class="sidebar-link active" href="<%=redirectPath%>materiasAluno" >Matérias</a>
    </nav>
</aside>

<main>
        <h2 class="title">Matérias</h2>
        <div id="materias-container">
            <div class="materia" id="psicologia" data-pagina="psicologia-medo.html">
                <h3 class="titulo-materia">Psicologia do Medo Infantil</h3>
                <div class="descricao-imagem">
                    <p class="descricao-materia">Coloque em dia seus aprendizados de psicologia de medo infantil!</p>
                    <div class="img-container"><img src="../../../assets/imgs/bichinho-quiz.png" alt="bichinho lendo"
                            id="bichinho-lendo" class="imagem-materia"></div>
                </div>
            </div>
            <div class="materia" id="expressividade" data-pagina="expressividade-vocal.html">
                <h3 class="titulo-materia">Expressividade Vocal Avançada</h3>
                <div class="descricao-imagem">
                    <p class="descricao-materia">Mostre suas habilidades no grito bem alto!!</p>
                    <div class="img-container"><img src="../../../assets/imgs/bichinho-verde.png"
                            alt="bichinho-gritando" class="imagem-materia"></div>
                </div>
            </div>
            <div class="materia" id="tecnologia" data-pagina="quebra-cabeca.html">
                <h3 class="titulo-materia">Tecnologia de Portais Interdimensionais</h3>
                <div class="descricao-imagem">
                    <p class="descricao-materia">Monte sua própria porta interdimensional!</p>
                    <div class="img-container"><img src="../../../assets/imgs/bichinho-puzzle.png" alt="bichinho-porta"
                            class="imagem-materia"></div>
                </div>
            </div>
            <div class="materia" id="engenharia" data-pagina="engenharia-sustos.html">
                <h3 class="titulo-materia">Engenharia de Sustos e Rendimento Energético </h3>
                <div class="descricao-imagem">
                    <p class="descricao-materia">Teste seus conhecimentos sobre o rendimento de energia nos gritos!</p>
                    <div class="img-container"><img src="../../../assets/imgs/bicho-azul.png" alt="bichinho-azul"
                            class="imagem-materia"></div>
                </div>
            </div>
        </div>
    </main>
</body>

</html>