<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Expressividade Vocal Avançada</title>
    <script src="<%=request.getContextPath()%>/assets/js/timer.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/CalculoNota.js"></script>
    <script type="module" src="<%=request.getContextPath()%>/assets/js/audio.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/expressividade-vocal.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Instrument+Sans:ital,wght@0,400..700;1,400..700&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
</head>

<body>
<jsp:include page="../components/sidebarAluno.jsp">
    <jsp:param name="tabActive" value="materias"/>
</jsp:include>
    <main>
        <h1 class="title">Expressividade Vocal Avançada</h1>
        <section class="atividade-container">
            <div id="atividade-header">
                <h2>GRAVE SEU ÁUDIO</h2>
                <div id="notaFinal-container">
                    <p class="metade-espaco">NOTA FINAL:</p>
                    <p id="notaFinal" class="metade-espaco">-/-</p>
                </div>
            </div>
            <div id="timer">00:10</div>
            <p id="descricao">OBS: Você terá apenas 2 chances!
                Grite o mais alto e assustador que conseguir <b>antes do tempo acabar</b>! <br>
                Tentativas restantes: <b><span id="tentativas"></span></b>
            </p>
            <div id="botoes-container">
                <button id="play" class="btn btn-comecar">Gravar</button>
                <button id="stop" class="btn btn-finalizar" disabled>Finalizar</button>
            </div>
        </section>
        <img src="../../../assets/imgs/bichinho-verde.png" alt="bichinho" id="bichinho">
    </main>
</body>

</html>