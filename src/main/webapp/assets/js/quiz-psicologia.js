import { perguntas } from "./perguntas-quiz-psicologia.js";
import {validarAtividade, finalizarAtividade} from "./gerenciarAtividadeFeita.js";

document.addEventListener("DOMContentLoaded", () => {
    const atividade = "Psicologia do Medo Infantil";
    validarAtividade(atividade);

    const perguntaContainer = document.getElementById("pergunta");
    const perguntaAtualContainer = document.getElementById("pergunta-atual");
    const alternativasElements = document.querySelectorAll(".alternativa");
    const btnsAlternativa = document.querySelectorAll(".btn-alternativa");
    let indiceAtual = 0;
    const btnVoltar = document.getElementById("voltar-pergunta");
    const btnAvancar = document.getElementById("avancar-pergunta");
    const btnFinalizar = document.getElementById("btn-finalizar");
    const alternativasCorretas = perguntas.map((pergunta) => pergunta.alternativaCerta);
    let nota = 0;
    let alternativasSelecionadas = ["", "", "", "", ""];
    atualizarTudo(indiceAtual);

    btnAvancar.addEventListener("click", () => {
        atualizarTudo(indiceAtual + 1);
    })
    btnVoltar.addEventListener("click", () => {
        atualizarTudo(indiceAtual - 1)
    })
    btnFinalizar.addEventListener("click", async () => {
        atribuirNota();
        perguntaContainer.textContent = `Sua nota final é: ${Math.floor(nota).toFixed(2)}`;
        document.getElementById("alternativas-container").remove();
        document.getElementById("trocar-pergunta-container").remove();
        await finalizarAtividade(atividade, nota, false)
    })

    btnsAlternativa.forEach((btn) => {
        btn.addEventListener("click", () => {
            selecionarAlternativa(btn.value);
        })
    })

    function atualizarAlternativas() {
        const alternativas = perguntas[indiceAtual].alternativas;

        alternativasElements.forEach((elemento, i) => {
            elemento.textContent = alternativas[i];
        })
    }
    function atualizarPergunta() {
        perguntaContainer.textContent = perguntas[indiceAtual].pergunta;
    }
    function selecionarAlternativa(alternativa) {
        alternativasSelecionadas[indiceAtual] = alternativa;
        estilizarBotaoSelecionado()
    }
    function atualizarPerguntaAtual() {
        const totalPerguntas = perguntas.length;
        const perguntaAtual = indiceAtual + 1;
        perguntaAtualContainer.textContent = `${perguntaAtual}/${totalPerguntas}`;
    }
    function estilizarBotaoSelecionado() {
        btnsAlternativa.forEach((btnAtual) => {
            if (btnAtual.value == alternativasSelecionadas[indiceAtual]) {
                btnAtual.classList.add("btn-selecionado");
            } else {
                btnAtual.classList.remove("btn-selecionado");
            }
        })
    }
    function atribuirNota() {
        const pontosPorNota = 10 / perguntas.length;
        alternativasCorretas.forEach( (alternativa, i) => {
            nota += alternativa == alternativasSelecionadas[i] ? pontosPorNota : 0;
        })
    }
    function atualizarTudo(indice){
        if (indice >= perguntas.length || indice < 0) {
            return
        } else if (indice == 0) {
            btnVoltar.disabled = true;
        } else if (indice == perguntas.length - 1) {
            btnAvancar.style.display = "none";
            btnFinalizar.style.display = "flex";
        } else {
            btnFinalizar.style.display = "none";
            btnAvancar.style.display = "flex";
            btnVoltar.disabled = false;
        }

        indiceAtual = indice;
        atualizarPerguntaAtual();
        atualizarPergunta();
        atualizarAlternativas()
        estilizarBotaoSelecionado();
    }

})