const BASE_URL = "http://localhost:8080";

export async function registrarReporte(data) {
  const res = await fetch(`${BASE_URL}/reportes/registrar?tipo=anonimo`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(data)
  });

  if (!res.ok) {
    throw new Error("Error backend");
  }

  return res.json();
}