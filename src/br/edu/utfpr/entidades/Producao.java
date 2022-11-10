
package br.edu.utfpr.entidades;

import java.time.LocalDate;


public class Producao {
    private Integer id;
    private Receita receita;
    private LocalDate data;
    private Integer quantidadeReceitas;

    public Producao() {
    }

    public Producao(Integer id, Receita receita, LocalDate data, Integer quantidadeReceitas) {
        this.id = id;
        this.receita = receita;
        this.data = data;
        this.quantidadeReceitas = quantidadeReceitas;
    }

    public Integer getId() {
        return id;
    }

    public Receita getReceita() {
        return receita;
    }

    public LocalDate getData() {
        return data;
    }

    public Integer getQuantidadeReceitas() {
        return quantidadeReceitas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setQuantidadeReceitas(Integer quantidadeReceitas) {
        this.quantidadeReceitas = quantidadeReceitas;
    }
    
}
