package br.edu.utfpr.entidades;

import java.time.LocalDate;
import java.util.List;

public class Compra {
   private Integer id;
   private LocalDate data;
   private Float valor;
   private List<MateriaPrima> materiasPrima;
   private Float quantidade;

    public Compra() {
    }

    public Compra(Integer id, LocalDate data, Float valor, List<MateriaPrima> materiasPrima, Float quantidade) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.materiasPrima = materiasPrima;
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

    public List<MateriaPrima> getMateriasPrima() {
        return materiasPrima;
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

    public void setMateriasPrima(List<MateriaPrima> materiasPrima) {
        this.materiasPrima = materiasPrima;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
   
   
}
