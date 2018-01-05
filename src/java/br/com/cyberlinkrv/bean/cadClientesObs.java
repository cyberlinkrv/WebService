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
@Table(name = "cad_clientes_obs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadClientesObs.findAll", query = "SELECT c FROM CadClientesObs c"),
    @NamedQuery(name = "CadClientesObs.findById", query = "SELECT c FROM CadClientesObs c WHERE c.id = :id"),
    @NamedQuery(name = "CadClientesObs.findByIdCliente", query = "SELECT c FROM CadClientesObs c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "CadClientesObs.findByFotoTipo", query = "SELECT c FROM CadClientesObs c WHERE c.fotoTipo = :fotoTipo")})
public class cadClientesObs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cliente")
    private int idCliente;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacoes")
    private String observacoes;
    @Lob
    @Column(name = "foto")
    private byte[] foto;
    @Size(max = 4)
    @Column(name = "foto_tipo")
    private String fotoTipo;

    public cadClientesObs() {
    }

    public cadClientesObs(Integer id) {
        this.id = id;
    }

    public cadClientesObs(Integer id, int idCliente) {
        this.id = id;
        this.idCliente = idCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getFotoTipo() {
        return fotoTipo;
    }

    public void setFotoTipo(String fotoTipo) {
        this.fotoTipo = fotoTipo;
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
        if (!(object instanceof cadClientesObs)) {
            return false;
        }
        cadClientesObs other = (cadClientesObs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadClientesObs[ id=" + id + " ]";
    }
    
}
