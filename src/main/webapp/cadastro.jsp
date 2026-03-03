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
    <link rel="stylesheet" href="assets/cadastro.css">
</head>
<body>

<div class="container">

    <img src="${pageContext.request.contextPath}/assets/imgs/image%2013.png"
         alt="Monsters University Logo" class="logo">

    <h1>Cadastre-se!</h1>
    <p class="subtitle">Insira suas credenciais para criar sua conta.</p>


    <form action="cadastro" method="post">
        <input type="text" name="nome" placeholder="Nome Completo" required>
        <input type="text" name="cpf" placeholder="CPF" required>
        <input type="email" name="email" placeholder="Endereço de email" required>
        <input type="password" name="senha" placeholder="Senha" required>
        <input type="password" name="confirmarSenha" placeholder="Confirmar Senha" required>

        <button type="submit">Cadastre-se</button>
    </form>

</div>

</body>
</html>
