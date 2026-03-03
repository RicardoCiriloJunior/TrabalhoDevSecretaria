<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link
        href="https://fonts.googleapis.com/css2?family=Instrument+Sans:ital,wght@0,400..700;1,400..700&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <script src="https://kit.fontawesome.com/4148abb434.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/quebra-cabeca.css">
    <script src="<%=request.getContextPath()%>/assets/js/quebra-cabeca.js"></script>

</head>

<body>
<jsp:include page="../components/sidebarAluno.jsp">
    <jsp:param name="tabActive" value="materias"/>
</jsp:include>
    <main>
        <h1 class="title">Tecnologia de Portais Interdimensionais</h1>
        <section class="atividade-puzzle-container">
            <div id="atividade-puzzle-header">
                <h2 id="titulo-puzzle">QUEBRA-CABEÇA</h2>
                <p id="notaFinal">Nota: <span id="nota">0</span></p>
            </div>
            <div id="quebra-cabeca-container">
                <section id="pecas-container">

                </section>
                <section id="resolucao-container">

                </section>
            </div>
            <div id="controle-puzzle">
                <button id="btn-iniciar">Iniciar</button>
                <span id="cronometro">00:00</span>
                <span id="tentativas">Tentativas: 2</span>
                <button id="btn-finalizar" disabled>Finalizar</button>
            </div>
        </section>
        <img src="../../../assets/imgs/quebra-cabeca.png" alt="sla" id="quebra-cabeca-fundo" style="display: none;">
        <img src="../../../assets/imgs/bichinho-puzzle.png" alt="bichinho" id="bichinho-puzzle">
    </main>
</body>

</html>