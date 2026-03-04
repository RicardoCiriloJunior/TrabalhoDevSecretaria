document.querySelectorAll(".card button").forEach(button => {
    button.addEventListener("click", function () {

        const card = this.closest(".card");

        // adiciona classe de lida
        card.classList.add("lida");

        // muda texto do botão
        this.innerHTML = '<i class="fa-solid fa-check"></i> Lida';

        // desativa botão
        this.disabled = true;
    });
});