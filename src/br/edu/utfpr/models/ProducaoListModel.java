/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.entidades.Producao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class ProducaoListModel extends AbstractTableModel {

    private List<Producao> listaProducao;

    private String[] colunas = new String[]{"Código", "Data"};

    public ProducaoListModel(List<Producao> listaProducao) {
        this.listaProducao = listaProducao;
    }

    @Override
    public int getRowCount() {
        return listaProducao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Producao producao = listaProducao.get(row);
        switch (column) {
            case 0:
                return producao.getId();
            case 1:
                return producao.getData();
            default:
                break;
        }
        return producao;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Producao producao) {
        listaProducao.add(producao);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaProducao.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Producao producao) {
        listaProducao.set(indiceLinha, producao);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
