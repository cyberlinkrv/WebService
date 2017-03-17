package br.com.cyberlinkrv.objetos;

/**
 *
 * @author Cyber_Link_Recepcao
 */
public class MobMvVendasObs {

    int id;
    int id_venda;
    String controle;
    String observacao;

    public MobMvVendasObs() {
    }

    public MobMvVendasObs(int id, int id_venda, String controle, String observacao) {
        this.id = id;
        this.id_venda = id_venda;
        this.controle = controle;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getControle() {
        return controle;
    }

    public void setControle(String controle) {
        this.controle = controle;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

}
