package br.edu.utfpr.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class AbstractListModelImpl<T> extends AbstractTableModel {

    protected List<Object> listaObj = new ArrayList();
    protected String[] colunas = new String[]{};

    @Override

    public void fireTableRowsDeleted(int firstRow, int lastRow) {
        super.fireTableRowsDeleted(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsUpdated(int firstRow, int lastRow) {
        super.fireTableRowsUpdated(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void fireTableRowsInserted(int firstRow, int lastRow) {
        super.fireTableRowsInserted(firstRow, lastRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return listaObj.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(T obj) {
        listaObj.add(obj);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaObj.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, T obj) {
        listaObj.set(indiceLinha, obj);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
