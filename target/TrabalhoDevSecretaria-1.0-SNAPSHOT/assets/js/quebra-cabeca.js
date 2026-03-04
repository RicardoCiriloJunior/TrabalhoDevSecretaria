document.addEventListener("DOMContentLoaded", () => {
  const container = document.getElementById("pecas-container");

  const tamanho = 3;
  const tamanhoPeca = 100;

  for (let linha = 0; linha < tamanho; linha++) {
    for (let coluna = 0; coluna < tamanho; coluna++) {
      const peca = document.createElement("div");
      peca.classList.add("peca");

      const posX = -coluna * tamanhoPeca;
      const posY = -linha * tamanhoPeca;

      peca.style.backgroundPosition = `${posX}px ${posY}px`;

      container.appendChild(peca);
    }
  }
});
