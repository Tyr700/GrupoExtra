package springboot.grupoextra.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empresa")
@Setter
@Getter
public class EmpresaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_empresa")
    private String nome;

    @Column(name = "email_empresa", unique = true)
    private String email;

    @Column(name = "senha_empresa", unique = true)
    private String senha;

    @CreationTimestamp
    @Column(name = "data_de_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "telefone_empresa")
    private String telefone;

    @Column(name = "endereco_empresa")
    private String endereco;
    
    
    public EmpresaModel() {
    }

    public EmpresaModel(String nome, String email, String senha, String telefone, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = LocalDateTime.now();
        this.telefone = telefone;
        this.endereco = endereco;
    }
    
    
}
