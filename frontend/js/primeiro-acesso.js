async function registrar() {
    const nome = document.getElementById("nome").value;
    const email = document.getElementById("email").value;
    const senha = document.getElementById("senha").value;
    const confirmar = document.getElementById("confirmar").value;
    const msg = document.getElementById("msg");

    // validações básicas
    if (!nome || !email || !senha || !confirmar) {
        showMsg("Preencha todos os campos.", "text-red-400");
        return;
    }

    if (senha.length < 6) {
        showMsg("A senha deve ter pelo menos 6 caracteres.", "text-red-400");
        return;
    }

    if (senha !== confirmar) {
        showMsg("As senhas não coincidem.", "text-red-400");
        return;
    }

    const result = await apiPost("/auth/registrar", { nome, email, senha });

    if (result.sucesso) {
        showMsg("Conta criada com sucesso! Redirecionando...", "text-green-400");

        setTimeout(() => {
            window.location.href = "login.html";
        }, 1800);
    } else {
        showMsg(result.mensagem || "Erro ao criar conta.", "text-red-400");
    }
}

function showMsg(texto, classe) {
    const msg = document.getElementById("msg");
    msg.className = classe + " mt-2 text-center";
    msg.innerText = texto;
    msg.classList.remove("hidden");
}
