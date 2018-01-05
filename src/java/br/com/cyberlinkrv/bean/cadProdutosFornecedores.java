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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CyberhouseBR
 */
@Entity
@Table(name = "cad_produtos_fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadProdutosFornecedores.findAll", query = "SELECT c FROM CadProdutosFornecedores c"),
    @NamedQuery(name = "CadProdutosFornecedores.findById", query = "SELECT c FROM CadProdutosFornecedores c WHERE c.id = :id"),
    @NamedQuery(name = "CadProdutosFornecedores.findByIdProduto", query = "SELECT c FROM CadProdutosFornecedores c WHERE c.idProduto = :idProduto"),
    @NamedQuery(name = "CadProdutosFornecedores.findByIdFornecedor", query = "SELECT c FROM CadProdutosFornecedores c WHERE c.idFornecedor = :idFornecedor")})
public class cadProdutosFornecedores implements Serializable {

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
    @Column(name = "id_fornecedor")
    private int idFornecedor;

    public cadProdutosFornecedores() {
    }

    public cadProdutosFornecedores(Integer id) {
        this.id = id;
    }

    public cadProdutosFornecedores(Integer id, int idProduto, int idFornecedor) {
        this.id = id;
        this.idProduto = idProduto;
        this.idFornecedor = idFornecedor;
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

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
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
        if (!(object instanceof cadProdutosFornecedores)) {
            return false;
        }
        cadProdutosFornecedores other = (cadProdutosFornecedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadProdutosFornecedores[ id=" + id + " ]";
    }
    
}
