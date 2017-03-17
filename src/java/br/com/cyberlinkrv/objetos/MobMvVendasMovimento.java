package br.com.cyberlinkrv.objetos;

import java.sql.Date;

/**
 *
 * @author Cyber_Link_Recepcao
 */
public class MobMvVendasMovimento {

    int id;
    Date data_venda;
    String controle;
    int modo_venda;
    int cod_lancamento;
    int id_login;
    int id_cliente;
    int id_cliente_convenio;
    int id_produto;
    int id_grade;
    int modo_lancamento;
    String terminal;
    String turno;
    double valor;
    double quant;
    double vr_total;
    double vr_cotacao;

    public MobMvVendasMovimento() {
    }

    public MobMvVendasMovimento(int id, Date data_venda, String controle, int modo_venda, int cod_lancamento, int id_login, int id_cliente, int id_cliente_convenio, int id_produto, int id_grade, int modo_lancamento, String terminal, String turno, double valor, double quant, double vr_total, double vr_cotacao) {
        this.id = id;
        this.data_venda = data_venda;
        this.controle = controle;
        this.modo_venda = modo_venda;
        this.cod_lancamento = cod_lancamento;
        this.id_login = id_login;
        this.id_cliente = id_cliente;
        this.id_cliente_convenio = id_cliente_convenio;
        this.id_produto = id_produto;
        this.id_grade = id_grade;
        this.modo_lancamento = modo_lancamento;
        this.terminal = terminal;
        this.turno = turno;
        this.valor = valor;
        this.quant = quant;
        this.vr_total = vr_total;
        this.vr_cotacao = vr_cotacao;
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

    public int getModo_venda() {
        return modo_venda;
    }

    public void setModo_venda(int modo_venda) {
        this.modo_venda = modo_venda;
    }

    public int getCod_lancamento() {
        return cod_lancamento;
    }

    public void setCod_lancamento(int cod_lancamento) {
        this.cod_lancamento = cod_lancamento;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
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

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_grade() {
        return id_grade;
    }

    public void setId_grade(int id_grade) {
        this.id_grade = id_grade;
    }

    public int getModo_lancamento() {
        return modo_lancamento;
    }

    public void setModo_lancamento(int modo_lancamento) {
        this.modo_lancamento = modo_lancamento;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getQuant() {
        return quant;
    }

    public void setQuant(double quant) {
        this.quant = quant;
    }

    public double getVr_total() {
        return vr_total;
    }

    public void setVr_total(double vr_total) {
        this.vr_total = vr_total;
    }

    public double getVr_cotacao() {
        return vr_cotacao;
    }

    public void setVr_cotacao(double vr_cotacao) {
        this.vr_cotacao = vr_cotacao;
    }

}
