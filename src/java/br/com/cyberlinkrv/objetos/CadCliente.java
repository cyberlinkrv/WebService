package br.com.cyberlinkrv.objetos;

import java.sql.Date;

/**
 *
 * @author Cyber_Link_Recepcao
 */
public class CadCliente {
    
    int id; //NN
    String cod_barra;
    String nome_cliente;
    String cep;
    String endereco;
    String bairro;
    String cidade;
    String uf;
    String email;
    String telefone;
    String celular;
    String cpf_cnpj;
    String rg_ie;
    String inf_adicional;
    double faixa_salarial;
    double vr_maximo_compra;
    double desconto_autom;
    double saldo_compras;
    int pontos;
    int enviar_email;
    int inativo;
    int nascimento_dia;
    int nascimento_mes;
    String nascimento_ano;
    Date data_cadastro;
    Date data_ultima_alteracao;
    
    
    public CadCliente(){
        
    }

    public CadCliente(int id, String cod_barra, String nome_cliente, String cep, String endereco, String bairro, String cidade, String uf, String email, String telefone, String celular, String cpf_cnpj, String rg_ie, String inf_adicional, double faixa_salarial, double vr_maximo_compra, double desconto_autom, double saldo_compras, int pontos, int enviar_email, int inativo, int nascimento_dia, int nascimento_mes, String nascimento_ano, Date data_cadastro, Date data_ultima_alteracao) {
        this.id = id;
        this.cod_barra = cod_barra;
        this.nome_cliente = nome_cliente;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.cpf_cnpj = cpf_cnpj;
        this.rg_ie = rg_ie;
        this.inf_adicional = inf_adicional;
        this.faixa_salarial = faixa_salarial;
        this.vr_maximo_compra = vr_maximo_compra;
        this.desconto_autom = desconto_autom;
        this.saldo_compras = saldo_compras;
        this.pontos = pontos;
        this.enviar_email = enviar_email;
        this.inativo = inativo;
        this.nascimento_dia = nascimento_dia;
        this.nascimento_mes = nascimento_mes;
        this.nascimento_ano = nascimento_ano;
        this.data_cadastro = data_cadastro;
        this.data_ultima_alteracao = data_ultima_alteracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
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

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getRg_ie() {
        return rg_ie;
    }

    public void setRg_ie(String rg_ie) {
        this.rg_ie = rg_ie;
    }

    public String getInf_adicional() {
        return inf_adicional;
    }

    public void setInf_adicional(String inf_adicional) {
        this.inf_adicional = inf_adicional;
    }

    public double getFaixa_salarial() {
        return faixa_salarial;
    }

    public void setFaixa_salarial(double faixa_salarial) {
        this.faixa_salarial = faixa_salarial;
    }

    public double getVr_maximo_compra() {
        return vr_maximo_compra;
    }

    public void setVr_maximo_compra(double vr_maximo_compra) {
        this.vr_maximo_compra = vr_maximo_compra;
    }

    public double getDesconto_autom() {
        return desconto_autom;
    }

    public void setDesconto_autom(double desconto_autom) {
        this.desconto_autom = desconto_autom;
    }

    public double getSaldo_compras() {
        return saldo_compras;
    }

    public void setSaldo_compras(double saldo_compras) {
        this.saldo_compras = saldo_compras;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getEnviar_email() {
        return enviar_email;
    }

    public void setEnviar_email(int enviar_email) {
        this.enviar_email = enviar_email;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public int getNascimento_dia() {
        return nascimento_dia;
    }

    public void setNascimento_dia(int nascimento_dia) {
        this.nascimento_dia = nascimento_dia;
    }

    public int getNascimento_mes() {
        return nascimento_mes;
    }

    public void setNascimento_mes(int nascimento_mes) {
        this.nascimento_mes = nascimento_mes;
    }

    public String getNascimento_ano() {
        return nascimento_ano;
    }

    public void setNascimento_ano(String nascimento_ano) {
        this.nascimento_ano = nascimento_ano;
    }

    public Date getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public Date getData_ultima_alteracao() {
        return data_ultima_alteracao;
    }

    public void setData_ultima_alteracao(Date data_ultima_alteracao) {
        this.data_ultima_alteracao = data_ultima_alteracao;
    }
    
    
    
    
}
