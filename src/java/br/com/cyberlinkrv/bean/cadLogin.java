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
@Table(name = "cad_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadLogin.findAll", query = "SELECT c FROM CadLogin c"),
    @NamedQuery(name = "CadLogin.findById", query = "SELECT c FROM CadLogin c WHERE c.id = :id"),
    @NamedQuery(name = "CadLogin.findByLogin", query = "SELECT c FROM CadLogin c WHERE c.login = :login"),
    @NamedQuery(name = "CadLogin.findBySenha", query = "SELECT c FROM CadLogin c WHERE c.senha = :senha"),
    @NamedQuery(name = "CadLogin.findByIdPerfil", query = "SELECT c FROM CadLogin c WHERE c.idPerfil = :idPerfil"),
    @NamedQuery(name = "CadLogin.findByOptions", query = "SELECT c FROM CadLogin c WHERE c.options = :options"),
    @NamedQuery(name = "CadLogin.findByInativo", query = "SELECT c FROM CadLogin c WHERE c.inativo = :inativo")})
public class cadLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "login")
    private String login;
    @Size(max = 32)
    @Column(name = "senha")
    private String senha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_perfil")
    private int idPerfil;
    @Size(max = 50)
    @Column(name = "options")
    private String options;
    @Column(name = "inativo")
    private Integer inativo;

    public cadLogin() {
    }

    public cadLogin(Integer id) {
        this.id = id;
    }

    public cadLogin(Integer id, int idPerfil) {
        this.id = id;
        this.idPerfil = idPerfil;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public Integer getInativo() {
        return inativo;
    }

    public void setInativo(Integer inativo) {
        this.inativo = inativo;
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
        if (!(object instanceof cadLogin)) {
            return false;
        }
        cadLogin other = (cadLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadLogin[ id=" + id + " ]";
    }
    
}
