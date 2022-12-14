package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.formataData.FormataData;
import java.text.DecimalFormat;
import java.util.List;

public class CompraListModel extends AbstractListModel<Compra> {

    private DecimalFormat df = new DecimalFormat("#,###.00");

    public CompraListModel(List<Compra> listaCompra) {
        this.listaObj = listaCompra;
        this.colunas = new String[]{"Código", "Data", "Matéria Prima", "Valor", "Quantidade"};
    }

    @Override
    public Object getValueAt(int row, int column) {
        Compra compra = listaObj.get(row);
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

}
