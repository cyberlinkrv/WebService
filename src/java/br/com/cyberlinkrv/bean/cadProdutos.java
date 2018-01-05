/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CyberhouseBR
 */
@Entity
@Table(name = "cad_produtos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadProdutos.findAll", query = "SELECT c FROM CadProdutos c"),
    @NamedQuery(name = "CadProdutos.findById", query = "SELECT c FROM CadProdutos c WHERE c.id = :id"),
    @NamedQuery(name = "CadProdutos.findByNomeProduto", query = "SELECT c FROM CadProdutos c WHERE c.nomeProduto = :nomeProduto"),
    @NamedQuery(name = "CadProdutos.findByCodBarra", query = "SELECT c FROM CadProdutos c WHERE c.codBarra = :codBarra"),
    @NamedQuery(name = "CadProdutos.findByUnidade", query = "SELECT c FROM CadProdutos c WHERE c.unidade = :unidade"),
    @NamedQuery(name = "CadProdutos.findByInfAdicional", query = "SELECT c FROM CadProdutos c WHERE c.infAdicional = :infAdicional"),
    @NamedQuery(name = "CadProdutos.findByPontos", query = "SELECT c FROM CadProdutos c WHERE c.pontos = :pontos"),
    @NamedQuery(name = "CadProdutos.findByIdMoeda", query = "SELECT c FROM CadProdutos c WHERE c.idMoeda = :idMoeda"),
    @NamedQuery(name = "CadProdutos.findByModoEstoque", query = "SELECT c FROM CadProdutos c WHERE c.modoEstoque = :modoEstoque"),
    @NamedQuery(name = "CadProdutos.findByGrade", query = "SELECT c FROM CadProdutos c WHERE c.grade = :grade"),
    @NamedQuery(name = "CadProdutos.findByKit", query = "SELECT c FROM CadProdutos c WHERE c.kit = :kit"),
    @NamedQuery(name = "CadProdutos.findByIdTipo", query = "SELECT c FROM CadProdutos c WHERE c.idTipo = :idTipo"),
    @NamedQuery(name = "CadProdutos.findByVrCompra", query = "SELECT c FROM CadProdutos c WHERE c.vrCompra = :vrCompra"),
    @NamedQuery(name = "CadProdutos.findByVrVenda", query = "SELECT c FROM CadProdutos c WHERE c.vrVenda = :vrVenda"),
    @NamedQuery(name = "CadProdutos.findByVrVenda2", query = "SELECT c FROM CadProdutos c WHERE c.vrVenda2 = :vrVenda2"),
    @NamedQuery(name = "CadProdutos.findByMinEstoque", query = "SELECT c FROM CadProdutos c WHERE c.minEstoque = :minEstoque"),
    @NamedQuery(name = "CadProdutos.findByEstoque", query = "SELECT c FROM CadProdutos c WHERE c.estoque = :estoque"),
    @NamedQuery(name = "CadProdutos.findByInativo", query = "SELECT c FROM CadProdutos c WHERE c.inativo = :inativo"),
    @NamedQuery(name = "CadProdutos.findByAliqIpi", query = "SELECT c FROM CadProdutos c WHERE c.aliqIpi = :aliqIpi"),
    @NamedQuery(name = "CadProdutos.findByInsideIcmsIpi", query = "SELECT c FROM CadProdutos c WHERE c.insideIcmsIpi = :insideIcmsIpi"),
    @NamedQuery(name = "CadProdutos.findByIdClassFiscal", query = "SELECT c FROM CadProdutos c WHERE c.idClassFiscal = :idClassFiscal"),
    @NamedQuery(name = "CadProdutos.findByAliqIdBaseIcms", query = "SELECT c FROM CadProdutos c WHERE c.aliqIdBaseIcms = :aliqIdBaseIcms"),
    @NamedQuery(name = "CadProdutos.findByOrigemProduto", query = "SELECT c FROM CadProdutos c WHERE c.origemProduto = :origemProduto"),
    @NamedQuery(name = "CadProdutos.findByFracionado", query = "SELECT c FROM CadProdutos c WHERE c.fracionado = :fracionado")})
