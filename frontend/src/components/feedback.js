export function showMessage(type, text) {

    const colors = {
        success: "bg-green-500",
        error: "bg-red-500",
        loading: "bg-blue-500"
    };

    const div = document.createElement("div");

    div.className = `
        fixed top-4 right-4 text-white px-4 py-2 rounded
        ${colors[type]}
    `;

    div.innerText = text;

    document.body.appendChild(div);

    setTimeout(() => div.remove(), 2500);
}