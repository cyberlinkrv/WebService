/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CyberhouseBR
 */
@Entity
@Table(name = "mv_vendas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvVendas.findAll", query = "SELECT m FROM MvVendas m"),
    @NamedQuery(name = "MvVendas.findById", query = "SELECT m FROM MvVendas m WHERE m.id = :id"),
    @NamedQuery(name = "MvVendas.findByControle", query = "SELECT m FROM MvVendas m WHERE m.controle = :controle"),
    @NamedQuery(name = "MvVendas.findByNotaFiscalNumero", query = "SELECT m FROM MvVendas m WHERE m.notaFiscalNumero = :notaFiscalNumero"),
    @NamedQuery(name = "MvVendas.findByDataVenda", query = "SELECT m FROM MvVendas m WHERE m.dataVenda = :dataVenda"),
    @NamedQuery(name = "MvVendas.findByParcelas", query = "SELECT m FROM MvVendas m WHERE m.parcelas = :parcelas"),
    @NamedQuery(name = "MvVendas.findByIdCliente", query = "SELECT m FROM MvVendas m WHERE m.idCliente = :idCliente"),
    @NamedQuery(name = "MvVendas.findByIdClienteConvenio", query = "SELECT m FROM MvVendas m WHERE m.idClienteConvenio = :idClienteConvenio"),
    @NamedQuery(name = "MvVendas.findByIdLogin", query = "SELECT m FROM MvVendas m WHERE m.idLogin = :idLogin"),
    @NamedQuery(name = "MvVendas.findByTerminal", query = "SELECT m FROM MvVendas m WHERE m.terminal = :terminal"),
    @NamedQuery(name = "MvVendas.findByTurno", query = "SELECT m FROM MvVendas m WHERE m.turno = :turno"),
    @NamedQuery(name = "MvVendas.findByVrTotal", query = "SELECT m FROM MvVendas m WHERE m.vrTotal = :vrTotal"),
    @NamedQuery(name = "MvVendas.findByVrAdicional", query = "SELECT m FROM MvVendas m WHERE m.vrAdicional = :vrAdicional"),
    @NamedQuery(name = "MvVendas.findByVrDinheiro", query = "SELECT m FROM MvVendas m WHERE m.vrDinheiro = :vrDinheiro"),
    @NamedQuery(name = "MvVendas.findByVrCheque", query = "SELECT m FROM MvVendas m WHERE m.vrCheque = :vrCheque"),
    @NamedQuery(name = "MvVendas.findByVrCartao", query = "SELECT m FROM MvVendas m WHERE m.vrCartao = :vrCartao"),
    @NamedQuery(name = "MvVendas.findByVrCarne", query = "SELECT m FROM MvVendas m WHERE m.vrCarne = :vrCarne"),
    @NamedQuery(name = "MvVendas.findByVrTicket", query = "SELECT m FROM MvVendas m WHERE m.vrTicket = :vrTicket"),
    @NamedQuery(name = "MvVendas.findByEmAberto", query = "SELECT m FROM MvVendas m WHERE m.emAberto = :emAberto"),
    @NamedQuery(name = "MvVendas.findByVrPagtoParcial", query = "SELECT m FROM MvVendas m WHERE m.vrPagtoParcial = :vrPagtoParcial"),
    @NamedQuery(name = "MvVendas.findByCodLancamento", query = "SELECT m FROM MvVendas m WHERE m.codLancamento = :codLancamento"),
    @NamedQuery(name = "MvVendas.findByWebPagto", query = "SELECT m FROM MvVendas m WHERE m.webPagto = :webPagto")})
public class mvVendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 14)
    @Column(name = "controle")
    private String controle;
    @Size(max = 30)
    @Column(name = "nota_fiscal_numero")
    private String notaFiscalNumero;
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Column(name = "parcelas")
    private Integer parcelas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_convenio")
    private int idClienteConvenio;
    @Column(name = "id_login")
    private Integer idLogin;
    @Size(max = 2)
    @Column(name = "terminal")
    private String terminal;
    @Column(name = "turno")
    private String turno;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vr_total")
    private Double vrTotal;
    @Column(name = "vr_adicional")
    private Double vrAdicional;
    @Column(name = "vr_dinheiro")
    private Double vrDinheiro;
    @Column(name = "vr_cheque")
    private Double vrCheque;
    @Column(name = "vr_cartao")
    private Double vrCartao;
    @Column(name = "vr_carne")
    private Double vrCarne;
    @Column(name = "vr_ticket")
    private Double vrTicket;
    @Basic(optional = false)
    @NotNull
    @Column(name = "em_aberto")
    private int emAberto;
    @Column(name = "vr_pagto_parcial")
    private Double vrPagtoParcial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_lancamento")
    private int codLancamento;
    @Size(max = 100)
    @Column(name = "web_pagto")
    private String webPagto;

    public mvVendas() {
    }

    public mvVendas(Integer id) {
        this.id = id;
    }

    public mvVendas(Integer id, int idCliente, int idClienteConvenio, int emAberto, int codLancamento) {
        this.id = id;
        this.idCliente = idCliente;
        this.idClienteConvenio = idClienteConvenio;
        this.emAberto = emAberto;
        this.codLancamento = codLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getNotaFiscalNumero() {
        return notaFiscalNumero;
    }

    public void setNotaFiscalNumero(String notaFiscalNumero) {
        this.notaFiscalNumero = notaFiscalNumero;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getParcelas() {
        return parcelas;
    }

    public void setParcelas(Integer parcelas) {
        this.parcelas = parcelas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdClienteConvenio() {
        return idClienteConvenio;
    }

    public void setIdClienteConvenio(int idClienteConvenio) {
        this.idClienteConvenio = idClienteConvenio;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Double getVrTotal() {
        return vrTotal;
    }

    public void setVrTotal(Double vrTotal) {
        this.vrTotal = vrTotal;
    }

    public Double getVrAdicional() {
        return vrAdicional;
    }

    public void setVrAdicional(Double vrAdicional) {
        this.vrAdicional = vrAdicional;
    }

    public Double getVrDinheiro() {
        return vrDinheiro;
    }

    public void setVrDinheiro(Double vrDinheiro) {
        this.vrDinheiro = vrDinheiro;
    }

    public Double getVrCheque() {
        return vrCheque;
    }

    public void setVrCheque(Double vrCheque) {
        this.vrCheque = vrCheque;
    }

    public Double getVrCartao() {
        return vrCartao;
    }

    public void setVrCartao(Double vrCartao) {
        this.vrCartao = vrCartao;
    }

    public Double getVrCarne() {
        return vrCarne;
    }

    public void setVrCarne(Double vrCarne) {
        this.vrCarne = vrCarne;
    }

    public Double getVrTicket() {
        return vrTicket;
    }

    public void setVrTicket(Double vrTicket) {
        this.vrTicket = vrTicket;
    }

    public int getEmAberto() {
        return emAberto;
    }

    public void setEmAberto(int emAberto) {
        this.emAberto = emAberto;
    }

    public Double getVrPagtoParcial() {
        return vrPagtoParcial;
    }

    public void setVrPagtoParcial(Double vrPagtoParcial) {
        this.vrPagtoParcial = vrPagtoParcial;
    }

    public int getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(int codLancamento) {
        this.codLancamento = codLancamento;
    }

    public String getWebPagto() {
        return webPagto;
    }

    public void setWebPagto(String webPagto) {
        this.webPagto = webPagto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof mvVendas)) {
            return false;
        }
        mvVendas other = (mvVendas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.MvVendas[ id=" + id + " ]";
    }

    
}
