<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 01/03/2026
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro - Monsters University</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/cadastro.css">
</head>
<body>

<div class="container">

    <img src="${pageContext.request.contextPath}/assets/imgs/image%2013.png"
         alt="Monsters University Logo" class="logo">

    <h1>Cadastre-se!</h1>
    <p class="subtitle">Insira suas credenciais para criar sua conta.</p>


    <form action="cadastro" method="post">
        <input type="text" name="nome" placeholder="Nome Completo"
               value="<%= request.getAttribute("nome") != null ? request.getAttribute("nome") : "" %>"
               required />
        <input
                type="text"
                name="cpf"
                placeholder="CPF"
                class="<%= request.getAttribute("erroCpf") != null ? "input-erro" : "" %>"
                value="<%= request.getAttribute("cpf") != null ? request.getAttribute("cpf") : "" %>"
                required />
        <% if (request.getAttribute("erroCpf") != null) { %>
        <div class="erro-mensagem">
            <%= request.getAttribute("erroCpf") %>
        </div>
        <% } %>
        <input
                type="email"
                name="email"
                placeholder="Email"
                class="<%= request.getAttribute("erroEmail") != null ? "input-erro" : "" %>"
                value="<%= request.getAttribute("email") != null ? request.getAttribute("email") : "" %>"
                required />
        <% if (request.getAttribute("erroEmail") != null) { %>
        <div class="erro-mensagem">
            <%= request.getAttribute("erroEmail") %>

        </div>
        <% } %>
        <input
                type="password"
                name="senha"
                placeholder="Digite sua senha: "
                class="<%= request.getAttribute("erroSenha") != null ? "input-erro" : "" %>"
                value="<%= request.getAttribute("senha") != null ? request.getAttribute("senha") : "" %>"
                required />
        <% if (request.getAttribute("erroSenha") != null) { %>
        <div class="erro-mensagem">
            <%= request.getAttribute("erroSenha") %>
        </div>
        <% } %>
        <input type="password" name="confirmarSenha" placeholder="Confirmar Senha" required>

        <button type="submit">Cadastre-se</button>
    </form>

</div>

</body>
</html>
