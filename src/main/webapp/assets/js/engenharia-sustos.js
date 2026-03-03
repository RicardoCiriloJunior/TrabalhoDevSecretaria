document.addEventListener("DOMContentLoaded", () => {
    const resposta = document.getElementById("resposta");
    const respostasCorretas = [450, 96, 30, 7, 310];
    const btnFinalizar = document.getElementById("btn-finalizar");
    const nota = document.getElementById("nota");
    let finalizado = false;

    resposta.addEventListener("input", () => {
        if (resposta.value.trim() !== "") {
            btnFinalizar.disabled = false;
        } else {
            btnFinalizar.disabled = true;
        }
    })

    btnFinalizar.addEventListener("click", () => {
        if (finalizado) return;
        let valorResposta = resposta.value.trim();
        if (valorResposta === "") return;

        let respostasUsuario = valorResposta.split(";").map(num => parseInt(num.trim()));
        let acertos = validarAcertos(respostasUsuario);
        let notaFinal = (acertos / respostasCorretas.length) * 10;

        nota.textContent = `Nota: ${notaFinal.toFixed(2)}`;
        finalizado = true;
        btnFinalizar.disabled = true;
    })

    function validarAcertos(respostasUsuario) {
        let acertos = 0;
        for (let i = 0; i < respostasCorretas.length; i++) {
            if (respostasUsuario[i] === respostasCorretas[i]) {
                acertos++;
            }
        }
        return acertos;
    }
})