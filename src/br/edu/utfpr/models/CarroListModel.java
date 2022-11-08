/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Carro;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Andreia
 */
public class CarroListModel extends AbstractTableModel {

    private List<Carro> listaCarro;

    private String[] colunas = new String[]{"Código", "Modelo", "Marca", "Ano Modelo", "Ano Fabricação"};

    public CarroListModel(List<Carro> listaCarro) {
        this.listaCarro = listaCarro;
    }

    @Override
    public int getRowCount() {
        return listaCarro.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Carro carro = listaCarro.get(row);
        switch (column) {
            case 0:
                return carro.getCodigo();
            case 1:
                return carro.getMarca();
            case 2:
                return carro.getModelo();
            case 3:
                return carro.getAnoModelo();
            case 4:
                return carro.getAnoFabricacao();
            default:
                break;
        }
        return carro;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    public void insertModel(Carro carro) {
        listaCarro.add(carro);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void removeModel(int indexRow) {
        listaCarro.remove(indexRow);
        fireTableRowsDeleted(indexRow, indexRow);
    }

    public void atualizarModel(int indiceLinha, Carro carro) {
        listaCarro.set(indiceLinha, carro);
        fireTableRowsUpdated(indiceLinha, indiceLinha);
    }

}
