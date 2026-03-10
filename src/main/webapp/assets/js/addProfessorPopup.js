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