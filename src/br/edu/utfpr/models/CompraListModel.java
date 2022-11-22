/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class CompraListModel extends AbstractTableModel {

    private List<Compra> listaCompra;

    private String[] colunas = new String[]{"Código", "Data", "Matéria Prima", "Valor", "Quantidade"};
//    private DateTimeFormatter dtf = new DateTimeFormatter();
//    private DecimalFormat df = new DecimalFormat();

    public CompraListModel(List<Compra> listaCompra) {
        this.listaCompra = listaCompra;
    }

    @Override
    public int getRowCount() {
        return listaCompra.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Compra compra = listaCompra.get(row);
        switch (column) {
            case 0:
                return compra.getId();
            case 1:
                return compra.getData();
            case 2:
                return compra.getMateriasPrima().getDescricao();
            case 3:
                return compra.getValor();
            case 4:
                return compra.getQuantidade();
            default:
                break;
        }
        return compra;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Compra compra) {
        listaCompra.add(compra);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaCompra.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Compra compra) {
        listaCompra.set(indiceLinha, compra);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
