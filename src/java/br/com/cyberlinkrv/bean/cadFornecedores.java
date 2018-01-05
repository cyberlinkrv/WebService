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
@Table(name = "cad_fornecedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadFornecedores.findAll", query = "SELECT c FROM CadFornecedores c"),
    @NamedQuery(name = "CadFornecedores.findById", query = "SELECT c FROM CadFornecedores c WHERE c.id = :id"),
    @NamedQuery(name = "CadFornecedores.findByNomeFornecedor", query = "SELECT c FROM CadFornecedores c WHERE c.nomeFornecedor = :nomeFornecedor"),
    @NamedQuery(name = "CadFornecedores.findByCep", query = "SELECT c FROM CadFornecedores c WHERE c.cep = :cep"),
    @NamedQuery(name = "CadFornecedores.findByEndereco", query = "SELECT c FROM CadFornecedores c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "CadFornecedores.findByBairro", query = "SELECT c FROM CadFornecedores c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "CadFornecedores.findByCidade", query = "SELECT c FROM CadFornecedores c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "CadFornecedores.findByUf", query = "SELECT c FROM CadFornecedores c WHERE c.uf = :uf"),
    @NamedQuery(name = "CadFornecedores.findByEmail", query = "SELECT c FROM CadFornecedores c WHERE c.email = :email"),
    @NamedQuery(name = "CadFornecedores.findByTelefone", query = "SELECT c FROM CadFornecedores c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "CadFornecedores.findByFax", query = "SELECT c FROM CadFornecedores c WHERE c.fax = :fax"),
    @NamedQuery(name = "CadFornecedores.findByCpfCnpj", query = "SELECT c FROM CadFornecedores c WHERE c.cpfCnpj = :cpfCnpj"),
    @NamedQuery(name = "CadFornecedores.findByRgIe", query = "SELECT c FROM CadFornecedores c WHERE c.rgIe = :rgIe"),
    @NamedQuery(name = "CadFornecedores.findByContato", query = "SELECT c FROM CadFornecedores c WHERE c.contato = :contato"),
    @NamedQuery(name = "CadFornecedores.findByInativo", query = "SELECT c FROM CadFornecedores c WHERE c.inativo = :inativo"),
    @NamedQuery(name = "CadFornecedores.findByInfAdicional", query = "SELECT c FROM CadFornecedores c WHERE c.infAdicional = :infAdicional")})
public class cadFornecedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 60)
    @Column(name = "nome_fornecedor")
    private String nomeFornecedor;
    @Size(max = 15)
    @Column(name = "cep")
    private String cep;
    @Size(max = 100)
    @Column(name = "endereco")
    private String endereco;
    @Size(max = 60)
    @Column(name = "bairro")
    private String bairro;
    @Size(max = 60)
    @Column(name = "cidade")
    private String cidade;
    @Size(max = 2)
    @Column(name = "uf")
    private String uf;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "telefone")
    private String telefone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 15)
    @Column(name = "fax")
    private String fax;
    @Size(max = 18)
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Size(max = 16)
    @Column(name = "rg_ie")
    private String rgIe;
    @Size(max = 30)
    @Column(name = "contato")
    private String contato;
    @Column(name = "inativo")
    private Integer inativo;
    @Size(max = 255)
    @Column(name = "inf_adicional")
    private String infAdicional;

    public cadFornecedores() {
    }

    public cadFornecedores(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getRgIe() {
        return rgIe;
    }

    public void setRgIe(String rgIe) {
        this.rgIe = rgIe;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Integer getInativo() {
        return inativo;
    }

    public void setInativo(Integer inativo) {
        this.inativo = inativo;
    }

    public String getInfAdicional() {
        return infAdicional;
    }

    public void setInfAdicional(String infAdicional) {
        this.infAdicional = infAdicional;
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
        if (!(object instanceof cadFornecedores)) {
            return false;
        }
        cadFornecedores other = (cadFornecedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadFornecedores[ id=" + id + " ]";
    }
    
}
