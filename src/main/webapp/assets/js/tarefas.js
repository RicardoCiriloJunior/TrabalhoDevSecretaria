document.addEventListener('DOMContentLoaded', () => {
    const btnEditar = document.querySelector('.editar');
    const modal = document.getElementById('modal-tarefa');
    const selectSelected = document.querySelector('.select-selected');
    const selectItems = document.querySelector('.select-items');
    const mikeBubble = document.getElementById('mike-bubble');
    const mikeText = document.getElementById('mike-text');
    let materiaSelecionada = "";

    btnEditar.onclick = () => modal.style.display = 'block';
    document.getElementById('btn-cancelar').onclick = () => modal.style.display = 'none';

    selectSelected.onclick = () => selectItems.classList.toggle('select-hide');

    document.querySelectorAll('.select-items div').forEach(item => {
        item.onclick = function() {
            materiaSelecionada = this.innerText;
            selectSelected.innerText = materiaSelecionada;
            selectItems.classList.add('select-hide');
        };
    });

    document.getElementById('btn-salvar').onclick = () => {
        const titulo = document.getElementById('input-titulo').value;
        const dataInput = document.getElementById('input-data').value;

        if (!titulo || !dataInput || !materiaSelecionada) return alert("Preencha tudo!");

        criarCard(materiaSelecionada, titulo, dataInput);
        modal.style.display = 'none';
        checarPrazosMike();
    };

    function criarCard(materia, titulo, data) {
        const colunas = ["Psicologia do Medo Infantil", "Expressividade Vocal Avançada", "Engenharia de Sustos e Rendimento Energético", "Tecnologia de Portais Interdimensionais"];
        const colIndex = colunas.indexOf(materia);

        const rows = document.querySelectorAll('tbody tr:not(.materias)');
        let alvo;

        for (let row of rows) {
            let td = row.cells[colIndex];
            if (td && td.innerHTML.trim() === "") {
                alvo = td;
                break;
            }
        }

        if (!alvo) return alert("Não há espaço nesta coluna!");

        const hoje = new Date().toISOString().split('T')[0];
        let statusClasse = data < hoje ? "card-vermelho" : "card-amarelo";

        const card = document.createElement('div');
        card.className = statusClasse;
        card.innerHTML = `<strong>${titulo.toUpperCase()}</strong><br>Entregar até dia: ${data.split('-').reverse().join('/')}`;

        card.onclick = function() {
            if (this.classList.contains('card-amarelo')) {
                this.classList.replace('card-amarelo', 'card-verde');
            } else if (this.classList.contains('card-verde')) {
                this.classList.replace('card-verde', 'card-amarelo');
            }
        };

        alvo.appendChild(card);
    }

    function checarPrazosMike() {
        const cards = document.querySelectorAll('.card-amarelo, .card-vermelho, .card-verde');
        const hoje = new Date().toISOString().split('T')[0];
        let avisos = [];

        cards.forEach(card => {
            const dataCard = card.innerText.match(/\d{2}\/\d{2}\/\d{4}/)[0].split('/').reverse().join('-');
            if (dataCard === hoje && !card.classList.contains('card-verde')) {
                const materiaNome = card.parentElement.closest('table').rows[0].cells[card.parentElement.cellIndex].innerText;
                avisos.push(card.querySelector('strong').innerText);
            }
        });

        if (avisos.length > 0) {
            mikeText.innerText = `O CARD "${avisos[0]}" VENCE HOJE! VAMOS TRABALHAR!`;
            mikeBubble.classList.remove('select-hide');
        } else {
            mikeBubble.classList.add('select-hide');
        }
    }

    setTimeout(checarPrazosMike, 1000);
});
