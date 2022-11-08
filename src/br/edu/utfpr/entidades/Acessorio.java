package br.edu.utfpr.entidades;

/**
 *
 * @author Andreia
 */
public class Acessorio {
    private Integer codigo;
    private String descricao;
    private int quantidade;
    private double preco;
    private Carro carro;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    @Override
    public String toString() {
        return "Acessorio{" + "codigo=" + codigo + ", descricao=" + descricao + ", quantidade=" + quantidade + ", preco=" + preco + ", carro=" + carro + '}';
    }
 
    
}
