import {finalizarAtividade, validarAtividade} from "./gerenciarAtividadeFeita.js";

document.addEventListener("DOMContentLoaded", () => {
  const atividade = "Tecnologia de Portais Interdimensionais"
  validarAtividade(atividade);

  const pecasContainer = document.getElementById("pecas-container");
  const resolucaoContainer = document.getElementById("resolucao-container");
  const btnIniciar = document.getElementById("btn-iniciar");
  const btnFinalizar = document.getElementById("btn-finalizar");
  const cronometro = document.getElementById("cronometro");
  const tentativas = document.getElementById("tentativas");
  const notaContainer = document.getElementById("nota");

  const colunas = 3;
  const linhas = 3;
  const larguraPeca = 140;
  const alturaPeca = 87;
  const totalPecas = linhas * colunas;
  const tentativasMaximas = 2;

  let pecaArrastada = null;
  let jogoIniciado = false;
  let jogoResolvido = false;
  let jogoFinalizado = false;
  let tempoInicial = null;
  let intervaloCronometro = null;
  let tentativasUsadas = 0;

  function formatarTempo(totalSegundos) {
    const minutos = Math.floor(totalSegundos / 60);
    const segundos = totalSegundos % 60;
    return `${String(minutos).padStart(2, "0")}:${String(segundos).padStart(
      2,
      "0"
    )}`;
  }

  function atualizarCronometro() {
    if (!tempoInicial) {
      cronometro.textContent = "00:00";
      return;
    }

    const segundosPassados = Math.floor((Date.now() - tempoInicial) / 1000);
    cronometro.textContent = formatarTempo(segundosPassados);
  }

  function iniciarCronometro() {
    tempoInicial = Date.now();
    atualizarCronometro();
    intervaloCronometro = setInterval(atualizarCronometro, 1000);
  }

  function pararCronometro() {
    if (intervaloCronometro) {
      clearInterval(intervaloCronometro);
      intervaloCronometro = null;
    }
  }

  function atualizarTentativas() {
    tentativas.textContent = `Tentativas: ${
      tentativasMaximas - tentativasUsadas
    }`;
  }

  function bloquearInteracao() {
    jogoIniciado = false;
    pararCronometro();
    pecaArrastada = null;

    document
      .querySelectorAll(".slot-hover")
      .forEach((el) => el.classList.remove("slot-hover"));

    document.querySelectorAll(".peca").forEach((peca) => {
      peca.classList.remove("arrastando");
      peca.draggable = false;
    });
  }

  function resetarPuzzle() {
    if (jogoFinalizado) {
      return;
    }

    bloquearInteracao();
    tempoInicial = null;
    cronometro.textContent = "00:00";
    jogoResolvido = false;

    const pecas = embaralhar(Array.from(document.querySelectorAll(".peca")));
    pecas.forEach((peca) => {
      pecasContainer.appendChild(peca);
    });
  }

  function embaralhar(lista) {
    for (let i = lista.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [lista[i], lista[j]] = [lista[j], lista[i]];
    }
    return lista;
  }

  function atualizarBotoes() {
    if (jogoFinalizado) {
      btnIniciar.disabled = true;
      btnFinalizar.disabled = true;
      return;
    }

    const semTentativas = tentativasUsadas >= tentativasMaximas;
    btnIniciar.disabled = semTentativas || jogoIniciado;
    btnFinalizar.disabled = !jogoResolvido || semTentativas;
  }

  function concluirComSucesso() {
    if (jogoResolvido) {
      return;
    }

    const tempoFinal = cronometro.textContent;

    jogoResolvido = true;
    tentativasUsadas += 1;
    atualizarTentativas();
    bloquearInteracao();

    if (tentativasUsadas >= tentativasMaximas) {
      btnIniciar.disabled = true;
      btnFinalizar.disabled = false;
      alert(
        `Parabéns! Você montou o quebra-cabeça corretamente em ${tempoFinal}. Suas tentativas acabaram. Clique em "Finalizar" para receber sua nota.`
      );
      return;
    }

    btnIniciar.disabled = false;
    atualizarBotoes();
    alert(
      `Parabéns! Você montou o quebra-cabeça corretamente em ${tempoFinal}. Resta 1 tentativa. Clique em "Finalizar" para receber sua nota.`
    );
  }

  function estaResolvido() {
    const slots = resolucaoContainer.querySelectorAll(".slot");

    return Array.from(slots).every((slot) => {
      const peca = slot.querySelector(".peca");
      return peca && peca.dataset.id === slot.dataset.posicao;
    });
  }

  function moverPeca(peca, alvo) {
    if (!jogoIniciado || !peca || !alvo) {
      return;
    }

    if (alvo.id === "pecas-container") {
      pecasContainer.appendChild(peca);
      atualizarBotoes();
      return;
    }

    if (!alvo.classList.contains("slot")) {
      return;
    }

    const origem = peca.parentElement;
    const pecaNoAlvo = alvo.querySelector(".peca");

    if (pecaNoAlvo && pecaNoAlvo !== peca) {
      if (origem && origem.classList.contains("slot")) {
        origem.appendChild(pecaNoAlvo);
      } else {
        pecasContainer.appendChild(pecaNoAlvo);
      }
    }

    alvo.appendChild(peca);

    if (estaResolvido()) {
      concluirComSucesso();
      return;
    }

    atualizarBotoes();
  }

  function criarPeca(indicePeca) {
    const peca = document.createElement("div");
    const coluna = indicePeca % colunas;
    const linha = Math.floor(indicePeca / colunas);

    peca.classList.add("peca");
    peca.draggable = false;
    peca.dataset.id = String(indicePeca);
    peca.style.backgroundPosition = `${-coluna * larguraPeca}px ${
      -linha * alturaPeca
    }px`;

    peca.addEventListener("dragstart", (evento) => {
      pecaArrastada = peca;
      peca.classList.add("arrastando");
      evento.dataTransfer.effectAllowed = "move";
    });

    peca.addEventListener("dragend", () => {
      peca.classList.remove("arrastando");
      pecaArrastada = null;
      document
        .querySelectorAll(".slot-hover")
        .forEach((el) => el.classList.remove("slot-hover"));
      pecasContainer.classList.remove("slot-hover");
    });

    return peca;
  }

  function configurarAlvoDrop(alvo) {
    alvo.addEventListener("dragover", (evento) => {
      if (!jogoIniciado) {
        return;
      }

      evento.preventDefault();
      alvo.classList.add("slot-hover");
    });

    alvo.addEventListener("dragleave", () => {
      alvo.classList.remove("slot-hover");
    });

    alvo.addEventListener("drop", (evento) => {
      if (!jogoIniciado) {
        return;
      }

      evento.preventDefault();
      alvo.classList.remove("slot-hover");
      moverPeca(pecaArrastada, alvo);
    });
  }

  for (let i = 0; i < totalPecas; i++) {
    const slot = document.createElement("div");
    slot.classList.add("slot");
    slot.dataset.posicao = String(i);
    configurarAlvoDrop(slot);
    resolucaoContainer.appendChild(slot);
  }

  const indicesPecas = embaralhar(
    Array.from({ length: totalPecas }, (_, i) => i)
  );
  indicesPecas.forEach((indice) => {
    pecasContainer.appendChild(criarPeca(indice));
  });

  configurarAlvoDrop(pecasContainer);
  atualizarTentativas();
  atualizarBotoes();

  btnIniciar.addEventListener("click", () => {
    if (
      jogoFinalizado ||
      jogoIniciado ||
      tentativasUsadas >= tentativasMaximas
    ) {
      return;
    }

    resetarPuzzle();
    jogoIniciado = true;
    btnIniciar.disabled = true;

    pecasContainer.querySelectorAll(".peca").forEach((peca) => {
      peca.draggable = true;
    });

    iniciarCronometro();
    atualizarBotoes();
  });

  btnFinalizar.addEventListener("click",  async () => {
    if (jogoFinalizado || !jogoResolvido) {
      return;
    }

    jogoFinalizado = true;
    bloquearInteracao();
    atualizarBotoes();
    const notaFinal = calcularNota(cronometro.textContent);
    notaContainer.textContent = `${notaFinal}`;
    alert("Sua nota para esta atividade é: " + notaFinal);
    await finalizarAtividade(atividade, notaFinal, false);
  });

  function calcularNota(tempo) {
    if (tentativasUsadas > tentativasMaximas) {
      return 0;
    }

    const [minutos, segundos] = tempo.split(":").map(Number);
    const totalSegundos = minutos * 60 + segundos;

    if (totalSegundos <= 20) {
      return 10;
    } else if (totalSegundos <= 0){
      return 0;
    } 
    else {
      let nota = 10 - Math.round((totalSegundos - 20) / 2)
      return nota >= 0 ? nota : 0;
    }
  }
});
