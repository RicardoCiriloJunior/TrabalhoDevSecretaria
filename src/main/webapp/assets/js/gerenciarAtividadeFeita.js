export function validarAtividade(atividade) {
    const notaAtividade = localStorage.getItem(atividade) ?? "";
    if (notaAtividade.trim().length > 0) {
        alert(`Você já finalizou a atividade de ${atividade}. Sua nota nessa matéria foi: ${notaAtividade}`)
        window.location.href = "/redirecionar?page=materiasAluno";
    }
}
export function finalizarAtividade(atividade, nota, redirect = true) {
    localStorage.setItem(atividade, nota)
    if (redirect) window.location.href = "/redirecionar?page=materiasAluno";
}