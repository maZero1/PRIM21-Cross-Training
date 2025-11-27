//login
async function login() {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    if (!email || !senha) {
        showError("Preencha todos os campos.");
        return;
    }

    const result = await apiPost("/auth/login", { email, senha });

    if (result.token) {
        localStorage.setItem("token", result.token);
        window.location.href = "dashboard.html";
    } else {
        showError("Usuário ou senha inválidos.");
    }
}

//mensagem de erro
function showError(msg) {
    const errorBox = document.getElementById("error");
    if (errorBox) {
        errorBox.innerText = msg;
        errorBox.classList.remove("hidden");
    }
}
//logout
function logout() {
    localStorage.removeItem("token");
    window.location.href = "login.html";
}

function ensureAuthenticated() {
    const token = localStorage.getItem("token");
    if (!token) {
        window.location.href = "login.html";
    }
}

// Chama automaticamente em páginas internas
if (window.location.pathname.includes("dashboard") ||
    window.location.pathname.includes("treino")) {
    ensureAuthenticated();
}
