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
import javax.persistence.Lob;
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
@Table(name = "mv_vendas_obs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MvVendasObs.findAll", query = "SELECT m FROM MvVendasObs m"),
    @NamedQuery(name = "MvVendasObs.findById", query = "SELECT m FROM MvVendasObs m WHERE m.id = :id"),
    @NamedQuery(name = "MvVendasObs.findByIdVenda", query = "SELECT m FROM MvVendasObs m WHERE m.idVenda = :idVenda"),
    @NamedQuery(name = "MvVendasObs.findByControle", query = "SELECT m FROM MvVendasObs m WHERE m.controle = :controle")})
public class mvVendasObs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_venda")
    private int idVenda;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "controle")
    private String controle;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacao")
    private String observacao;

    public mvVendasObs() {
    }

    public mvVendasObs(Integer id) {
        this.id = id;
    }

    public mvVendasObs(Integer id, int idVenda, String controle) {
        this.id = id;
        this.idVenda = idVenda;
        this.controle = controle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
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
        if (!(object instanceof mvVendasObs)) {
            return false;
        }
        mvVendasObs other = (mvVendasObs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.MvVendasObs[ id=" + id + " ]";
    }
    
}
