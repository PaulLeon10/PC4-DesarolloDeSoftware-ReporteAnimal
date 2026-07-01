export function BuscadorPage() {

    // RF 2.3, 2.4, 2.5
    const catalogo = {
        adopcion: [
            { nombre: "Refugio Feliz", tipo: "ONG" },
            { nombre: "Huellitas", tipo: "ONG" }
        ],
        venta: [
            { nombre: "Criadero Alfonso Ugarte", tipo: "Certificado" },
            { nombre: "Criadero en Lima Norte", tipo: "Certificado" }
        ],
        verificar: [
            { nombre: "Sistema de alertas activas", tipo: "Alerta" }
        ]
    };

    function showMessage(type, message) {
        const div = document.createElement("div");

        div.textContent = message;

        div.className = `
            fixed bottom-4 right-4 px-4 py-2 rounded text-white
            ${type === "success" ? "bg-green-500" : ""}
            ${type === "loading" ? "bg-blue-500" : ""}
            ${type === "error" ? "bg-red-500" : ""}
        `;

        document.body.appendChild(div);

        setTimeout(() => div.remove(), 2000);
    }

    function renderResultados(list) {
        const container = document.getElementById("resultados");

        container.innerHTML = list.map(item => `
            <div class="border p-3 rounded mt-2">
                <p class="font-bold">${item.nombre}</p>
                <p class="text-sm text-gray-600">${item.tipo}</p>
            </div>
        `).join("");
    }

    return {
        html: `
        <div class="max-w-xl mx-auto p-4">

            <h2 class="text-2xl font-bold">Buscador</h2>

            <input type="file" class="p-2 border w-full rounded mt-2">

            <select id="tipo" class="p-2 border w-full mt-3 rounded">
                <option value="">Selecciona intención</option>
                <option value="adopcion">Adopción</option>
                <option value="venta">Venta</option>
                <option value="verificar">Verificar pérdida</option>
            </select>

            <button id="btnBuscar"
                class="mt-4 bg-green-500 text-white px-4 py-2 rounded w-full">
                Buscar
            </button>

            <div id="resultados" class="mt-4"></div>

        </div>
        `,

        mount() {

            document.getElementById("btnBuscar")
                .addEventListener("click", () => {

                    const tipo = document.getElementById("tipo").value;

                    if (!tipo) {
                        showMessage("error", "Debes seleccionar una intención");
                        return;
                    }

                    showMessage("loading", "Buscando...");

                    setTimeout(() => {

                        const resultados = catalogo[tipo];

                        renderResultados(resultados);

                        showMessage("success", `Resultados de ${tipo} listos`);

                    }, 800);
                });
        }
    };
}