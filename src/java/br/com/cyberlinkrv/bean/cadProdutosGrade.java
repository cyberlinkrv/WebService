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
@Table(name = "cad_produtos_grade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadProdutosGrade.findAll", query = "SELECT c FROM CadProdutosGrade c"),
    @NamedQuery(name = "CadProdutosGrade.findById", query = "SELECT c FROM CadProdutosGrade c WHERE c.id = :id"),
    @NamedQuery(name = "CadProdutosGrade.findByIdProduto", query = "SELECT c FROM CadProdutosGrade c WHERE c.idProduto = :idProduto"),
    @NamedQuery(name = "CadProdutosGrade.findByDescricao", query = "SELECT c FROM CadProdutosGrade c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CadProdutosGrade.findByQuantidade", query = "SELECT c FROM CadProdutosGrade c WHERE c.quantidade = :quantidade"),
    @NamedQuery(name = "CadProdutosGrade.findByCodBarra", query = "SELECT c FROM CadProdutosGrade c WHERE c.codBarra = :codBarra")})
public class cadProdutosGrade implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produto")
    private int idProduto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "quantidade")
    private Double quantidade;
    @Size(max = 13)
    @Column(name = "cod_barra")
    private String codBarra;

    public cadProdutosGrade() {
    }

    public cadProdutosGrade(Integer id) {
        this.id = id;
    }

    public cadProdutosGrade(Integer id, int idProduto, String descricao) {
        this.id = id;
        this.idProduto = idProduto;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
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
        if (!(object instanceof cadProdutosGrade)) {
            return false;
        }
        cadProdutosGrade other = (cadProdutosGrade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadProdutosGrade[ id=" + id + " ]";
    }
    
}
