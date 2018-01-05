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
public class resRelatOrcamento {
    
    int id_mvendas;
    int id_vmvendas_;
    String controle;
    Date data_venda;
    String nome_cliente;
    String nome_produt;
    int quantidade;
    String unidade;
    Double valorUnitario;
    Double vr_total;

    public resRelatOrcamento() {
    }

    public int getId_mvendas() {
        return id_mvendas;
    }

    public void setId_mvendas(int id_mvendas) {
        this.id_mvendas = id_mvendas;
    }

    public int getId_vmvendas_() {
        return id_vmvendas_;
    }

    public void setId_vmvendas_(int id_vmvendas_) {
        this.id_vmvendas_ = id_vmvendas_;
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

    public String getNome_produt() {
        return nome_produt;
    }

    public void setNome_produt(String nome_produt) {
        this.nome_produt = nome_produt;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getVr_total() {
        return vr_total;
    }

    public void setVr_total(Double vr_total) {
        this.vr_total = vr_total;
    }
    
    
}
