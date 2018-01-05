/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

import java.util.Date;

/**
 *
 * @author CyberhouseBR
 */
public class resListaOrc {

    int id;
    String controle;
    Date data_venda;
    String nome_cliente;
    int id_cliente_convenio;
    int id_login;
    Double vr_total;
    int em_aberto;
    int cod_lancamento;

    public resListaOrc() {
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

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public int getId_cliente_convenio() {
        return id_cliente_convenio;
    }

    public void setId_cliente_convenio(int id_cliente_convenio) {
        this.id_cliente_convenio = id_cliente_convenio;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public Double getVr_total() {
        return vr_total;
    }

    public void setVr_total(Double vr_total) {
        this.vr_total = vr_total;
    }

    public int getEm_aberto() {
        return em_aberto;
    }

    public void setEm_aberto(int em_aberto) {
        this.em_aberto = em_aberto;
    }

    public int getCod_lancamento() {
        return cod_lancamento;
    }

    public void setCod_lancamento(int cod_lancamento) {
        this.cod_lancamento = cod_lancamento;
    }
    
    

}
