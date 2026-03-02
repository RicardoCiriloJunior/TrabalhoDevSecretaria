<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/boletim.css">
    <title>Boletim - Aluno</title>
</head>
<body>

<aside class="sidebar">
        <h1 class="aluno">Aluno</h1>

        <hr class="hr">

        <div class="user">
            <div class="avatar">
                <i class="fa-solid fa-user"></i>
            </div>
            <span>Aluno</span>
        </div>

        <nav class="nav">
            <a class="active", href="inicio.jsp">Início</a>
            <a class="active", href="boletim.html" >Boletim</a>
            <a class="active", href="tarefas.html" >Tarefas</a>
            <a class="active", href="" >Matérias</a>
        </nav>
 </aside>

<div class="main">
    <div class="card">
        <div class="titulo">Boletim Escolar</div>

    <div class="info-aluno">
        <div class="col-esquerda">
            <p><strong>ALUNO(A):</strong> Gabriella Rodrigues Reis Silva</p>
            <p><strong>TURMA:</strong> 2ª Série I Tech</p>
        </div>
        <div class="col-direita">
            <p><strong>ANO LETIVO:</strong> 2026</p>
            <p><strong>SITUAÇÃO FINAL:</strong> <span class="status-destaque">Aprovado</span></p>
        </div>
    </div>

    <table>
        <thead>
            <tr>
                <th>Disciplina</th>
                <th>1º Sem</th>
                <th>2º Sem</th>
                <th>Média</th>
                <th>Situação</th>
            </tr>
        </thead>

        <tbody>
            <tr>
                <td>Psicologia do Medo Infantil</td>
                <td>7.5</td>
                <td>8.35</td>
                <td>8.06</td>
                <td><span class="status-aprovado">Aprovado</span></td>
            </tr>

            <tr>
                <td>Expressividade Vocal Avançada</td>
                <td>9.75</td>
                <td>9.15</td>
                <td>9.35</td>
                <td><span class="status-aprovado">Aprovado</span></td>
            </tr>

            <tr>
                <td>Engenharia de Sustos e Rendimento Energético</td>
                <td>8.62</td>
                <td>8.27</td>
                <td>8.38</td>
                <td><span class="status-aprovado">Aprovado</span></td>
            </tr>

            <tr>
                <td>Tecnologia de Portais Interdimensionais</td>
                <td>8.0</td>
                <td>8.15</td>
                <td>8.76</td>
                <td><span class="status-aprovado">Aprovado</span></td>
            </tr>
        </tbody>
    </table>

    </div>
    <img src="../../../assets/imgs/meninasa.png" alt="meninasa" class="meninasa">
</div>

</body>
</html>