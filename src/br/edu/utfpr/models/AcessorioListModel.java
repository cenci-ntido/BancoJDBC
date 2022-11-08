/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Acessorio;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class AcessorioListModel extends AbstractTableModel {

    private List<Acessorio> listaAcessorio;

    private String[] colunas = new String[]{"Código", "Descricao", "Quantidade", "Preço", "Total"};

    public AcessorioListModel(List<Acessorio> listaAcessorio) {
        this.listaAcessorio = listaAcessorio;
    }

    @Override
    public int getRowCount() {
        return listaAcessorio.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Acessorio acessorio = listaAcessorio.get(row);
        switch (column) {
            case 0:
                return acessorio.getCodigo();
            case 1:
                return acessorio.getDescricao();
            case 2:
                return acessorio.getQuantidade();
            case 3:
                return acessorio.getPreco();
            case 4:
                return acessorio.getQuantidade() * acessorio.getPreco(); 
            default:
                break;
        }
        return acessorio;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Acessorio acessorio) {
        listaAcessorio.add(acessorio);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaAcessorio.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Acessorio acessorio) {
        listaAcessorio.set(indiceLinha, acessorio);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
