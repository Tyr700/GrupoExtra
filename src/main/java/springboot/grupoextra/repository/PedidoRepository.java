package springboot.grupoextra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.grupoextra.model.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository <PedidoModel, Long> {

    PedidoModel findByEmailCliente(String emailCliente);
    
}
