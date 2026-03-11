document.addEventListener('DOMContentLoaded', () => {
    const btnEditar = document.querySelector('.editar');
    const modal = document.getElementById('modal-tarefa');
    const mikeBalao = document.getElementById('mike-balao');
    const mikeText = document.getElementById('mike-text');

    const allCards = document.querySelectorAll('.card');
    allCards.forEach((card) => {
        aplicarClasse(card)
        ativarMenuContexto(card)
    })

    btnEditar.onclick = () => modal.classList.add('aberto');

    modal.onclick = (e) => {
        if (e.target === modal) modal.classList.remove('aberto');
    };
    document.getElementById('btn-cancelar').onclick = (e) => {
        e.preventDefault();
        modal.classList.remove('aberto');
    };

    document.getElementById('btn-salvar').onclick = async (e) => {
        e.preventDefault();

        const materia = document.getElementById('selecao-materia').value;
        const status = document.getElementById('selecao-status').value;
        const titulo = document.getElementById('input-titulo').value;
        const descricao = document.getElementById('input-descricao').value;
        const dataInput = document.getElementById('input-data').value;

        if (!materia || !status || !titulo || !dataInput || !descricao) {
            alert("Preencha todos os campos!");
            return;
        }

        await criarCard(materia, status, titulo, dataInput);
        modal.classList.remove('aberto');


        document.getElementById('selecao-materia').value = '';
        document.getElementById('selecao-status').value = '';
        document.getElementById('input-titulo').value = '';
        document.getElementById('input-descricao').value = '';
        document.getElementById('input-data').value = '';

        checarPrazosMike();
    };

    async function criarCard(materia, status, titulo, data) {
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

        const card = document.createElement('div');
        aplicarClasse(card)
        card.style.cssText = "width:100%;height:100%;display:flex;flex-direction:column;justify-content:center;align-items:center;box-sizing:border-box;cursor:pointer;";
        card.innerHTML = `<strong>${titulo.toUpperCase()}</strong><br>Entregar até dia: ${data.split('-').reverse().join('/')}`;

        ativarMenuContexto(card);

        const ok = await fetchCriarTarefas();
        if (!ok) {
            alert("Erro ao salvar tarefa!");
            return;
        }
        alvo.appendChild(card);
        window.location.reload()
    }

    function aplicarClasse(card) {
        card.classList.remove("card-vermelho", "card-amarelo", "card-verde");
        if (!card.dataset.status) return
        switch (card.dataset.status.toLowerCase()){
            case "não iniciado":
                card.classList.add("card-vermelho");
                break
            case "em andamento":
                card.classList.add("card-amarelo");
                break
            case "finalizado":
                card.classList.add("card-verde");
        }

    }

    async function fetchCriarTarefas() {
        const formElement = document.getElementById("form-modal");
        const formData = new FormData(formElement)

        formData.append("acao", "confirmar")

        const response = await fetch(contextPath + "/adicionar-tarefa", {
            method: "POST",
            body: formData
        });

        return response.ok

    }

    function checarPrazosMike() {
        const cards = document.querySelectorAll('.card');
        const hoje = new Date().toISOString().split('T')[0];
        let avisos = [];

        cards.forEach(card => {
            const match = card.innerText.match(/\d{4}-\d{2}-\d{2}/);
            if (!match) return;
            console.log(match[0]);
            const dataCard = match[0];
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

// ==== MENU CONTEXTUAL (excluir + alterar status) ====

    const menu = document.getElementById("menu-tarefa");
    const btnExcluir = document.getElementById("excluir-tarefa");
    const selectStatus = document.getElementById("atualizar-tarefa");

    let tarefaSelecionada = null;


    function ativarMenuContexto(card){

        card.addEventListener("contextmenu", (e)=>{
            e.preventDefault();

            tarefaSelecionada = card;

            menu.style.top = e.pageY + "px";
            menu.style.left = e.pageX + "px";
            menu.style.display = "flex";
        });

    }


    document.querySelectorAll(".card-amarelo, .card-vermelho, .card-verde")
        .forEach(card => ativarMenuContexto(card));


    document.addEventListener("click", ()=>{
        menu.style.display = "none";
    });
    menu.addEventListener("click", (e) => {
        e.stopPropagation();
    })


    btnExcluir.onclick = async () => {

        if(!tarefaSelecionada) return;
        const idAtividade = tarefaSelecionada.dataset.id
        tarefaSelecionada = null;
        const response = await fetch(contextPath + `/excluir-tarefa?idAtividade=${idAtividade}`, {
            method: "GET",
        });

        menu.style.display = "none";
        if (!response.ok) {
            alert("Erro ao excluir tarefa!");
            return
        }
        window.location.reload();

    };


    selectStatus.addEventListener("change", async () =>{

        if(!tarefaSelecionada) return;
        const idAtividade = tarefaSelecionada.dataset.id;
        const novoStatus = selectStatus.value;

        const formData = new FormData();
        formData.append("idAtividade", idAtividade);
        formData.append("novoStatus", novoStatus);

        const response = await fetch(contextPath + "/editar-tarefa", {
            method: 'POST',
            body: formData
        })

        if (!response.ok) {
            alert("Erro ao alterar o status da atividade!");
            return;
        }

        menu.style.display = "none";
        window.location.reload();
    });
});