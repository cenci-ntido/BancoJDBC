package br.edu.utfpr.models;

import br.edu.utfpr.entidades.MateriaPrima;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MateriaPrimaListModel extends AbstractListModel<MateriaPrima> {

    private List<MateriaPrima> listaMateriaPrima;

    private String[] colunas = new String[]{"Código", "Descrição", "Unidade", "Saldo"};
    private DecimalFormat df = new DecimalFormat("#,###.00");

    public MateriaPrimaListModel(List<MateriaPrima> listaMateriaPrima) {
        this.listaMateriaPrima = listaMateriaPrima;
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
                if (materiaPrima.getSaldo() == 0) {
                    return 0.000;
                } else {
                    return df.format(materiaPrima.getSaldo());
                }
            default:
                break;
        }
        return materiaPrima;
    }

}
