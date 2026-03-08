<%--
  Created by IntelliJ IDEA.
  User: ricardo.cirilo
  Date: 03/03/26
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String matricula = (String) session.getAttribute("matriculaAluno");
%>
<html>
<head>
    <title>Title</title>
    <script defer type="module" src="<%=request.getContextPath()%>/assets/js/gerenciarAtividadeFeita.js"></script>
</head>
<body>
    <div id="informacoes"
         style="position: fixed; right: 0; top: 0; opacity: 100%"
         data-matricula="<%=matricula%>"
         data-id_disciplina="${param.idDisciplina}"></div>
</body>
</html>
