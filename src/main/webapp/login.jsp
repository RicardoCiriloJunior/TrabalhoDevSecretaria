<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 01/03/2026
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login - Monsters University</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css"></head>
<body>

<div class="container">

    <img src="${pageContext.request.contextPath}/assets/imgs/image%2013.png"
         alt="Monsters University Logo" class="logo">

    <h1>Bem-Vindo(a)!</h1>
    <p class="subtitle">Insira suas credenciais para acessar sua conta.</p>

    <form action="<%= request.getContextPath()%>/login" method="post">
        <input type="email" name="email" placeholder="Endereço de email" required>
        <input type="password" name="senha" placeholder="Senha" required>

        <% if (request.getAttribute("erroLogin") != null) { %>
        <div class="erro-mensagem">
            <%= request.getAttribute("erroLogin") %>
        </div>
        <% } %>
        <button type="submit">Login</button>

        <div class="links">
            <a href="cadastro.jsp">Crie uma conta</a>
            <a href="admLogin.jsp">É um administrador?</a>
        </div>
    </form>

</div>

</body>
</html>
