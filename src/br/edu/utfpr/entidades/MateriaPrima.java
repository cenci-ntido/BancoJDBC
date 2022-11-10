package br.edu.utfpr.entidades;


public class MateriaPrima {
    private Integer id;
    private String descricao;
    private String unidade;
    private Float saldo;

    public MateriaPrima() {
    }

    public MateriaPrima(Integer id, String descricao, String unidade, Float saldo) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.saldo = saldo;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }
    
    
}
