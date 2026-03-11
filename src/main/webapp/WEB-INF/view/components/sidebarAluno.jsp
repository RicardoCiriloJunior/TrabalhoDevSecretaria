<%--
  Created by IntelliJ IDEA.
  User: ricardo.cirilo
  Date: 02/03/26
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String redirectPath = request.getContextPath() + "/redirecionar?page=";

    String nome = (String) session.getAttribute("alunoNome");

%>
<html>
<header>
    <script src="https://kit.fontawesome.com/4148abb434.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
</header>
<aside class="sidebar">
    <h1 class="aluno">Aluno</h1>

    <hr class="hr">

    <div class="user">
        <div class="avatar">
            <i class="fa-solid fa-user"></i>
        </div>
        <span><%=nome%></span>
    </div>

    <nav class="nav">
        <a class="sidebar-link ${param.tabActive == 'inicio' ? "active" : ""}" href="<%=redirectPath%>inicioAluno">Início</a>
        <a class="sidebar-link ${param.tabActive == 'boletim' ? "active" : ""}" href="<%=request.getContextPath()%>/aluno/boletim" >Boletim</a>
        <a class="sidebar-link ${param.tabActive == 'tarefas' ? "active" : ""}" href="<%=request.getContextPath()%>/aluno/exibir-tarefas" >Tarefas</a>
        <a class="sidebar-link ${param.tabActive == 'materias' ? "active" : ""}" href="<%=redirectPath%>materiasAluno" >Matérias</a>
        <a class="sidebar-link ${param.tabActive == 'visualizarObs' ? "active" : ""}" href="<%=request.getContextPath()%>/aluno/visualizarObs">Observações</a>
    </nav>
</aside>
</html>
