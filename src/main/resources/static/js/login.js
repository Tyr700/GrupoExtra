async function loginUsuario(email, senha) {
    try {
        const response = await fetch(`/usuarios/login/${email}/${senha}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Credenciais inválidas');
        }

        return await response.json();
    } catch (error) {
        console.error('Erro:', error);
        throw error;
    }
}