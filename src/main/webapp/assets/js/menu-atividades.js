document.addEventListener("DOMContentLoaded", () => {
    const materias = document.querySelectorAll(".materia");

    materias.forEach( (materia) => {
        materia.addEventListener("click", () => {
            const pagina = materia.getAttribute("data-pagina");
            redirecionar(pagina);
        })
    })

    function redirecionar(pagina) {
        window.location.href = pagina;
    }
})