public class cadProdutos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "nome_produto")
    private String nomeProduto;
    @Size(max = 13)
    @Column(name = "cod_barra")
    private String codBarra;
    @Size(max = 3)
    @Column(name = "unidade")
    private String unidade;
    @Size(max = 30)
    @Column(name = "inf_adicional")
    private String infAdicional;
    @Column(name = "pontos")
    private Integer pontos;
    @Column(name = "id_moeda")
    private Integer idMoeda;
    @Column(name = "modo_estoque")
    private Integer modoEstoque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "grade")
    private int grade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "kit")
    private int kit;
    @Column(name = "id_tipo")
    private Integer idTipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vr_compra")
    private Double vrCompra;
    @Column(name = "vr_venda")
    private Double vrVenda;
    @Column(name = "vr_venda_2")
    private Double vrVenda2;
    @Column(name = "min_estoque")
    private Double minEstoque;
    @Column(name = "estoque")
    private Double estoque;
    @Column(name = "inativo")
    private Integer inativo;
    @Column(name = "aliq_ipi")
    private Double aliqIpi;
    @Column(name = "inside_icms_ipi")
    private Integer insideIcmsIpi;
    @Column(name = "id_class_fiscal")
    private Integer idClassFiscal;
    @Column(name = "aliq_id_base_icms")
    private Integer aliqIdBaseIcms;
    @Column(name = "origem_produto")
    private Integer origemProduto;
    @Column(name = "fracionado")
    private Integer fracionado;

    public cadProdutos() {
    }

    public cadProdutos(Integer id) {
        this.id = id;
    }

    public cadProdutos(Integer id, int grade, int kit) {
        this.id = id;
        this.grade = grade;
        this.kit = kit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getInfAdicional() {
        return infAdicional;
    }

    public void setInfAdicional(String infAdicional) {
        this.infAdicional = infAdicional;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getIdMoeda() {
        return idMoeda;
    }

    public void setIdMoeda(Integer idMoeda) {
        this.idMoeda = idMoeda;
    }

    public Integer getModoEstoque() {
        return modoEstoque;
    }

    public void setModoEstoque(Integer modoEstoque) {
        this.modoEstoque = modoEstoque;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Double getVrCompra() {
        return vrCompra;
    }

    public void setVrCompra(Double vrCompra) {
        this.vrCompra = vrCompra;
    }

    public Double getVrVenda() {
        return vrVenda;
    }

    public void setVrVenda(Double vrVenda) {
        this.vrVenda = vrVenda;
    }

    public Double getVrVenda2() {
        return vrVenda2;
    }

    public void setVrVenda2(Double vrVenda2) {
        this.vrVenda2 = vrVenda2;
    }

    public Double getMinEstoque() {
        return minEstoque;
    }

    public void setMinEstoque(Double minEstoque) {
        this.minEstoque = minEstoque;
    }

    public Double getEstoque() {
        return estoque;
    }

    public void setEstoque(Double estoque) {
        this.estoque = estoque;
    }

    public Integer getInativo() {
        return inativo;
    }

    public void setInativo(Integer inativo) {
        this.inativo = inativo;
    }

    public Double getAliqIpi() {
        return aliqIpi;
    }

    public void setAliqIpi(Double aliqIpi) {
        this.aliqIpi = aliqIpi;
    }

    public Integer getInsideIcmsIpi() {
        return insideIcmsIpi;
    }

    public void setInsideIcmsIpi(Integer insideIcmsIpi) {
        this.insideIcmsIpi = insideIcmsIpi;
    }

    public Integer getIdClassFiscal() {
        return idClassFiscal;
    }

    public void setIdClassFiscal(Integer idClassFiscal) {
        this.idClassFiscal = idClassFiscal;
    }

    public Integer getAliqIdBaseIcms() {
        return aliqIdBaseIcms;
    }

    public void setAliqIdBaseIcms(Integer aliqIdBaseIcms) {
        this.aliqIdBaseIcms = aliqIdBaseIcms;
    }

    public Integer getOrigemProduto() {
        return origemProduto;
    }

    public void setOrigemProduto(Integer origemProduto) {
        this.origemProduto = origemProduto;
    }

    public Integer getFracionado() {
        return fracionado;
    }

    public void setFracionado(Integer fracionado) {
        this.fracionado = fracionado;
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
        if (!(object instanceof cadProdutos)) {
            return false;
        }
        cadProdutos other = (cadProdutos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadProdutos[ id=" + id + " ]";
    }
    
}
