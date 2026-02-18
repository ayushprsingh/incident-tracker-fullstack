const API_URL = "http://localhost:8081/api/incidents";

function createIncident() {

    const incident = {
        title: document.getElementById("title").value,
        summary: document.getElementById("description").value,

        status: document.getElementById("status").value,
        severity: document.getElementById("severity").value,
        owner: document.getElementById("owner").value,
        service: document.getElementById("service").value
    };

    fetch(API_URL, {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(incident)
    })
    .then(response => response.json())
    .then(data => {
        alert("Incident Created!");
        loadIncidents();
    })
    .catch(error => console.error(error));
}

function loadIncidents() {

    fetch(API_URL)
    .then(response => response.json())
    .then(data => {

        const list = document.getElementById("incidentList");
        list.innerHTML = "";

        data.content.forEach(incident => {

            const div = document.createElement("div");
            div.className = "incident-card";

            div.innerHTML = `
                <strong>${incident.title}</strong><br>
                Summary: ${incident.summary}<br>
                Status: ${incident.status}<br>
                Severity: ${incident.severity}<br>
                Owner: ${incident.owner}<br>
                Service: ${incident.service}
            `;

            list.appendChild(div);
        });
    })
    .catch(error => console.error(error));
}

window.onload = loadIncidents;
