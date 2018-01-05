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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CyberhouseBR
 */
@Entity
@Table(name = "cad_class_fiscal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadClassFiscal.findAll", query = "SELECT c FROM CadClassFiscal c"),
    @NamedQuery(name = "CadClassFiscal.findById", query = "SELECT c FROM CadClassFiscal c WHERE c.id = :id"),
    @NamedQuery(name = "CadClassFiscal.findByLegenda", query = "SELECT c FROM CadClassFiscal c WHERE c.legenda = :legenda"),
    @NamedQuery(name = "CadClassFiscal.findByCodigo", query = "SELECT c FROM CadClassFiscal c WHERE c.codigo = :codigo")})
public class cadClassFiscal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2)
    @Column(name = "legenda")
    private String legenda;
    @Size(max = 20)
    @Column(name = "codigo")
    private String codigo;

    public cadClassFiscal() {
    }

    public cadClassFiscal(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLegenda() {
        return legenda;
    }

    public void setLegenda(String legenda) {
        this.legenda = legenda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
        if (!(object instanceof cadClassFiscal)) {
            return false;
        }
        cadClassFiscal other = (cadClassFiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadClassFiscal[ id=" + id + " ]";
    }
    
}
