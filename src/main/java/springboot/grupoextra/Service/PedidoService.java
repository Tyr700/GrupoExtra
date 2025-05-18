package springboot.grupoextra.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.grupoextra.model.PedidoModel;
import springboot.grupoextra.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel pedido) {
        return pedidoRepository.save(pedido);
    }

    public PedidoModel buscarPedidoPorEmail(String emailCliente) {
        return pedidoRepository.findByEmailCliente(emailCliente);
    }
    
}
