document.addEventListener("DOMContentLoaded", () => {
    async function fetchAtribuirNota(nota) {
        await fetch(`/atribuir-nota?matricula=${matricula}&id_Disciplina=${idDisciplina}&nota=${nota}&tipo=n2`, {
            method: "POST",
        })
    }
})