export function Sidebar() {
    return `
    <aside class="w-64 fixed h-full bg-white border-r p-4">

        <h1 class="text-xl font-bold mb-6">🐾 ReporteAnimal</h1>

        <nav class="flex flex-col gap-2">

            <a href="#reportes" class="p-2 rounded hover:bg-gray-100">
                📍 Reportes
            </a>

            <a href="#buscador" class="p-2 rounded hover:bg-gray-100">
                🔍 Buscador
            </a>

            <a href="#cuidadores" class="p-2 rounded hover:bg-gray-100">
                👥 Cuidadores
            </a>

        </nav>

    </aside>
    `;
}