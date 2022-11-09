/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Carro;
import br.edu.utfpr.entidades.Cliente;
import br.edu.utfpr.entidades.Locacao;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thiag
 */
public class LocacaoDao extends AbstractDaoImpl<Locacao> {

    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public Locacao insert(Locacao locacao) {
        try {
            pstm = getConn().prepareStatement("INSERT INTO locacao "
                    + "(idcliente, idcarro, descricao, datalocacao, datadevolucao, preco, ativo)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, locacao.getCliente().getCodigo());
            pstm.setInt(2, locacao.getCarro().getCodigo());
            pstm.setString(3, locacao.getDescricao());
            pstm.setDate(4, Date.valueOf(locacao.getDataLocacao()));
            pstm.setDate(5, Date.valueOf(locacao.getDataDevolucao()));
            pstm.setDouble(6, locacao.getValor());
            pstm.setBoolean(6, locacao.getAtivo());
            
            if(pstm.executeUpdate() > 0){
                rs = pstm.getGeneratedKeys();
                rs.next();
                return mount(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Locacao update(Locacao obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao findById(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Locacao> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Locacao mount(ResultSet res) {
        try {
            Cliente cliente = new Cliente();
            try {
                cliente.setCodigo(res.getInt("idCliente"));
            } catch (SQLException ex) {
                Logger.getLogger(LocacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Carro carro = new Carro();
            carro.setCodigo(res.getInt("idCarro"));
            Locacao locacao = new Locacao();
            locacao.setDescricao(rs.getString("descricao"));
            return locacao;
        } catch (SQLException ex) {
            Logger.getLogger(LocacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Locacao> mountList(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
