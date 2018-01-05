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
@Table(name = "mv_vendas_movimento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvVendasMovimento.findAll", query = "SELECT m FROM MvVendasMovimento m"),
    @NamedQuery(name = "MvVendasMovimento.findById", query = "SELECT m FROM MvVendasMovimento m WHERE m.id = :id"),
    @NamedQuery(name = "MvVendasMovimento.findByDataVenda", query = "SELECT m FROM MvVendasMovimento m WHERE m.dataVenda = :dataVenda"),
    @NamedQuery(name = "MvVendasMovimento.findByControle", query = "SELECT m FROM MvVendasMovimento m WHERE m.controle = :controle"),
    @NamedQuery(name = "MvVendasMovimento.findByModoVenda", query = "SELECT m FROM MvVendasMovimento m WHERE m.modoVenda = :modoVenda"),
    @NamedQuery(name = "MvVendasMovimento.findByCodLancamento", query = "SELECT m FROM MvVendasMovimento m WHERE m.codLancamento = :codLancamento"),
    @NamedQuery(name = "MvVendasMovimento.findByIdLogin", query = "SELECT m FROM MvVendasMovimento m WHERE m.idLogin = :idLogin"),
    @NamedQuery(name = "MvVendasMovimento.findByIdCliente", query = "SELECT m FROM MvVendasMovimento m WHERE m.idCliente = :idCliente"),
    @NamedQuery(name = "MvVendasMovimento.findByIdClienteConvenio", query = "SELECT m FROM MvVendasMovimento m WHERE m.idClienteConvenio = :idClienteConvenio"),
    @NamedQuery(name = "MvVendasMovimento.findByIdProduto", query = "SELECT m FROM MvVendasMovimento m WHERE m.idProduto = :idProduto"),
    @NamedQuery(name = "MvVendasMovimento.findByIdGrade", query = "SELECT m FROM MvVendasMovimento m WHERE m.idGrade = :idGrade"),
    @NamedQuery(name = "MvVendasMovimento.findByModoLancamento", query = "SELECT m FROM MvVendasMovimento m WHERE m.modoLancamento = :modoLancamento"),
    @NamedQuery(name = "MvVendasMovimento.findByTerminal", query = "SELECT m FROM MvVendasMovimento m WHERE m.terminal = :terminal"),
    @NamedQuery(name = "MvVendasMovimento.findByTurno", query = "SELECT m FROM MvVendasMovimento m WHERE m.turno = :turno"),
    @NamedQuery(name = "MvVendasMovimento.findByValor", query = "SELECT m FROM MvVendasMovimento m WHERE m.valor = :valor"),
    @NamedQuery(name = "MvVendasMovimento.findByQuant", query = "SELECT m FROM MvVendasMovimento m WHERE m.quant = :quant"),
    @NamedQuery(name = "MvVendasMovimento.findByVrTotal", query = "SELECT m FROM MvVendasMovimento m WHERE m.vrTotal = :vrTotal"),
    @NamedQuery(name = "MvVendasMovimento.findByVrCotacao", query = "SELECT m FROM MvVendasMovimento m WHERE m.vrCotacao = :vrCotacao")})
public class mvVendasMovimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "controle")
    private String controle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modo_venda")
    private int modoVenda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_lancamento")
    private int codLancamento;
    @Column(name = "id_login")
    private Integer idLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_convenio")
    private int idClienteConvenio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private int idProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grade")
    private int idGrade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modo_lancamento")
    private int modoLancamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "terminal")
    private String terminal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "turno")
    private String turno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quant")
    private double quant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vr_total")
    private double vrTotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vr_cotacao")
    private double vrCotacao;

    public mvVendasMovimento() {
    }

    public mvVendasMovimento(Integer id) {
        this.id = id;
    }

    public mvVendasMovimento(Integer id, Date dataVenda, String controle, int modoVenda, int codLancamento, int idCliente, int idClienteConvenio, int idProduto, int idGrade, int modoLancamento, String terminal, String turno, double valor, double quant, double vrTotal, double vrCotacao) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.controle = controle;
        this.modoVenda = modoVenda;
        this.codLancamento = codLancamento;
        this.idCliente = idCliente;
        this.idClienteConvenio = idClienteConvenio;
        this.idProduto = idProduto;
        this.idGrade = idGrade;
        this.modoLancamento = modoLancamento;
        this.terminal = terminal;
        this.turno = turno;
        this.valor = valor;
        this.quant = quant;
        this.vrTotal = vrTotal;
        this.vrCotacao = vrCotacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public int getModoVenda() {
        return modoVenda;
    }

    public void setModoVenda(int modoVenda) {
        this.modoVenda = modoVenda;
    }

    public int getCodLancamento() {
        return codLancamento;
    }

    public void setCodLancamento(int codLancamento) {
        this.codLancamento = codLancamento;
    }

    public Integer getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Integer idLogin) {
        this.idLogin = idLogin;
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

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdGrade() {
        return idGrade;
    }

    public void setIdGrade(int idGrade) {
        this.idGrade = idGrade;
    }

    public int getModoLancamento() {
        return modoLancamento;
    }

    public void setModoLancamento(int modoLancamento) {
        this.modoLancamento = modoLancamento;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public double getVrTotal() {
        return vrTotal;
    }

    public void setVrTotal(double vrTotal) {
        this.vrTotal = vrTotal;
    }

    public double getVrCotacao() {
        return vrCotacao;
    }

    public void setVrCotacao(double vrCotacao) {
        this.vrCotacao = vrCotacao;
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
        if (!(object instanceof mvVendasMovimento)) {
            return false;
        }
        mvVendasMovimento other = (mvVendasMovimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.MvVendasMovimento[ id=" + id + " ]";
    }
    
}
