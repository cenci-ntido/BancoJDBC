/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.MateriaPrima;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class MateriaPrimaListModel extends AbstractTableModel {

    private List<MateriaPrima> listaMateriaPrima;

    private String[] colunas = new String[]{"Código", "Descrição", "Unidade", "Saldo"};

    public MateriaPrimaListModel(List<MateriaPrima> listaMateriaPrima) {
        this.listaMateriaPrima = listaMateriaPrima;
    }

    @Override
    public int getRowCount() {
        return listaMateriaPrima.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        MateriaPrima materiaPrima = listaMateriaPrima.get(row);
        switch (column) {
            case 0:
                return materiaPrima.getId();
            case 1:
                return materiaPrima.getDescricao();
            case 2:
                return materiaPrima.getUnidade();
            case 3:
                return materiaPrima.getSaldo();
            default:
                break;
        }
        return materiaPrima;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(MateriaPrima materiaPrima) {
        listaMateriaPrima.add(materiaPrima);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaMateriaPrima.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, MateriaPrima materiaPrima) {
        listaMateriaPrima.set(indiceLinha, materiaPrima);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
