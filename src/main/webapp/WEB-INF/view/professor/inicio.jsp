<%--
  Created by IntelliJ IDEA.
  User: giovannaveloso-ieg
  Date: 01/03/2026
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Painel do Professor</title>
  <link rel="stylesheet" href="../../../assets/css/professor/inicio.css">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<div class="layout">

  <!-- SIDEBAR -->
  <aside class="sidebar">
    <h1 class="teacher">Professor</h1>

    <hr class="@WebServlet("/Alunoes")hr">

    <div class="user">
      <div class="avatar">
        <i class="fa-solid fa-user"></i>
      </div>
      <span>Administrador</span>
    </div>

    <nav class="nav">
      <a class="active"><i class="fa-solid fa-house"></i> Início</a>
      <a class="active"><i class="fa-solid fa-pen"></i> Lançar notas</a>
      <a class="active"><i class="fa-solid fa-envelope"></i> Enviar Observações</a>
    </nav>
  </aside>

  <!-- CONTEÚDO -->
  <main class="content">

    <h1>Início</h1>
    <p class="welcome">Bem vindo, professor!</p>

    <!-- CARDS SUPERIORES -->
    <div class="cards">

      <div class="card blue">
        <div class="card-header">
          <i class="fa-solid fa-graduation-cap"></i>
          <span>Alunos</span>
        </div>
        <h2>30</h2>
      </div>

      <div class="card green">
        <div class="card-header">
          <i class="fa-solid fa-book"></i>
          <span>Obs enviadas</span>
        </div>
        <h2>3</h2>
      </div>

      <div class="card yellow">
        <div class="card-header">
          <i class="fa-solid fa-star"></i>
          <span>Média Geral</span>
        </div>
        <h2>7.6</h2>
      </div>

      <div class="card red">
        <div class="card-header">
          <i class="fa-solid fa-file"></i>
          <span>Recuperações</span>
        </div>
        <h2>2</h2>
      </div>

    </div>

    <!-- OBSERVAÇÕES + CALENDÁRIO -->
    <div class="bottom">

      <h2 class="section">Visualizar observações</h2>

      <div class="observations">

        <div class="obs-card">
          <h4>Giovanna Medeiros Veloso</h4>
          <p><i class="fa-solid fa-comment"></i> Participação ativa em sala de aula</p>
          <small><i class="fa-solid fa-calendar"></i> 08/02/2026 - 08:00</small>
        </div>

        <div class="obs-card">
          <h4>Luis Henrique Medeiros</h4>
          <p><i class="fa-solid fa-comment"></i> Participação ativa em sala de aula</p>
          <small><i class="fa-solid fa-calendar"></i> 08/02/2026 - 08:00</small>
        </div>

        <div class="obs-card">
          <h4>Luis Henrique Medeiros</h4>
          <p><i class="fa-solid fa-comment"></i> Participação ativa em sala de aula</p>
          <small><i class="fa-solid fa-calendar"></i> 08/02/2026 - 08:00</small>
        </div>

        <div class="obs-card">
          <h4>Luis Henrique Medeiros</h4>
          <p><i class="fa-solid fa-comment"></i> Participação ativa em sala de aula</p>
          <small><i class="fa-solid fa-calendar"></i> 08/02/2026 - 08:00</small>
        </div>

        <div class="obs-card">
          <h4>Luis Henrique Medeiros</h4>
          <p><i class="fa-solid fa-comment"></i> Participação ativa em sala de aula</p>
          <small><i class="fa-solid fa-calendar"></i> 08/02/2026 - 08:00</small>
        </div>

      </div>

    </div>

  </main>

</div>

</body>
</html>
