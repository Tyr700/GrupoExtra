package springboot.grupoextra.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(name = "pedidos")
@Entity
@Setter
@Getter
public class PedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nomeCliente;

    @Column(name = "email_cliente", nullable = false)
    private String emailCliente;

    @Column(name = "telefone_cliente", nullable = false)
    private String telefoneCliente;

    @Column(name = "data_pedido", nullable = false)
    private LocalDateTime dataPedido;

    @Column(name = "cep", nullable = false)
    private String cep;

    @Column(name = "endereco", nullable = false)
    private String endereco;
    
    
    
    public PedidoModel() {
    }

    public PedidoModel(String nomeCliente, String emailCliente, String telefoneCliente, LocalDateTime dataPedido, String cep, String endereco) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefoneCliente = telefoneCliente;
        this.dataPedido = dataPedido;
        this.cep = cep;
        this.endereco = endereco;
    }
    

}
