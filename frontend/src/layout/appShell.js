import { Sidebar } from "./sidebar.js";

export function AppShell(content) {
    return `
    <div class="flex bg-gray-100 min-h-screen">

        ${Sidebar()}

        <main class="flex-1 ml-64 p-6">
            ${content}
        </main>

    </div>
    `;
}