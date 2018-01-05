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
@Table(name = "cad_moedas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadMoedas.findAll", query = "SELECT c FROM CadMoedas c"),
    @NamedQuery(name = "CadMoedas.findById", query = "SELECT c FROM CadMoedas c WHERE c.id = :id"),
    @NamedQuery(name = "CadMoedas.findByMoeda", query = "SELECT c FROM CadMoedas c WHERE c.moeda = :moeda"),
    @NamedQuery(name = "CadMoedas.findByCotacao", query = "SELECT c FROM CadMoedas c WHERE c.cotacao = :cotacao")})
public class cadMoedas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "moeda")
    private String moeda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cotacao")
    private double cotacao;

    public cadMoedas() {
    }

    public cadMoedas(Integer id) {
        this.id = id;
    }

    public cadMoedas(Integer id, String moeda, double cotacao) {
        this.id = id;
        this.moeda = moeda;
        this.cotacao = cotacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public double getCotacao() {
        return cotacao;
    }

    public void setCotacao(double cotacao) {
        this.cotacao = cotacao;
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
        if (!(object instanceof cadMoedas)) {
            return false;
        }
        cadMoedas other = (cadMoedas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadMoedas[ id=" + id + " ]";
    }
    
}
