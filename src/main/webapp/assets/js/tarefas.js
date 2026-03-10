document.addEventListener('DOMContentLoaded', () => {
    const btnEditar = document.querySelector('.editar');
    const modal = document.getElementById('modal-tarefa');
    const mikeBalao = document.getElementById('mike-balao');
    const mikeText = document.getElementById('mike-text');

    const allCards = document.querySelectorAll('.card-amarelo, .card-vermelho, .card-verde');
    allCards.forEach((card) => {
        card.onclick = handleClick;
    })

    btnEditar.onclick = () => modal.classList.add('aberto');
    document.getElementById('btn-cancelar').onclick = () => modal.classList.remove('aberto');


    modal.onclick = (e) => {
        if (e.target === modal) modal.classList.remove('aberto');
    };

    document.getElementById('btn-salvar').onclick = (e) => {
        e.preventDefault();

        const materia = document.getElementById('selecao-materia').value;
        const status = document.getElementById('selecao-status').value;
        const titulo = document.getElementById('input-titulo').value;
        const dataInput = document.getElementById('input-data').value;

        if (!materia || !status || !titulo || !dataInput) {
            alert("Preencha todos os campos!");
            return;
        }

        criarCard(materia, status, titulo, dataInput);
        modal.classList.remove('aberto');


        document.getElementById('selecao-materia').value = '';
        document.getElementById('selecao-status').value = '';
        document.getElementById('input-titulo').value = '';
        document.getElementById('input-data').value = '';

        checarPrazosMike();
    };

    function criarCard(materia, status, titulo, data) {
        const colunas = [
            "2",
            "3",
            "4",
            "1"
        ];
        const colIndex = colunas.indexOf(materia);

        if (colIndex === -1) return alert("Matéria inválida!");

        const rows = document.querySelectorAll('tbody tr:not(.materias)');
        let alvo = null;

        for (let row of rows) {
            let td = row.cells[colIndex];
            if (td && td.innerHTML.trim() === "") {
                alvo = td;
                break;
            }
        }

        if (!alvo) return alert("Não há espaço nesta coluna!");
        let cardClass = "verde";
        if (status.toLowerCase() === "não iniciado") cardClass = "vermelho";
        if (status.toLowerCase() === "em andamento") cardClass = "amarelo";

        const card = document.createElement('div');
        card.className = `card-${cardClass}`;
        card.style.cssText = "width:100%;height:100%;display:flex;flex-direction:column;justify-content:center;align-items:center;box-sizing:border-box;cursor:pointer;";
        card.innerHTML = `<strong>${titulo.toUpperCase()}</strong><br>Entregar até dia: ${data.split('-').reverse().join('/')}`;

        card.onclick = handleClick;

        alvo.appendChild(card);
    }
    function handleClick() {
        if (this.classList.contains('card-amarelo')) {
            this.classList.replace('card-amarelo', 'card-verde');
        } else if (this.classList.contains('card-vermelho')) {
            this.classList.replace('card-vermelho', 'card-amarelo');
        } else if (this.classList.contains('card-verde')) {
            this.classList.replace('card-verde', 'card-vermelho');
        }
        checarPrazosMike();
    }

    function checarPrazosMike() {
        const cards = document.querySelectorAll('.card-amarelo, .card-vermelho, .card-verde');
        const hoje = new Date().toISOString().split('T')[0];
        let avisos = [];

        cards.forEach(card => {
            const match = card.innerText.match(/\d{2}\/\d{2}\/\d{4}/);
            if (!match) return;

            const dataCard = match[0].split('/').reverse().join('-');
            if (dataCard === hoje && !card.classList.contains('card-verde')) {
                const strong = card.querySelector('strong');
                if (strong) avisos.push(strong.innerText);
            }
        });

        if (avisos.length > 0) {
            mikeText.innerText = `O CARD "${avisos[0]}" VENCE HOJE! VAMOS TRABALHAR!`;
            mikeBalao.classList.remove('select-hide');
        } else {
            mikeBalao.classList.add('select-hide');
        }
    }

    setTimeout(checarPrazosMike, 1000);
});