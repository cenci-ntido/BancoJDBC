package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Producao;
import br.edu.utfpr.formataData.FormataData;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProducaoListModel extends AbstractTableModel {

    private List<Producao> listaProducao;

    private String[] colunas = new String[]{"Código", "Data", "Cod. MP", "Matéria Prima", "Quantidade"};
    private DecimalFormat df = new DecimalFormat("#,###.00");

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
                return FormataData.localDateToString(producao.getData());
            case 2:
                return producao.getMateriaPrima().getId();
            case 3:
                return producao.getMateriaPrima().getDescricao();
            case 4:
                if (producao.getQuantidade() < 1) {
                    return producao.getQuantidade();
                } else {
                    return df.format(producao.getQuantidade());
                }
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
