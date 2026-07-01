export function CuidadoresPage() {

    const cuidadores = [];

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

    function renderLista() {
        const container = document.getElementById("listaCuidadores");

        container.innerHTML = cuidadores.map(c => `
            <div class="border p-3 rounded mt-2">
                <p class="font-bold">${c.nombre}</p>
                <p class="text-sm text-gray-600">${c.tipo}</p>
                <p class="text-sm">
                    Alertas: ${c.alertas ? "Sí" : "No"}
                </p>
            </div>
        `).join("");
    }

    return {
        html: `
        <div class="max-w-xl mx-auto p-4">

            <h2 class="text-2xl font-bold mb-4">Red de Cuidadores</h2>

            <input id="nombre" class="p-2 border w-full rounded" placeholder="Nombre">

            <select id="tipo" class="p-2 border w-full mt-3 rounded">
                <option value="">Selecciona tipo</option>
                <option value="Cuidador Solidario">Cuidador Solidario</option>
                <option value="Profesional">Profesional</option>
                <option value="Especializado">Especializado</option>
            </select>

            <label class="flex items-center gap-2 mt-4">
                <input type="checkbox" id="alertas">
                Recibir alertas de mascotas perdidas
            </label>

            <button id="btnRegistrar"
                class="mt-4 bg-blue-500 text-white px-4 py-2 rounded w-full">
                Registrar cuidador
            </button>

            <div id="listaCuidadores" class="mt-4"></div>

        </div>
        `,

        mount() {

            document.getElementById("btnRegistrar")
                .addEventListener("click", () => {

                    const nombre = document.getElementById("nombre").value;
                    const tipo = document.getElementById("tipo").value;
                    const alertas = document.getElementById("alertas").checked;

                    if (!nombre || !tipo) {
                        showMessage("error", "Completa todos los campos");
                        return;
                    }

                    const cuidador = {
                        nombre,
                        tipo,
                        alertas
                    };

                    cuidadores.push(cuidador);

                    showMessage("success", "Cuidador registrado");

                    renderLista();

                    document.getElementById("nombre").value = "";
                    document.getElementById("tipo").value = "";
                    document.getElementById("alertas").checked = false;
                });
        }
    };
}