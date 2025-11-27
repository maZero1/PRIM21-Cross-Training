let tipoAcesso = "ADMIN";

function selecionarTipo(tipo) {
    tipoAcesso = tipo;

    const btnAdmin = document.getElementById("btn-admin");
    const btnAluno = document.getElementById("btn-aluno");

    if (tipo === "ADMIN") {
        btnAdmin.classList.add("bg-orange-500", "text-white");
        btnAluno.classList.remove("bg-orange-500", "text-white");
        btnAluno.classList.add("text-gray-300");
    } else {
        btnAluno.classList.add("bg-orange-500", "text-white");
        btnAdmin.classList.remove("bg-orange-500", "text-white");
        btnAdmin.classList.add("text-gray-300");
    }
}

// Define ADMIN como padrão ao carregar
if (document.getElementById("btn-admin")) {
    selecionarTipo("ADMIN");
}

async function login() {
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;

    if (!email || !senha) {
        showError("Preencha todos os campos.");
        return;
    }

    const endpoint = tipoAcesso === "ADMIN"
        ? "/auth/admin/login"
        : "/auth/aluno/login";

    try {
        const result = await apiPost(endpoint, { email, senha });

        if (result && result.token) {
            localStorage.setItem("token", result.token);
            localStorage.setItem("tipo", tipoAcesso);

            if (tipoAcesso === "ADMIN") {
                window.location.href = "admin-dashboard.html";
            } else {
                window.location.href = "aluno-horarios.html";
            }
        } else {
            showError(result.mensagem || "Credenciais inválidas.");
        }
    } catch (e) {
        console.error(e);
        showError("Erro ao tentar fazer login.");
    }
}

function showError(msg) {
    const errorBox = document.getElementById("error");
    if (errorBox) {
        errorBox.innerText = msg;
        errorBox.classList.remove("hidden");
    }
}
function logout() {
    localStorage.removeItem("token");
    localStorage.removeItem("tipo");
    window.location.href = "login.html";
}
function ensureAuthenticated(tipoEsperado = null) {
    const token = localStorage.getItem("token");
    const tipo = localStorage.getItem("tipo");

    if (!token) {
        window.location.href = "login.html";
        return;
    }

    if (tipoEsperado && tipo !== tipoEsperado) {
        window.location.href = "login.html";
    }
}
