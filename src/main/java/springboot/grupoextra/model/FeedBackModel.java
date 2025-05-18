package springboot.grupoextra.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "feedback")
@Getter
@Setter
@AllArgsConstructor
public class FeedBackModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "motivo_busca_produto", nullable = false)
    private String motivoBuscaProduto;

    @Column(name = "produto_ou_servico_anterior", nullable = false)
    private String produtoOuServicoAnterior;

    @Column(name = "frequencia_compras", nullable = false)
    private String frequenciaCompras;

    @Column(name = "ticket_medio", nullable = false)
    private String ticketMedio;

    @Column(name = "preferencia_pagamento", nullable = false)
    private String preferenciaPagamento;

    @Column(name = "como_conheceu_empresa", nullable = false)
    private String comoConheceuEmpresa;

    @Column(name = "experiencia_compra", nullable = false)
    private String experienciaCompra;

    @Column(name = "ponto_positivo", nullable = false)
    private String pontoPositivo;

    @Column(name = "teve_problema_compra", nullable = false)
    private String teveProblemaCompra;

    @Column(name = "indicaria_empresa_por_que", nullable = false)
    private String indicariaEmpresaPorQue;

    @Column(name = "expectativa_produto", nullable = false)
    private String expectativaProduto;

    @Column(name = "sente_falta_na_loja", nullable = false)
    private String senteFaltaNaLoja;

    @Column(name = "prioridade_preco_qualidade_atendimento", nullable = false)
    private String prioridadePrecoQualidadeAtendimento;

    @Column(name = "tipo_calcado_procurado", nullable = false)
    private String tipoCalcadoProcurado;

    @Column(name = "canal_comunicacao_preferido", nullable = false)
    private String canalComunicacaoPreferido;

    @Column(name = "frequencia_receber_promocoes", nullable = false)
    private String frequenciaReceberPromocoes;

    @Column(name = "participa_programa_fidelidade", nullable = false)
    private String participaProgramaFidelidade;

    @Column(name = "interesse_pesquisas_satisfacao", nullable = false)
    private String interessePesquisasSatisfacao;

    public FeedBackModel() {
    }
    
}
