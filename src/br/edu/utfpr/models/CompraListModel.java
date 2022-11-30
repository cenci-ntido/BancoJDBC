package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.formataData.FormataData;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CompraListModel extends AbstractListModelImpl<Compra> {

    private List<Compra> listaCompra;

    private String[] colunas = new String[]{"Código", "Data", "Matéria Prima", "Valor", "Quantidade"};
    private DecimalFormat df = new DecimalFormat("#,###.00");

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
                return FormataData.localDateToString(compra.getData());
            case 2:
                return compra.getMateriasPrima();
            case 3:
                return df.format(compra.getValor());
            case 4:
                return df.format(compra.getQuantidade());
            default:
                break;
        }
        return compra;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public void insertModel(Compra compra) {
        listaCompra.add(compra);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    @Override
    public void removeModel(int indexRow) {
        listaCompra.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    @Override
    public void atualizarModel(int indiceLinha, Compra compra) {
        listaCompra.set(indiceLinha, compra);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
