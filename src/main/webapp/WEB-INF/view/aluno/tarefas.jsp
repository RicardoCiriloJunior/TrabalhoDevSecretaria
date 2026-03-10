<%@ page import="org.example.model.Atividades" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/tarefas.css">
    <title>Tarefas - Aluno</title>
</head>
<body>

<jsp:include page="../components/sidebarAluno.jsp">
    <jsp:param name="tabActive" value="tarefas"/>
</jsp:include>

<div class="main">

    <h1 class="titulo">Tarefas</h1>

    <div class="legenda">
        <span class="pendente"></span> Em Andamento
        <span class="concluida"></span> Finalizado
        <span class="fora"></span> Não Iniciado
    </div>

    <div class="tabela-container">
        <table>
            <thead>
            <tr>
                <th colspan="3" class="tarefa">Tarefas</th>
                <th class="editar">Criar ✏️</th>
            </tr>
            </thead>
            <tbody>
            <tr class="materias">
                <td>Psicologia do <br>Medo Infantil</td>
                <td>Expressividade Vocal<br> Avançada</td>
                <td>Engenharia de Sustos<br> e <br>Rendimento Energético</td>
                <td>Tecnologia <br>de Portais<br> Interdimensionais</td>
            </tr>
            <tr>

                <td>
                    <%
                        List<Atividades> psicologia = (List<Atividades>) request.getAttribute("psicologia");

                        if(psicologia != null){
                            for(Atividades a : psicologia){
                    %>
                    <div>
                        <p><strong><%= a.getTitulo() %></strong></p>
                        <p>Entregar até dia: <%= a.getDataEntrega() %></p>
                    </div>
                    <%
                            }
                        }
                    %>
                </td>

                <td>
                    <%
                        List<Atividades> expressividade = (List<Atividades>) request.getAttribute("expressividade");

                        if(expressividade != null){
                            for(Atividades a : expressividade){
                    %>
                    <div>
                        <p><strong><%= a.getTitulo() %></strong></p>
                        <p>Entregar até dia: <%= a.getDataEntrega() %></p>
                    </div>
                    <%
                            }
                        }
                    %>
                </td>

                <td>
                    <%
                        List<Atividades> engenharia = (List<Atividades>) request.getAttribute("engenharia");

                        if(engenharia != null){
                            for(Atividades a : engenharia){
                    %>
                    <div>
                        <p><strong><%= a.getTitulo() %></strong></p>
                        <p>Entregar até dia: <%= a.getDataEntrega() %></p>
                    </div>
                    <%
                            }
                        }
                    %>
                </td>

                <td>
                    <%
                        List<Atividades> tecnologia = (List<Atividades>) request.getAttribute("tecnologia");

                        if(tecnologia != null){
                            for(Atividades a : tecnologia){
                    %>
                    <div>
                        <p><strong><%= a.getTitulo() %></strong></p>
                        <p>Entregar até dia: <%= a.getDataEntrega() %></p>
                    </div>
                    <%
                            }
                        }
                    %>
                </td>

            </tr>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </tbody>
        </table>
    </div>

    <div id="mike-container">
        <img src="../../../assets/imgs/mike.png" alt="mike" class="mike">
        <div id="mike-balao" class="mike-balao select-hide">
            <p id="mike-text"></p>
        </div>
    </div>
</div>

<!-- MODAL -->
<div id="modal-tarefa" class="bloco-edicao">
    <form class="modal-content">
        <h3>Nova Tarefa</h3>
        <select id="selecao-materia" name="materia">
            <option value="" disabled selected>Selecione a matéria</option>
            <option value="2">Psicologia do Medo Infantil</option>
            <option value="3">Expressividade Vocal Avançada</option>
            <option value="4">Engenharia de Sustos</option>
            <option value="1">Tecnologia de Portais</option>
        </select>

        <select id="selecao-status" name="urgencia">
            <option value="" disabled selected>Selecione o status</option>
            <option value="verde">Finalizado</option>
            <option value="amarelo">Em Andamento</option>
            <option value="vermelho">Não Iniciado</option>
        </select>

        <input type="text" id="input-titulo" placeholder="Título: Lição de susto" name="titulo">
        <input type="text" id="input-descricao" placeholder="Descrição: praticar sustos" name="descricao">
        <input type="date" id="input-data" name="data">

        <div class="modal-botoes">
            <button id="btn-cancelar" name="acao" value="cancelar">Cancelar</button>
            <button id="btn-salvar" type="submit" name="acao" value="confirmar">Salvar</button>
        </div>
    </form>
</div>

<script src="<%=request.getContextPath()%>/assets/js/tarefas.js"></script>
</body>
</html>