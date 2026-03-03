<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Psicologia do Medo Infantil</title>
    <link
        href="https://fonts.googleapis.com/css2?family=Instrument+Sans:ital,wght@0,400..700;1,400..700&family=Roboto:ital,wght@0,100..900;1,100..900&display=swap"
        rel="stylesheet">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/psicologia-medo.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <script src="https://kit.fontawesome.com/4148abb434.js" crossorigin="anonymous"></script>
    <script type="module" src="<%=request.getContextPath()%>/assets/js/quiz-psicologia.js"></script>
</head>

<body>
<jsp:include page="../components/sidebarAluno.jsp">
    <jsp:param name="tabActive" value="materias"/>
</jsp:include>
    <main>
        <h1 class="title">Psicologia do Medo Infantil</h1>
        <section class="atividade-quiz-container">
            <div id="atividade-quiz-header">
                <p id="pergunta-atual">3/10</p>
                <h2 id="titulo-quiz">QUIZ</h2>
            </div>
            <div id="quiz-container">
                <p id="pergunta">Quais dessas fobias NÃO são comuns em crianças?</p>
                <div id="alternativas-container">
                    <button class="btn-alternativa" value="a">A) <span class="alternativa">Realismo Nominal</span></button>
                    <button class="btn-alternativa" value="b">B) <span class="alternativa">Pensamento Mágico</span></button>
                    <button class="btn-alternativa" value="c">C) <span class="alternativa">Ansiedade de Separação</span></button>
                    <button class="btn-alternativa" value="d">D) <span class="alternativa">Dissonância Cognitiva</span></button>
                </div>
            </div>
            <div id="trocar-pergunta-container">
                <button id="voltar-pergunta" class="btn-trocar">
                    <i class="fa-solid fa-arrow-left"></i> <span>Anterior</span>
                </button>
                <button id="avancar-pergunta" class="btn-trocar">
                    <span>Próxima</span> <i class="fa-solid fa-arrow-right"></i>
                </button>
                <button class="btn-trocar" id="btn-finalizar">Finalizar</button>
            </div>

        </section>
        <img src="../../../assets/imgs/bichinho-quiz.png" alt="bichinho" id="bichinho-quiz">
    </main>
</body>

</html>