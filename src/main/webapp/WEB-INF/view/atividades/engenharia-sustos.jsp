<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Engenharia de Sustos e Rendimento Energético</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/atividades/engenharia-sustos.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <script type="module" src="<%=request.getContextPath()%>/assets/js/engenharia-sustos.js" defer></script>
</head>

<body>
<jsp:include page="../components/sidebarAluno.jsp">
    <jsp:param name="tabActive" value="materias"/>
</jsp:include>
<jsp:include page="../components/informacoesAtividade.jsp">
    <jsp:param name="idDisciplina" value="4"/>
</jsp:include>
    <main>
        <h1 class="title">Engenharia de Sustos e Rendimento Energético</h1>
        <section class="atividade-engenharia-container">
            <div id="atividade-header">
                <h2>Hora de apavorar!</h2>
                <span id="nota">
                </span>
            </div>
            <ol id="perguntas-container">
                <li class="pergunta">Um monstro novato coletou 500 litros de energia de grito, mas seu rendimento
                    caiu 10% por causa de uma tampa frouxa. Quantos litros sobraram no cilindro?</li>
                <li class="pergunta"> Sulley precisa assustar 12 crianças por hora para manter a meta da fábrica. Se ele
                    trabalhar por 8 horas, quantos sustos ele terá contabilizado?</li>
                <li class="pergunta">Mike Wazowski organizou 150 portas em 5 fileiras iguais no trilho suspenso. Quantas
                    portas existem em cada fileira?</li>
                <li class="pergunta">Para acender uma lâmpada em Monstrópolis, são necessários 20 litros de riso. Se o
                    monstro coletou 140 litros, quantas lâmpadas ele consegue manter acesas?</li>
                <li class="pergunta">Um susto nível "Alpha" rende 80 pontos, enquanto um "Beta" rende 50. Se o monstro
                    fizer 2 Alphas e 3 Betas, qual sua pontuação total?</li>
            </ol>
            <textarea name="resposta" id="resposta" cols="4"
                placeholder="Digite as respostas de cada pergunta, separando por ; (ponto e vírgula). Ex: &quot;123; 456; 789; 012; 345&quot;"></textarea>
            <button id="btn-finalizar" disabled>Finalizar</button>

        </section>
        <img src="../../../assets/imgs/bicho-azul.png" alt="bichinho" id="bichinho">
    </main>
</body>

</html>