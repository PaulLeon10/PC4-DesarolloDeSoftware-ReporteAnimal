import L from "leaflet";
import "leaflet/dist/leaflet.css";
import { registrarReporte } from "../services/api.js";

export function ReportesPage() {

  let coords = null;

  return {
    html: `
      <div class="max-w-2xl mx-auto bg-white p-6 rounded shadow">

        <h2 class="text-xl font-bold mb-4">Reporte de mascota perdida</h2>

        <input id="nombre" class="border p-2 w-full mb-2" placeholder="Nombre"/>
        <input id="especie" class="border p-2 w-full mb-2" placeholder="Especie"/>
        <input id="raza" class="border p-2 w-full mb-2" placeholder="Raza"/>
        <input id="foto" class="border p-2 w-full mb-2" placeholder="URL foto"/>
        <textarea id="descripcion" class="border p-2 w-full mb-2" placeholder="Descripción"></textarea>

        <p class="font-semibold mb-2">Selecciona ubicación en el mapa:</p>
        <div id="map" class="h-80 w-full rounded mb-4"></div>

        <button id="btnReportar"
          class="bg-red-500 text-white px-4 py-2 rounded w-full">
          Reportar mascota
        </button>

      </div>
    `,

    mount() {

      setTimeout(() => {

        // MAPA CENTRO LIMA
        const map = L.map("map").setView([-12.0464, -77.0428], 13);

        L.tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
          attribution: ""
        }).addTo(map);

        let marker = null;

        // CLICK MAPA
        map.on("click", (e) => {

          coords = {
            lat: e.latlng.lat,
            lng: e.latlng.lng
          }

          if (marker) map.removeLayer(marker);

          marker = L.marker(coords).addTo(map);
        });

        // BOTÓN REPORTAR
        document.getElementById("btnReportar").addEventListener("click", async () => {

          const nombre = document.getElementById("nombre").value;
          const especie = document.getElementById("especie").value;
          const raza = document.getElementById("raza").value;
          const foto = document.getElementById("foto").value;
          const descripcion = document.getElementById("descripcion").value;

          // VALIDACIÓN MINIMA
          if (!nombre || !especie || !coords) {
            alert("Completa datos y selecciona ubicación en el mapa");
            return;
          }

          const payload = {
            nombre,
            especie,
            raza,
            foto,
            descripcion,
            ubicacion: {
              latitud: coords.lat,
              longitud: coords.lng
            }
          };

          try {
            await registrarReporte(payload);
            alert("Reporte enviado correctamente");

            // limpiar coords
            coords = null;
            if (marker) {
              map.removeLayer(marker);
              marker = null;
            }

            document.getElementById("nombre").value = "";
            document.getElementById("especie").value = "";
            document.getElementById("raza").value = "";
            document.getElementById("foto").value = "";
            document.getElementById("descripcion").value = "";

          } catch (err) {
            console.error(err);
            alert("Error al enviar reporte");
          }

        });

      }, 0);
    }
  };
}