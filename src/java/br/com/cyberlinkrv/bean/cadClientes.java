/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CyberhouseBR
 */
@Entity
@Table(name = "cad_clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadClientes.findAll", query = "SELECT c FROM CadClientes c"),
    @NamedQuery(name = "CadClientes.findById", query = "SELECT c FROM CadClientes c WHERE c.id = :id"),
    @NamedQuery(name = "CadClientes.findByCodBarra", query = "SELECT c FROM CadClientes c WHERE c.codBarra = :codBarra"),
    @NamedQuery(name = "CadClientes.findByNomeCliente", query = "SELECT c FROM CadClientes c WHERE c.nomeCliente = :nomeCliente"),
    @NamedQuery(name = "CadClientes.findByCep", query = "SELECT c FROM CadClientes c WHERE c.cep = :cep"),
    @NamedQuery(name = "CadClientes.findByEndereco", query = "SELECT c FROM CadClientes c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "CadClientes.findByBairro", query = "SELECT c FROM CadClientes c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "CadClientes.findByCidade", query = "SELECT c FROM CadClientes c WHERE c.cidade = :cidade"),
    @NamedQuery(name = "CadClientes.findByUf", query = "SELECT c FROM CadClientes c WHERE c.uf = :uf"),
    @NamedQuery(name = "CadClientes.findByEmail", query = "SELECT c FROM CadClientes c WHERE c.email = :email"),
    @NamedQuery(name = "CadClientes.findByTelefone", query = "SELECT c FROM CadClientes c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "CadClientes.findByCelular", query = "SELECT c FROM CadClientes c WHERE c.celular = :celular"),
    @NamedQuery(name = "CadClientes.findByCpfCnpj", query = "SELECT c FROM CadClientes c WHERE c.cpfCnpj = :cpfCnpj"),
    @NamedQuery(name = "CadClientes.findByRgIe", query = "SELECT c FROM CadClientes c WHERE c.rgIe = :rgIe"),
    @NamedQuery(name = "CadClientes.findByInfAdicional", query = "SELECT c FROM CadClientes c WHERE c.infAdicional = :infAdicional"),
    @NamedQuery(name = "CadClientes.findByFaixaSalarial", query = "SELECT c FROM CadClientes c WHERE c.faixaSalarial = :faixaSalarial"),
    @NamedQuery(name = "CadClientes.findByVrMaximoCompra", query = "SELECT c FROM CadClientes c WHERE c.vrMaximoCompra = :vrMaximoCompra"),
    @NamedQuery(name = "CadClientes.findByDescontoAutom", query = "SELECT c FROM CadClientes c WHERE c.descontoAutom = :descontoAutom"),
    @NamedQuery(name = "CadClientes.findBySaldoCompras", query = "SELECT c FROM CadClientes c WHERE c.saldoCompras = :saldoCompras"),
    @NamedQuery(name = "CadClientes.findByPontos", query = "SELECT c FROM CadClientes c WHERE c.pontos = :pontos"),
    @NamedQuery(name = "CadClientes.findByEnviarEmail", query = "SELECT c FROM CadClientes c WHERE c.enviarEmail = :enviarEmail"),
    @NamedQuery(name = "CadClientes.findByInativo", query = "SELECT c FROM CadClientes c WHERE c.inativo = :inativo"),
    @NamedQuery(name = "CadClientes.findByNascimentoDia", query = "SELECT c FROM CadClientes c WHERE c.nascimentoDia = :nascimentoDia"),
    @NamedQuery(name = "CadClientes.findByNascimentoMes", query = "SELECT c FROM CadClientes c WHERE c.nascimentoMes = :nascimentoMes"),
    @NamedQuery(name = "CadClientes.findByNascimentoAno", query = "SELECT c FROM CadClientes c WHERE c.nascimentoAno = :nascimentoAno"),
    @NamedQuery(name = "CadClientes.findByDataCadastro", query = "SELECT c FROM CadClientes c WHERE c.dataCadastro = :dataCadastro"),
    @NamedQuery(name = "CadClientes.findByDataUltimaAlteracao", query = "SELECT c FROM CadClientes c WHERE c.dataUltimaAlteracao = :dataUltimaAlteracao")})
