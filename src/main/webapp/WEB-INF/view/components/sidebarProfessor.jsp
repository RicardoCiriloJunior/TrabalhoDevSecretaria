<%--
  Created by IntelliJ IDEA.
  User: ricardojunior-ieg
  Date: 08/03/2026
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%String path = request.getContextPath() + "/redirecionar?page=";
    String nome = (String) request.getAttribute("nomeProfessor");
%>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/professor/sidebarProfessor.css">
</head>
<body>
<!-- SIDEBAR -->
<aside class="sidebar">
  <h1 class="teacher">Professor</h1>

  <hr class="hr">

  <div class="user">
    <div class="avatar">
      <i class="fa-solid fa-user"></i>
    </div>
    <span><%=nome%></span>
  </div>

  <nav class="nav">
    <a class="nav-item ${param.tabActive == 'inicio' ? "active" : ""}" href="<%=path%>inicioProfessor"><i class="fa-solid fa-house"></i> Início</a>
    <a class="nav-item ${param.tabActive == 'lancarNotas' ? "active" : ""}" href="<%=path%>lancarNotasProfessor"><i class="fa-solid fa-pen"></i> Lançar notas</a>
    <a class="nav-item ${param.tabActive == 'enviarObs' ? "active" : ""}" href="<%=path%>enviarObsProfessor"><i class="fa-solid fa-envelope"></i> Enviar Observações</a>
  </nav>
</aside>
</body>
</html>
