// Config global
const API_BASE = "http://localhost:8080";

async function apiGet(path, tokenRequired = false) {
    const headers = {};

    if (tokenRequired) {
        const token = localStorage.getItem("token");
        if (token) headers["Authorization"] = `Bearer ${token}`;
    }

    const response = await fetch(API_BASE + path, { headers });
    return response.json();
}

async function apiPost(path, body, tokenRequired = false) {
    const headers = { "Content-Type": "application/json" };

    if (tokenRequired) {
        const token = localStorage.getItem("token");
        if (token) headers["Authorization"] = `Bearer ${token}`;
    }

    const response = await fetch(API_BASE + path, {
        method: "POST",
        headers,
        body: JSON.stringify(body)
    });

    return response.json();
}