public class cadClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 13)
    @Column(name = "cod_barra")
    private String codBarra;
    @Size(max = 60)
    @Column(name = "nome_cliente")
    private String nomeCliente;
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
    @Size(max = 15)
    @Column(name = "celular")
    private String celular;
    @Size(max = 18)
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;
    @Size(max = 16)
    @Column(name = "rg_ie")
    private String rgIe;
    @Size(max = 255)
    @Column(name = "inf_adicional")
    private String infAdicional;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "faixa_salarial")
    private Double faixaSalarial;
    @Column(name = "vr_maximo_compra")
    private Double vrMaximoCompra;
    @Column(name = "desconto_autom")
    private Double descontoAutom;
    @Column(name = "saldo_compras")
    private Double saldoCompras;
    @Column(name = "pontos")
    private Integer pontos;
    @Column(name = "enviar_email")
    private Integer enviarEmail;
    @Column(name = "inativo")
    private Integer inativo;
    @Column(name = "nascimento_dia")
    private Integer nascimentoDia;
    @Column(name = "nascimento_mes")
    private Integer nascimentoMes;
    @Size(max = 4)
    @Column(name = "nascimento_ano")
    private String nascimentoAno;
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;
    @Column(name = "data_ultima_alteracao")
    @Temporal(TemporalType.DATE)
    private Date dataUltimaAlteracao;

    public cadClientes() {
    }

    public cadClientes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getInfAdicional() {
        return infAdicional;
    }

    public void setInfAdicional(String infAdicional) {
        this.infAdicional = infAdicional;
    }

    public Double getFaixaSalarial() {
        return faixaSalarial;
    }

    public void setFaixaSalarial(Double faixaSalarial) {
        this.faixaSalarial = faixaSalarial;
    }

    public Double getVrMaximoCompra() {
        return vrMaximoCompra;
    }

    public void setVrMaximoCompra(Double vrMaximoCompra) {
        this.vrMaximoCompra = vrMaximoCompra;
    }

    public Double getDescontoAutom() {
        return descontoAutom;
    }

    public void setDescontoAutom(Double descontoAutom) {
        this.descontoAutom = descontoAutom;
    }

    public Double getSaldoCompras() {
        return saldoCompras;
    }

    public void setSaldoCompras(Double saldoCompras) {
        this.saldoCompras = saldoCompras;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Integer getEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(Integer enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

    public Integer getInativo() {
        return inativo;
    }

    public void setInativo(Integer inativo) {
        this.inativo = inativo;
    }

    public Integer getNascimentoDia() {
        return nascimentoDia;
    }

    public void setNascimentoDia(Integer nascimentoDia) {
        this.nascimentoDia = nascimentoDia;
    }

    public Integer getNascimentoMes() {
        return nascimentoMes;
    }

    public void setNascimentoMes(Integer nascimentoMes) {
        this.nascimentoMes = nascimentoMes;
    }

    public String getNascimentoAno() {
        return nascimentoAno;
    }

    public void setNascimentoAno(String nascimentoAno) {
        this.nascimentoAno = nascimentoAno;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    @SuppressWarnings({"UnusedAssignment", "SillyAssignment"})
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataUltimaAlteracao() {
        return this.dataUltimaAlteracao;
    }


    public void setDataUltimaAlteracao(Date dataUltimaAlt) {
        
        this.dataUltimaAlteracao = dataUltimaAlt;
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
        if (!(object instanceof cadClientes)) {
            return false;
        }
        cadClientes other = (cadClientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.cyberlinkrv.objetos.newpackage.CadClientes[ id=" + id + " ]";
    }
    
}
