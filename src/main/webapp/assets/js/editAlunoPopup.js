// ==== Atualizar ====
const editButtons = document.querySelectorAll(".edit-button")

const modalEditarAluno = document.getElementById("modalEditarAluno")
const cancelEditAluno = document.getElementById("cancelEditAluno")

const inputMatricula = document.getElementById("edit_matricula")
const inputNome = document.getElementById("edit_nome")
const inputEmail = document.getElementById("edit_email")

editButtons.forEach(button => {

    button.addEventListener("click", () => {

        const matricula = button.dataset.matricula
        const nome = button.dataset.nome
        const email = button.dataset.email

        inputMatricula.value = matricula
        inputNome.value = nome
        inputEmail.value = email

        modalEditarAluno.style.display = "flex"
    })

})

cancelEditAluno.addEventListener("click", () => {
    modalEditarAluno.style.display = "none"
})


// ==== Excluir ====
const deleteButtons = document.querySelectorAll(".delete-button")

const modalExcluirAluno = document.getElementById("modalExcluirAluno")
const textoExcluirAluno = document.getElementById("textoExcluirAluno")
const deletInputMatricula = document.getElementById("delete_matricula")

const cancelDeleteAluno = document.getElementById("cancelDeleteAluno")

deleteButtons.forEach(button => {

    button.addEventListener("click", () => {

        const matricula = button.dataset.matricula
        const nome = button.dataset.nome

        deletInputMatricula.value = matricula

        textoExcluirAluno.textContent =
            `Você está prestes a excluir ${nome}. Deseja prosseguir?`

        modalExcluirAluno.style.display = "flex"
    })

})

cancelDeleteAluno.addEventListener("click", () => {
    modalExcluirAluno.style.display = "none"
})