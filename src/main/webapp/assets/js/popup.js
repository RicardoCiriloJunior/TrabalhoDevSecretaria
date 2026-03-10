let currentRow = null;

const modal = document.getElementById("gradeModal");
const gradeInput = document.getElementById("gradeInput");
const saveBtn = document.getElementById("saveBtn");
const cancelBtn = document.getElementById("cancelBtn");
const idDisciplina = document.body.dataset.id_disciplina;

// Abrir modal ao clicar no lápis
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function() {
        currentRow = this.closest(".table-row");
        const currentGrade = currentRow.children[2].innerText;
        gradeInput.value = currentGrade;
        modal.style.display = "flex";
    });
});

// Fechar modal
cancelBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

// Salvar nota
saveBtn.addEventListener("click", async () => {
    const newGrade = gradeInput.value;
    const matricula = currentRow.dataset.matricula;

    if(newGrade === "" || newGrade < 0 || newGrade > 10){
        alert("Digite uma nota válida entre 0 e 10");
        return;
    }
    const response = await fetchAtribuirNota(matricula, newGrade);
    if (!response.ok) {
        alert("Erro ao salvar a nota!");
        return;
    }
    currentRow.children[2].innerText = newGrade;
    atualizarMedia();
    modal.style.display = "none";
});

async function fetchAtribuirNota(matricula, nota) {
    return fetch(`/atribuir-nota?matricula=${matricula}&id_Disciplina=${idDisciplina}&nota=${nota}&tipo=n1`, {
        method: "POST",
    })
}
function atualizarMedia(currentRow) {
    const n1 = currentRow.children[2].innerText
    const n2 = currentRow.children[3].innerText
    currentRow.children[4].innerText = n1 * n2 / 2
}