package br.edu.utfpr.models;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public abstract class AbstractListModelImpl<T> extends AbstractTableModel {

    protected List<Object> listaObj = new ArrayList();

    public void insertModel(T obj) {
        listaObj.add(obj);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    ;

    public void removeModel(int indexRow) {
        listaObj.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    ;

    public void atualizarModel(int indiceLinha, T obj) {
        listaObj.set(indiceLinha, obj);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }
;
}
