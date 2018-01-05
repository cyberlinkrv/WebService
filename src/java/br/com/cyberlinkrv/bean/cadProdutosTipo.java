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
@Table(name = "cad_produtos_tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadProdutosTipo.findAll", query = "SELECT c FROM CadProdutosTipo c"),
    @NamedQuery(name = "CadProdutosTipo.findById", query = "SELECT c FROM CadProdutosTipo c WHERE c.id = :id"),
    @NamedQuery(name = "CadProdutosTipo.findByNomeTipo", query = "SELECT c FROM CadProdutosTipo c WHERE c.nomeTipo = :nomeTipo")})
public class cadProdutosTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_tipo")
    private String nomeTipo;

    public cadProdutosTipo() {
    }

    public cadProdutosTipo(Integer id) {
        this.id = id;
    }

    public cadProdutosTipo(Integer id, String nomeTipo) {
        this.id = id;
        this.nomeTipo = nomeTipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
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
        if (!(object instanceof cadProdutosTipo)) {
            return false;
        }
        cadProdutosTipo other = (cadProdutosTipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadProdutosTipo[ id=" + id + " ]";
    }
    
}
