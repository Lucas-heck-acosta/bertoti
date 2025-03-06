document.addEventListener("DOMContentLoaded", () => {
    const ventiladoresContainer = document.getElementById("ventiladores");
    const addForm = document.getElementById("addVentiladorForm");

    const API_URL = "http://localhost:8080/ventiladores";

    async function fetchVentiladores() {
        try {
            const response = await fetch(API_URL);
            const ventiladores = await response.json();
            renderVentiladores(ventiladores);
        } catch (error) {
            console.error("Erro ao buscar ventiladores:", error);
        }
    }

    function renderVentiladores(ventiladores) {
        ventiladoresContainer.innerHTML = "";
        ventiladores.forEach(ventilador => {
            const ventiladorElement = document.createElement("div");
            ventiladorElement.classList.add("ventilador-card");
            ventiladorElement.innerHTML = `
                <img src="images/ventilador.png" alt="Ventilador">
                <h3>${ventilador.nome}</h3>
                <p>Potência: ${ventilador.potencia}</p>
                <button onclick="editVentilador('${ventilador.vent_id}')">Editar</button>
                <button onclick="deleteVentilador('${ventilador.vent_id}')">Excluir</button>
            `;
            ventiladoresContainer.appendChild(ventiladorElement);
        });
    }

    addForm.addEventListener("submit", async (event) => {
        event.preventDefault();
        const nome = document.getElementById("nome").value;
        const potencia = document.getElementById("potencia").value;

        try {
            await fetch(API_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ nome, potencia })
            });
            addForm.reset();
            fetchVentiladores();
        } catch (error) {
            console.error("Erro ao adicionar ventilador:", error);
        }
    });

    window.editVentilador = async (vent_id) => {
        const nome = prompt("Novo nome:");
        const potencia = prompt("Nova potência:");
        if (!nome || !potencia) return;

        try {
            await fetch(`${API_URL}/${vent_id}`, {
                method: "PUT",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ nome, potencia })
            });
            fetchVentiladores();
        } catch (error) {
            console.error("Erro ao editar ventilador:", error);
        }
    };

    window.deleteVentilador = async (vent_id) => {
        if (!confirm("Tem certeza que deseja excluir este ventilador?")) return;
        try {
            await fetch(`${API_URL}/${vent_id}`, { method: "DELETE" });
            fetchVentiladores();
        } catch (error) {
            console.error("Erro ao excluir ventilador:", error);
        }
    };

    fetchVentiladores();
});
