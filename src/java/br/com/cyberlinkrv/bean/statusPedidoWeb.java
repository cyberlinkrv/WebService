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
@Table(name = "status_pedido_web")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusPedidoWeb.findAll", query = "SELECT s FROM StatusPedidoWeb s"),
    @NamedQuery(name = "StatusPedidoWeb.findById", query = "SELECT s FROM StatusPedidoWeb s WHERE s.id = :id"),
    @NamedQuery(name = "StatusPedidoWeb.findByStatus", query = "SELECT s FROM StatusPedidoWeb s WHERE s.status = :status"),
    @NamedQuery(name = "StatusPedidoWeb.findByMvVendasId", query = "SELECT s FROM StatusPedidoWeb s WHERE s.mvVendasId = :mvVendasId")})
public class statusPedidoWeb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mv_vendas_id")
    private int mvVendasId;

    public statusPedidoWeb() {
    }

    public statusPedidoWeb(Integer id) {
        this.id = id;
    }

    public statusPedidoWeb(Integer id, String status, int mvVendasId) {
        this.id = id;
        this.status = status;
        this.mvVendasId = mvVendasId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMvVendasId() {
        return mvVendasId;
    }

    public void setMvVendasId(int mvVendasId) {
        this.mvVendasId = mvVendasId;
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
        if (!(object instanceof statusPedidoWeb)) {
            return false;
        }
        statusPedidoWeb other = (statusPedidoWeb) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.bean.StatusPedidoWeb[ id=" + id + " ]";
    }
    
}
