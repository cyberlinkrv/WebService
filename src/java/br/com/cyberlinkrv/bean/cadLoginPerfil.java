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
@Table(name = "cad_login_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadLoginPerfil.findAll", query = "SELECT c FROM CadLoginPerfil c"),
    @NamedQuery(name = "CadLoginPerfil.findByIdPerfil", query = "SELECT c FROM CadLoginPerfil c WHERE c.idPerfil = :idPerfil"),
    @NamedQuery(name = "CadLoginPerfil.findByNomePerfil", query = "SELECT c FROM CadLoginPerfil c WHERE c.nomePerfil = :nomePerfil"),
    @NamedQuery(name = "CadLoginPerfil.findByMenuOptions", query = "SELECT c FROM CadLoginPerfil c WHERE c.menuOptions = :menuOptions")})
public class cadLoginPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil")
    private Integer idPerfil;
    @Size(max = 30)
    @Column(name = "nome_perfil")
    private String nomePerfil;
    @Size(max = 250)
    @Column(name = "menu_options")
    private String menuOptions;

    public cadLoginPerfil() {
    }

    public cadLoginPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public Integer getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }

    public String getMenuOptions() {
        return menuOptions;
    }

    public void setMenuOptions(String menuOptions) {
        this.menuOptions = menuOptions;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerfil != null ? idPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof cadLoginPerfil)) {
            return false;
        }
        cadLoginPerfil other = (cadLoginPerfil) object;
        if ((this.idPerfil == null && other.idPerfil != null) || (this.idPerfil != null && !this.idPerfil.equals(other.idPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadLoginPerfil[ idPerfil=" + idPerfil + " ]";
    }
    
}
