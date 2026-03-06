const informacoes = document.getElementById('informacoes');
const matricula = informacoes.getAttribute('data-matricula');
const idDisciplina = Number(informacoes.getAttribute('data-idDisciplina'));

export function validarAtividade(atividade) {
    const notaAtividade = localStorage.getItem(atividade) ?? "";
    if (notaAtividade.trim().length > 0) {
        alert(`Você já finalizou a atividade de ${atividade}. Sua nota nessa matéria foi: ${notaAtividade}`)
        window.location.href = "/redirecionar?page=materiasAluno";
    }
}
export async function finalizarAtividade(atividade, nota, redirect = true) {
    localStorage.setItem(atividade, nota)
    try {
        await fetchAtribuirNota(nota);
    } catch (e) {
        alert("Não foi possível atribuir sua nota. Avise o professor desse ocorrido!");
    }
    if (redirect) window.location.href = "/redirecionar?page=materiasAluno";
}

async function fetchAtribuirNota(nota) {
    await fetch(`/atribuir-nota?matricula=${matricula}&id_Disciplina=${idDisciplina}&nota=${nota}`, {
        method: "POST",
    })
}