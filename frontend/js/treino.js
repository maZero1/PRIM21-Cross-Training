document.addEventListener("DOMContentLoaded", async () => {
    const container = document.getElementById("treino-content");

    try {
        const treino = await apiGet("/treinos/dia", true);

        if (!treino || Object.keys(treino).length === 0) {
            container.innerHTML = `
                <p class="text-gray-400">Nenhum treino disponível para hoje.</p>
            `;
            return;
        }

        container.innerHTML = `
            ${treino.nome ? section("Nome do treino", treino.nome) : ""}
            ${treino.aquecimento ? section("Aquecimento", treino.aquecimento) : ""}
            ${treino.principal ? section("Parte principal", treino.principal) : ""}
            ${treino.mobilidade ? section("Mobilidade", treino.mobilidade) : ""}
        `;
    } catch (err) {
        container.innerHTML = `
            <p class="text-red-400">Erro ao carregar o treino.</p>
        `;
        console.error(err);
    }
});

function section(titulo, texto) {
    return `
        <div class="bg-neutral-800 p-4 rounded-xl border border-neutral-700">
            <h4 class="text-lg font-semibold text-orange-300 mb-2">${titulo}</h4>
            <p class="text-gray-200 leading-relaxed whitespace-pre-line">${texto}</p>
        </div>
    `;
}
