package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.entidades.Producao;
import formataData.FormataData;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProdMpListModel extends AbstractTableModel {

    private List<MateriaPrima> listaMp;

    private String[] colunas = new String[]{"Código", "Matéria Prima", "Quantidade"};
 

    public ProdMpListModel(List<MateriaPrima> listaMp) {
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
        MateriaPrima mp = listaMp.get(row);
        switch (column) {
            case 0:
                return mp.getId();
            case 1:
                 return mp.getDescricao();
            case 2:
                 return "0";
            default:
                break;
        }
        return mp;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel( MateriaPrima mp) {
        listaMp.add(mp);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaMp.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, MateriaPrima mp) {
        listaMp.set(indiceLinha, mp);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
