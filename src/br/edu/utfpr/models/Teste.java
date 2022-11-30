/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.models;

import br.edu.utfpr.entidades.Compra;

/**
 *
 * @author thiag
 */
public class Teste extends AbstractListModelImpl<Compra>{

    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertModel(Compra obj) {
        super.insertModel(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeModel(int indexRow) {
        super.removeModel(indexRow); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizarModel(int indiceLinha, Compra obj) {
        super.atualizarModel(indiceLinha, obj); //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
