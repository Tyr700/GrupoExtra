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

    @Column(name = "motivo_busca_produto")
    private String motivoBuscaProduto;

    @Column(name = "produto_ou_servico_anterior")
    private String produtoOuServicoAnterior;

    @Column(name = "frequencia_compras")
    private String frequenciaCompras;

    @Column(name = "ticket_medio")
    private String ticketMedio;

    @Column(name = "preferencia_pagamento")
    private String preferenciaPagamento;

    @Column(name = "como_conheceu_empresa")
    private String comoConheceuEmpresa;

    @Column(name = "experiencia_compra")
    private String experienciaCompra;

    @Column(name = "ponto_positivo")
    private String pontoPositivo;

    @Column(name = "teve_problema_compra")
    private String teveProblemaCompra;

    @Column(name = "indicaria_empresa_por_que")
    private String indicariaEmpresaPorQue;

    @Column(name = "expectativa_produto")
    private String expectativaProduto;

    @Column(name = "sente_falta_na_loja")
    private String senteFaltaNaLoja;

    @Column(name = "prioridade_preco_qualidade_atendimento")
    private String prioridadePrecoQualidadeAtendimento;

    @Column(name = "tipo_calcado_procurado")
    private String tipoCalcadoProcurado;

    @Column(name = "canal_comunicacao_preferido")
    private String canalComunicacaoPreferido;

    @Column(name = "frequencia_receber_promocoes")
    private String frequenciaReceberPromocoes;

    @Column(name = "participa_programa_fidelidade")
    private String participaProgramaFidelidade;

    @Column(name = "interesse_pesquisas_satisfacao")
    private String interessePesquisasSatisfacao;
    
    
    public EmpresaModel() {
    }

    public EmpresaModel(String nome, String email, String senha, String telefone, String endereco, String motivoBuscaProduto, String produtoOuServicoAnterior, String frequenciaCompras, String ticketMedio, String preferenciaPagamento, String comoConheceuEmpresa, String experienciaCompra, String pontoPositivo, String teveProblemaCompra, String indicariaEmpresaPorQue, String expectativaProduto, String senteFaltaNaLoja, String prioridadePrecoQualidadeAtendimento, String tipoCalcadoProcurado, String canalComunicacaoPreferido, String frequenciaReceberPromocoes, String participaProgramaFidelidade, String interessePesquisasSatisfacao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = LocalDateTime.now();
        this.telefone = telefone;
        this.endereco = endereco;
        this.motivoBuscaProduto = motivoBuscaProduto;
        this.produtoOuServicoAnterior = produtoOuServicoAnterior;
        this.frequenciaCompras = frequenciaCompras;
        this.ticketMedio = ticketMedio;
        this.preferenciaPagamento = preferenciaPagamento;
        this.comoConheceuEmpresa = comoConheceuEmpresa;
        this.experienciaCompra = experienciaCompra;
        this.pontoPositivo = pontoPositivo;
        this.teveProblemaCompra = teveProblemaCompra;
        this.indicariaEmpresaPorQue = indicariaEmpresaPorQue;
        this.expectativaProduto = expectativaProduto;
        this.senteFaltaNaLoja = senteFaltaNaLoja;
    }
    
    
}
