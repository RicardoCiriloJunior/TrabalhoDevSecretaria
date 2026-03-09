<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 04/03/2026
  Time: 07:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Enviar Observação</title>
    <link rel="stylesheet" href="../../../assets/css/professor/enviarObs.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
</head>
<body>

<div class="layout">

    <jsp:include page="../components/sidebarProfessor.jsp">
        <jsp:param name="tabActive" value="enviarObs"/>
    </jsp:include>

    <!-- CONTEÚDO -->
    <main class="content">

        <div class="top">
            <div class="titles">
                <h1>Enviar uma observação</h1>
                <p>Insira os dados para enviar a observação</p>
            </div>
        </div>

        <div class="container">

            <!-- CARD -->
            <div class="card">
                <h2>Observação</h2>

                <label>Nome</label>
                <input type="text" placeholder="Digite o nome do aluno">



                <label>Observação</label>
                <textarea placeholder=""></textarea>

                <button>Enviar</button>
            </div>

            <!-- IMAGEM -->
            <div class="image-area">
                <img src="/assets/imgs/image%208%20(1).png" alt="personagem">
            </div>

        </div>

    </main>

</div>

</body>
</html>
