/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.views.FrmAdicionaMp;
import br.edu.utfpr.views.FrmAdicionaMp;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class FrmAdicionaMpListModel extends AbstractTableModel {

    private List<FrmAdicionaMp> listaMp;

    private String[] colunas = new String[]{"Matéria Prima", "Quantidade"};

    public FrmAdicionaMpListModel(List<FrmAdicionaMp> listaMp) {
        this.listaMp = listaMp;
    }

    @Override
    public int getRowCount() {
        return listaMp.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        FrmAdicionaMp frmAdicionaMp = listaMp.get(row);
        switch (column) {
            case 0:
                return frmAdicionaMp.getSelectedMp().getDescricao();
            case 1:
                return frmAdicionaMp.getQuantidade();
            default:
                break;
        }
        return frmAdicionaMp;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(FrmAdicionaMp frmAdicionaMp) {
        listaMp.add(frmAdicionaMp);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaMp.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, FrmAdicionaMp frmAdicionaMp) {
        listaMp.set(indiceLinha, frmAdicionaMp);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
