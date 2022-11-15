package br.edu.utfpr.entidades;

import java.time.LocalDate;
import java.util.List;

public class Compra {
   private Integer id;
   private LocalDate data;
   private Float valor;
   private MateriaPrima materiaPrima;
   private Float quantidade;

    public Compra() {
    }

    public Compra(Integer id, LocalDate data, Float valor, MateriaPrima materiaPrima, Float quantidade) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.materiaPrima = materiaPrima;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Float getValor() {
        return valor;
    }

    public MateriaPrima getMateriasPrima() {
        return materiaPrima;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public void setMateriasPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
   
   
}
