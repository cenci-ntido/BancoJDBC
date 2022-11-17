
package br.edu.utfpr.entidades;

import java.time.LocalDate;


public class Producao {
    private Integer id;
    private LocalDate data;
    private MateriaPrima materiaPrima;
    private Float quantidade;

    public Producao() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public Producao(Integer id, LocalDate data, MateriaPrima materiaPrima, Float quantidade) {
        this.id = id;
        this.data = data;
        this.materiaPrima = materiaPrima;
        this.quantidade = quantidade;
    }

   
   
}
