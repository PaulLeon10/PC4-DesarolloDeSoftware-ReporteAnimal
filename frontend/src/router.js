import { AppShell } from "./layout/appShell.js";
import { ReportesPage } from "./pages/reportes.page.js";
import { BuscadorPage } from "./pages/buscador.page.js";
import { CuidadoresPage } from "./pages/cuidadores.page.js";

const app = document.getElementById("app");

export function router() {

    const hash = window.location.hash;

    let page;

    if (!hash || hash === "#reportes") {
        page = ReportesPage();
    }

    if (hash === "#buscador") {
        page = BuscadorPage();
    }

    if (hash === "#cuidadores") {
        page = CuidadoresPage();
    }

    app.innerHTML = AppShell(page.html);

    page.mount?.();
}