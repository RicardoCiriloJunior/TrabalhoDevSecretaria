<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/inicio.css">
    <title>Início - Aluno</title>
</head>
<body>

<jsp:include page="../components/sidebarAluno.jsp" >
    <jsp:param name="tabActive" value="inicio"/>
</jsp:include>

<div class="main">

    <div class="topo">
        <h1>Horários</h1>
    </div>

    <div class="tabela-container">
        <table>
            <thead>
                <tr>
                    <th>Segunda-Feira</th>
                    <th>Terça-Feira</th>
                    <th>Quarta-Feira</th>
                    <th>Quinta-Feira</th>
                    <th>Sexta-Feira</th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>Psicologia do Medo Infantil<br>7:00-7:50</td>
                    <td>Expressividade Vocal Avançada<br>7:00-7:50</td>
                    <td>Engenharia de Sustos e Rendimento Energético<br>7:00-7:50</td>
                    <td>Tecnologia de Portais Interdimensionais<br>7:00-7:50</td>
                    <td>Expressividade Vocal Avançada<br>7:00-7:50</td>
                </tr>

                <tr>
                    <td>Engenharia de Sustos e Rendimento Energético<br>7:50-8:40</td>
                    <td>Psicologia do Medo Infantil<br>7:50-8:40</td>
                    <td>Expressividade Vocal Avançada<br>7:50-8:40</td>
                    <td>Engenharia de Sustos e Rendimento Energético<br>7:50-8:40</td>
                    <td>Tecnologia de Portais Interdimensionais<br>7:50-8:40</td>
                </tr>

                <tr class="intervalo">
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                    <td>-</td>
                </tr>

                <tr>
                    <td>Tecnologia de Portais Interdimensionais<br>8:40-9:30</td>
                    <td>Engenharia de Sustos e Rendimento Energético<br>8:40-9:30</td>
                    <td>Psicologia do Medo Infantil<br>8:40-9:30</td>
                    <td>Expressividade Vocal Avançada<br>8:40-9:30</td>
                    <td>Engenharia de Sustos e Rendimento Energético<br>8:40-9:30</td>
                </tr>


                <tr>
                    <td>Engenharia de Sustos e Rendimento Energético<br>10:00-10:50</td>
                    <td>Tecnologia de Portais Interdimensionais<br>10:00-10:50</td>
                    <td>Engenharia de Sustos e Rendimento Energético<br>10:00-10:50</td>
                    <td>Psicologia do Medo Infantil<br>10:00-10:50</td>
                    <td>Expressividade Vocal Avançada<br>10:00-10:50</td>
                </tr>


            </tbody>
        </table>
    </div>
    <img src="../../../assets/imgs/invisivel.png" alt="invisivel" class="invisivel">
</div>

</body>
</html>