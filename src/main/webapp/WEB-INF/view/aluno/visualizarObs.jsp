<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 04/03/2026
  Time: 07:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Observações do Professor</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/observacoesAluno.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="layout">

    <jsp:include page="WEB-INF/view/components/sidebarAluno.jsp" >
        <jsp:param name="tabActive" value="Observações"/>
    </jsp:include>
    <!-- CONTENT -->
    <main class="content">

        <h1>Observações</h1>

        <!-- FILTROS -->
        <div class="filters">
            <div class="search">
                <i class="fa-solid fa-magnifying-glass"></i>
                <input type="text" placeholder="Buscar observação...">
            </div>
        </div>

        <!-- CARDS -->

        <div class="card blue">
            <div class="card-header">
                <div>
                    <p>Professor: João Silva</p>
                </div>
                <div class="date">
                    15/02/2026
                </div>
            </div>

            <p class="message">
                Giovanna apresentou excelente desempenho na atividade sobre progressão geométrica. Continue assim!
            </p>

            <div class="card-footer">
                <button><i class="fa-solid fa-check"></i> Marcar como lida</button>
            </div>
        </div>

        <div class="card yellow">
            <div class="card-header">
                <div>
                    <p>Professor: Ana Pereira</p>
                </div>
                <div class="date">
                    10/02/2026
                </div>
            </div>

            <div class="alert">
                <i class="fa-solid fa-triangle-exclamation"></i>
                Giovanna estava desatenta durante a aula de hoje. Precisa melhorar a concentração.
            </div>

            <div class="card-footer">
                <button><i class="fa-solid fa-check"></i> Marcar como lida</button>
            </div>
        </div>

        <div class="card light">
            <div class="card-header">
                <div>
                    <p>Professor: Marcos Almeida</p>
                </div>
                <div class="date">
                    08/02/2026
                </div>
            </div>

            <p class="message">
                Giovanna fez um ótimo trabalho na redação sobre meio ambiente, demonstrando criatividade e coerência.
            </p>

            <div class="card-footer">
                <button><i class="fa-solid fa-check"></i> Marcar como lida</button>
            </div>
        </div>

    </main>
</div>

<script src="obs.js"></script>
</body>
</html>