import {finalizarAtividade, validarAtividade} from "./gerenciarAtividadeFeita.js";

document.addEventListener("DOMContentLoaded", () => {
    const atividade = "Engenharia de Sustos e Rendimento Energético";
    validarAtividade(atividade);

    const resposta = document.getElementById("resposta");
    const respostasCorretas = [450, 96, 30, 7, 310];
    const btnFinalizar = document.getElementById("btn-finalizar");
    const nota = document.getElementById("nota");
    let finalizado = false;

    resposta.addEventListener("input", () => {
        btnFinalizar.disabled = resposta.value.trim() === "";
    })

    btnFinalizar.addEventListener("click", async () => {
        if (finalizado) return;
        let valorResposta = resposta.value.trim();
        if (valorResposta === "") return;

        let respostasUsuario = valorResposta.split(";").map(num => parseInt(num.trim()));
        let acertos = validarAcertos(respostasUsuario);
        let notaFinal = (acertos / respostasCorretas.length) * 10;
        notaFinal = notaFinal.toFixed(2)

        nota.textContent = `Nota: ${notaFinal}`;
        finalizado = true;
        btnFinalizar.disabled = true;
        alert(`Sua nota nessa atividade foi: ${notaFinal}`)
        await finalizarAtividade(atividade, notaFinal, false);
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