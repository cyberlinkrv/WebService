package br.com.cyberlinkrv.objetos;

/**
 *
 * @author Cyber_Link_Recepcao
 */
public class CadProduto {

    int id; //NN
    String nome_produto;
    String cod_barra;
    String unidade;
    String inf_adicional;
    int pontos;
    int id_moeda;
    int modo_estoque;
    int grade; //NN
    int kit; //NN
    int id_tipo;
    double vr_compra;
    double vr_venda;
    double vr_venda_2;
    double min_estoque;
    double estoque;
    int inativo;
    double aliq_ipi;
    int inside_icms_ipi;
    int id_class_fiscal;
    int aliq_id_base_icms;
    int origem_produto;
    int fracionado;

    public CadProduto() {

    }

    public CadProduto(int id, String nome_produto, String cod_barra, String unidade, String inf_adicional, int pontos, int id_moeda, int modo_estoque, int grade, int kit, int id_tipo, double vr_compra, double vr_venda, double vr_venda_2, double min_estoque, double estoque, int inativo, double aliq_ipi, int inside_icms_ipi, int id_class_fiscal, int aliq_id_base_icms, int origem_produto, int fracionado) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.cod_barra = cod_barra;
        this.unidade = unidade;
        this.inf_adicional = inf_adicional;
        this.pontos = pontos;
        this.id_moeda = id_moeda;
        this.modo_estoque = modo_estoque;
        this.grade = grade;
        this.kit = kit;
        this.id_tipo = id_tipo;
        this.vr_compra = vr_compra;
        this.vr_venda = vr_venda;
        this.vr_venda_2 = vr_venda_2;
        this.min_estoque = min_estoque;
        this.estoque = estoque;
        this.inativo = inativo;
        this.aliq_ipi = aliq_ipi;
        this.inside_icms_ipi = inside_icms_ipi;
        this.id_class_fiscal = id_class_fiscal;
        this.aliq_id_base_icms = aliq_id_base_icms;
        this.origem_produto = origem_produto;
        this.fracionado = fracionado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getInf_adicional() {
        return inf_adicional;
    }

    public void setInf_adicional(String inf_adicional) {
        this.inf_adicional = inf_adicional;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getId_moeda() {
        return id_moeda;
    }

    public void setId_moeda(int id_moeda) {
        this.id_moeda = id_moeda;
    }

    public int getModo_estoque() {
        return modo_estoque;
    }

    public void setModo_estoque(int modo_estoque) {
        this.modo_estoque = modo_estoque;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getKit() {
        return kit;
    }

    public void setKit(int kit) {
        this.kit = kit;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public double getVr_compra() {
        return vr_compra;
    }

    public void setVr_compra(double vr_compra) {
        this.vr_compra = vr_compra;
    }

    public double getVr_venda() {
        return vr_venda;
    }

    public void setVr_venda(double vr_venda) {
        this.vr_venda = vr_venda;
    }

    public double getVr_venda_2() {
        return vr_venda_2;
    }

    public void setVr_venda_2(double vr_venda_2) {
        this.vr_venda_2 = vr_venda_2;
    }

    public double getMin_estoque() {
        return min_estoque;
    }

    public void setMin_estoque(double min_estoque) {
        this.min_estoque = min_estoque;
    }

    public double getEstoque() {
        return estoque;
    }

    public void setEstoque(double estoque) {
        this.estoque = estoque;
    }

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public double getAliq_ipi() {
        return aliq_ipi;
    }

    public void setAliq_ipi(double aliq_ipi) {
        this.aliq_ipi = aliq_ipi;
    }

    public int getInside_icms_ipi() {
        return inside_icms_ipi;
    }

    public void setInside_icms_ipi(int inside_icms_ipi) {
        this.inside_icms_ipi = inside_icms_ipi;
    }

    public int getId_class_fiscal() {
        return id_class_fiscal;
    }

    public void setId_class_fiscal(int id_class_fiscal) {
        this.id_class_fiscal = id_class_fiscal;
    }

    public int getAliq_id_base_icms() {
        return aliq_id_base_icms;
    }

    public void setAliq_id_base_icms(int aliq_id_base_icms) {
        this.aliq_id_base_icms = aliq_id_base_icms;
    }

    public int getOrigem_produto() {
        return origem_produto;
    }

    public void setOrigem_produto(int origem_produto) {
        this.origem_produto = origem_produto;
    }

    public int getFracionado() {
        return fracionado;
    }

    public void setFracionado(int fracionado) {
        this.fracionado = fracionado;
    }

}
