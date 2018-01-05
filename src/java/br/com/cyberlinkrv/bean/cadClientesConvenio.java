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
@Table(name = "cad_clientes_convenio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadClientesConvenio.findAll", query = "SELECT c FROM CadClientesConvenio c"),
    @NamedQuery(name = "CadClientesConvenio.findById", query = "SELECT c FROM CadClientesConvenio c WHERE c.id = :id"),
    @NamedQuery(name = "CadClientesConvenio.findByIdClienteMaster", query = "SELECT c FROM CadClientesConvenio c WHERE c.idClienteMaster = :idClienteMaster"),
    @NamedQuery(name = "CadClientesConvenio.findByIdClienteConveniado", query = "SELECT c FROM CadClientesConvenio c WHERE c.idClienteConveniado = :idClienteConveniado")})
public class cadClientesConvenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_master")
    private int idClienteMaster;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente_conveniado")
    private int idClienteConveniado;

    public cadClientesConvenio() {
    }

    public cadClientesConvenio(Integer id) {
        this.id = id;
    }

    public cadClientesConvenio(Integer id, int idClienteMaster, int idClienteConveniado) {
        this.id = id;
        this.idClienteMaster = idClienteMaster;
        this.idClienteConveniado = idClienteConveniado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdClienteMaster() {
        return idClienteMaster;
    }

    public void setIdClienteMaster(int idClienteMaster) {
        this.idClienteMaster = idClienteMaster;
    }

    public int getIdClienteConveniado() {
        return idClienteConveniado;
    }

    public void setIdClienteConveniado(int idClienteConveniado) {
        this.idClienteConveniado = idClienteConveniado;
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
        if (!(object instanceof cadClientesConvenio)) {
            return false;
        }
        cadClientesConvenio other = (cadClientesConvenio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadClientesConvenio[ id=" + id + " ]";
    }
    
}
