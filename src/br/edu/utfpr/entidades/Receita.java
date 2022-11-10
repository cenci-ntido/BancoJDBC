package br.edu.utfpr.entidades;

public class Receita {
    private Integer id;
    private String descricao;
    private Float quantidade;

    public Receita() {
    }

    public Receita(Integer id, String descricao, Float quantidade) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
    
}
