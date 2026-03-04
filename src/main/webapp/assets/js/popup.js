let currentRow = null;

const modal = document.getElementById("gradeModal");
const gradeInput = document.getElementById("gradeInput");
const saveBtn = document.getElementById("saveBtn");
const cancelBtn = document.getElementById("cancelBtn");

// Abrir modal ao clicar no lápis
document.querySelectorAll(".edit").forEach(button => {
    button.addEventListener("click", function() {
        currentRow = this.closest(".table-row");
        const currentGrade = currentRow.children[3].innerText;
        gradeInput.value = currentGrade;
        modal.style.display = "flex";
    });
});

// Fechar modal
cancelBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

// Salvar nota
saveBtn.addEventListener("click", () => {
    const newGrade = gradeInput.value;

    if(newGrade === "" || newGrade < 0 || newGrade > 10){
        alert("Digite uma nota válida entre 0 e 10");
        return;
    }

    currentRow.children[3].innerText = newGrade;
    modal.style.display = "none";
});