// ==== Criação de professor ====

const modal = document.getElementById("modalProfessor");
const openBtn = document.querySelector(".botao-adicionar");
const cancelBtn = document.getElementById("cancelProfessor");
const form = document.getElementById("formProfessor");

openBtn.addEventListener("click", () => {
    modal.style.display = "flex";
});

cancelBtn.addEventListener("click", () => {
    modal.style.display = "none";
});

form.addEventListener("submit", async function(e) {
    e.preventDefault();

    const formData = new FormData(form);
    const email = formData.get("email");
    if (!email.includes("@monstrossa")){
        alert("O email deve ser do domínio @monstrossa");
        return;
    }

    const response = await fetch(contextPath + "/admin/professores", {
        method: "POST",
        body: formData
    });

    if(!response.ok){
        alert("Erro ao salvar professor");
        return;
    }

    location.reload();
});

// ==== Atualização de professor ====

const editModal = document.getElementById("modalEditarProfessor");
const cancelEdit = document.getElementById("cancelEditProfessor");
const editForm = document.getElementById("formEditarProfessor");

document.querySelectorAll(".edit-button").forEach(btn => {

    btn.addEventListener("click", () => {

        document.getElementById("edit_id").value = btn.dataset.id;
        document.getElementById("edit_nome").value = btn.dataset.nome;
        document.getElementById("edit_email").value = btn.dataset.email;
        document.getElementById("edit_disciplina").value = btn.dataset.disciplina;

        editModal.style.display = "flex";
    });

});

cancelEdit.addEventListener("click", () => {
    editModal.style.display = "none";
});

editForm.addEventListener("submit", async function(e){

    e.preventDefault();

    const formData = new FormData(editForm);

    const response = await fetch(contextPath + "/admin/atualizar-professor", {
        method: "POST",
        body: formData
    });

    if(!response.ok){
        alert("Erro ao atualizar professor");
        return;
    }

    location.reload();
});