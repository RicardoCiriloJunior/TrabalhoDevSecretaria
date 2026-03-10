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