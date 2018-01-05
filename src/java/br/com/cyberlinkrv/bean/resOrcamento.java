/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

/**
 *
 * @author CyberhouseBR
 */
public class resOrcamento {
    
   int id;
   String controle;
   String data_venda;
   int id_cliente;
   int id_convenio;
   int id_login;
   int terminal;
   int cod_lancamento;
   Double vr_total;
   int status;
   int quantidade;
   Double vr_unitario;

    public resOrcamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_convenio() {
        return id_convenio;
    }

    public void setId_convenio(int id_convenio) {
        this.id_convenio = id_convenio;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getCod_lancamento() {
        return cod_lancamento;
    }

    public void setCod_lancamento(int cod_lancamento) {
        this.cod_lancamento = cod_lancamento;
    }

    public Double getVr_total() {
        return vr_total;
    }

    public void setVr_total(Double vr_total) {
        this.vr_total = vr_total;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getVr_unitario() {
        return vr_unitario;
    }

    public void setVr_unitario(Double vr_unitario) {
        this.vr_unitario = vr_unitario;
    }
   
   
   
    
}
