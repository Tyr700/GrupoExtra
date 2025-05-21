async function enviarPedidoParaBackend(checkoutData) {
    try {
        const response = await fetch('/pedidos/carrinho', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                emailCliente: checkoutData.email,
                endereco: checkoutData.endereco,
                formaPagamento: checkoutData.pagamento,
                produtos: checkoutData.cart,
                valorTotal: checkoutData.total,
                status: checkoutData.status,
                dataPedido: checkoutData.orderDate
            })
        });

        if (!response.ok) {
            throw new Error('Erro ao enviar pedido');
        }

        const pedidoSalvo = await response.json();
        console.log('Pedido salvo com sucesso:', pedidoSalvo);
        return pedidoSalvo;

    } catch (error) {
        console.error('Erro ao enviar pedido:', error);
        alert('Erro ao processar seu pedido. Por favor, tente novamente.');
        throw error;
    }
}