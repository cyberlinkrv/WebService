/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cyberlinkrv.bean;

import com.mysql.fabric.xmlrpc.base.Data;
import java.util.Date;

/**
 *
 * @author CyberhouseBR
 */
public class resLocporControle {

    int id;
    Date data_venda;
    String controle;
    int cod_lancamento;
    String nome_cliente;
    String nome_produto;
    int terminal;
    Double valor;
    int quant;
    Double vr_total;

    public resLocporControle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public int getCod_lancamento() {
        return cod_lancamento;
    }

    public void setCod_lancamento(int cod_lancamento) {
        this.cod_lancamento = cod_lancamento;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getQuant() {
        return quant;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public Double getVr_total() {
        return vr_total;
    }

    public void setVr_total(Double vr_total) {
        this.vr_total = vr_total;
    }
    
    
}
