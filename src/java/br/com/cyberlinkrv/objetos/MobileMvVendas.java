package br.com.cyberlinkrv.objetos;

import java.sql.Date;
/**
 *
 * @author Cyber_Link_Recepcao
 */
public class MobileMvVendas {

	private int id; // - NN
	private String controle;
	private String nota_fiscal_numero;
	private Date data_venda;
	private int parcelas;
	private int id_cliente; // - NN
	private int id_cliente_convenio; // - NN
	private int id_login;
	private String terminal;
	private String turno;
	private double vr_total;
	private double vr_adicional;
	private double vr_dinheiro;
	private double vr_cheque;
	private double vr_cartao;
	private double vr_carne;
	private double vr_ticket;
	private int em_aberto; // - NN
	private double vr_pagto_parcial;
	private int cod_lancamento; // - NN
	private String web_pagto;

	public MobileMvVendas() {

	}

	public MobileMvVendas(int id, String controle, String nota_fiscal_numero, Date data_venda, int parcelas,
			int id_cliente, int id_cliente_convenio, int id_login, String terminal, String turno, double vr_total,
			double vr_adicional, double vr_dinheiro, double vr_cheque, double vr_cartao, double vr_carne,
			double vr_ticket, int em_aberto, double vr_pagto_parcial, int cod_lancamento, String web_pagto) {
		super();
		this.id = id;
		this.controle = controle;
		this.nota_fiscal_numero = nota_fiscal_numero;
		this.data_venda = data_venda;
		this.parcelas = parcelas;
		this.id_cliente = id_cliente;
		this.id_cliente_convenio = id_cliente_convenio;
		this.id_login = id_login;
		this.terminal = terminal;
		this.turno = turno;
		this.vr_total = vr_total;
		this.vr_adicional = vr_adicional;
		this.vr_dinheiro = vr_dinheiro;
		this.vr_cheque = vr_cheque;
		this.vr_cartao = vr_cartao;
		this.vr_carne = vr_carne;
		this.vr_ticket = vr_ticket;
		this.em_aberto = em_aberto;
		this.vr_pagto_parcial = vr_pagto_parcial;
		this.cod_lancamento = cod_lancamento;
		this.web_pagto = web_pagto;
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

	public String getNota_fiscal_numero() {
		return nota_fiscal_numero;
	}

	public void setNota_fiscal_numero(String nota_fiscal_numero) {
		this.nota_fiscal_numero = nota_fiscal_numero;
	}

	public Date getData_venda() {
		return data_venda;
	}

	public void setData_venda(Date data_venda) {
		this.data_venda = data_venda;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public double getVr_total() {
		return vr_total;
	}

	public void setVr_total(double vr_total) {
		this.vr_total = vr_total;
	}

	public double getVr_adicional() {
		return vr_adicional;
	}

	public void setVr_adicional(double vr_adicional) {
		this.vr_adicional = vr_adicional;
	}

	public double getVr_dinheiro() {
		return vr_dinheiro;
	}

	public void setVr_dinheiro(double vr_dinheiro) {
		this.vr_dinheiro = vr_dinheiro;
	}

	public double getVr_cheque() {
		return vr_cheque;
	}

	public void setVr_cheque(double vr_cheque) {
		this.vr_cheque = vr_cheque;
	}

	public double getVr_cartao() {
		return vr_cartao;
	}

	public void setVr_cartao(double vr_cartao) {
		this.vr_cartao = vr_cartao;
	}

	public double getVr_carne() {
		return vr_carne;
	}

	public void setVr_carne(double vr_carne) {
		this.vr_carne = vr_carne;
	}

	public double getVr_ticket() {
		return vr_ticket;
	}

	public void setVr_ticket(double vr_ticket) {
		this.vr_ticket = vr_ticket;
	}

	public int getEm_aberto() {
		return em_aberto;
	}

	public void setEm_aberto(int em_aberto) {
		this.em_aberto = em_aberto;
	}

	public double getVr_pagto_parcial() {
		return vr_pagto_parcial;
	}

	public void setVr_pagto_parcial(double vr_pagto_parcial) {
		this.vr_pagto_parcial = vr_pagto_parcial;
	}

	public int getCod_lancamento() {
		return cod_lancamento;
	}

	public void setCod_lancamento(int cod_lancamento) {
		this.cod_lancamento = cod_lancamento;
	}

	public String getWeb_pagto() {
		return web_pagto;
	}

	public void setWeb_pagto(String web_pagto) {
		this.web_pagto = web_pagto;
	}

}
