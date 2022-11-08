/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Locacao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class LocacaoListModel extends AbstractTableModel {

    private List<Locacao> listaLocacao;

    private String[] colunas = new String[]{"Código", "Cliente", "Carro", "Descrição", "Data Locação", "Data Devolução", "Preço", "Ativo"};

    public LocacaoListModel(List<Locacao> listaLocacao) {
        this.listaLocacao = listaLocacao;
    }

    @Override
    public int getRowCount() {
        return listaLocacao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Locacao locacao = listaLocacao.get(row);
        switch (column) {
            case 0:
                return locacao.getCodigo();
            case 1:
                return locacao.getCliente();
            case 2:
                return locacao.getCarro();
            case 3:
                return locacao.getDescricao();
            case 4:
                return locacao.getDataLocacao();
            case 5:
                return locacao.getDataDevolucao();
            case 6:
                return locacao.getValor();
            case 7:
                return locacao.getAtivo();
            default:
                break;
        }
        return locacao;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Locacao locacao) {
        listaLocacao.add(locacao);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaLocacao.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Locacao locacao) {
        listaLocacao.set(indiceLinha, locacao);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
