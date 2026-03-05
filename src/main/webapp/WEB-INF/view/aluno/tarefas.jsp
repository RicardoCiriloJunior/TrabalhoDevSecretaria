<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/sidebarAluno.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/aluno/tarefas.css">
    <title>Tarefas - Aluno</title>
</head>
<body>

<jsp:include page="../components/sidebarAluno.jsp" >
    <jsp:param name="tabActive" value="tarefas"/>
</jsp:include>


<div class="main">

    <h1 class="titulo">Tarefas</h1>

    <div class="legenda">
        <span class="pendente"></span> Pendente
        <span class="concluida"></span> Concluída
        <span class="fora"></span> Fora do Prazo
    </div>

    <div class="tabela-container">
        <table>
            <thead>
                <tr>
                    <th colspan="3", class="tarefa">Tarefas</th>
                    <th class="editar">Editar ✏️</th>
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
                    <td></td>
                    <td></td>
                    <td>
                        <div class="card-verde">
                            <strong>FAZER PROVA <br>DE MATEMÁTICA</strong><br>
                            Entregar até dia: 05/02
                        </div>
                    </td>
                    <td></td>
                </tr>

                <tr>
                    <td>
                        <div class="card-vermelho">
                            <strong>FAZER QUIZ DE <br>PSICOLOGIA</strong><br>
                            Entregar até dia: 06/02
                        </div>
                    </td>
                    <td></td>
                    <td>
                        <div class="card-verde">
                            <strong>EXERCÍCIOS DO LIVRO</strong><br>
                            Entregar até dia: 04/02
                        </div>
                    </td>
                    <td></td>
                </tr>

                <tr>
                    <td></td>
                    <td>
                        <div class="card-amarelo">
                            <strong>GRAVAR ÁUDIO</strong><br>
                            Entregar até dia: 11/02
                        </div>
                    </td>
                    <td></td>
                    <td></td>

                </tr>

                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td><div class="card-amarelo">
                            <strong>FAZER <br>QUEBRA-CABEÇA</strong><br>
                            Entregar até dia: 15/02
                        </div></td>
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
    <img src="../../../assets/imgs/mike.png" alt="mike" class="mike">
</div>

<!-- Bloco de edição dos cards -->
<div id="modal-tarefa" class="bloco-edicao">
    <div class="modal-content">
        <h3>Nova Tarefa</h3>
        <div class="custom-select" id="select-materia">
            <div class="select-selected">Selecione a Matéria ˇ</div>
            <div class="select-items select-hide">
                <div>Psicologia do Medo Infantil</div>
                <div>Expressividade Vocal Avançada</div>
                <div>Engenharia de Sustos e Rendimento Energético</div>
                <div>Tecnologia de Portais Interdimensionais</div>
            </div>
        </div>
        <input type="text" id="input-titulo" placeholder="Título: Lição de susto">
        <input type="date" id="input-data">
        <div class="modal-botoes">
            <button id="btn-cancelar">Cancelar</button>
            <button id="btn-salvar">Salvar</button>
        </div>
    </div>
</div>

<!-- Balão do mike -->
<div id="mike-balão" class="mike-balão select-hide">
    <p id="mike-text"></p>
</div>

</body>
</html>