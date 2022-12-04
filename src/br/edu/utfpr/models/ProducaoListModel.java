package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Producao;
import br.edu.utfpr.formataData.FormataData;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProducaoListModel extends AbstractListModel<Producao> {

    private List<Producao> listaProducao;

    private String[] colunas = new String[]{"Código", "Data", "Matéria Prima", "Quantidade"};
    private DecimalFormat df = new DecimalFormat("#,###.00");

    public ProducaoListModel(List<Producao> listaProducao) {
        this.listaProducao = listaProducao;
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
                return producao.getMateriaPrima();
            case 3:
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

}
