package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Carro;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;


public class CarroDao extends AbstractDaoImpl<Carro> {

    private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Carro insert(Carro carro) {
        try {
            pstm = getConn().prepareStatement("INSERT INTO carro "
                    + "(modelo, marca, anomodelo, anofabricacao) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//Statement.RETURN_GENERATED_KEYS permite recuperar as chaves geradas automaticamente por meio do método getGeneratedKeys
            pstm.setString(1, carro.getModelo());
            pstm.setString(2, carro.getMarca());
            pstm.setInt(3, carro.getAnoModelo());
            pstm.setInt(4, carro.getAnoFabricacao());
            if (pstm.executeUpdate() > 0) { //Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                carro.setCodigo(rs.getInt("idcarro"));
                return carro;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir carro " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }

    }

    @Override
    public List<Carro> findAll() {
        try {
            pstm = getConn().prepareStatement("SELECT * FROM carro");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            pstm = getConn().prepareStatement("DELETE FROM carro WHERE idcarro = ?");
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o carro." + ex.getMessage());
            return false;
        } finally {
            super.closePreparedStatement(pstm);
        }
    }

    @Override
    public Carro findById(int id) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from carro WHERE idcarro = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar item do pedido. " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Carro update(Carro carro) {
        try {
            pstm = getConn().prepareStatement("UPDATE carro "
                    + "SET modelo=?, marca=?, anomodelo=?, anofabricacao=? "
                    + "WHERE idcarro=?");

            pstm.setString(1, carro.getModelo());
            pstm.setString(2, carro.getMarca());
            pstm.setInt(3, carro.getAnoModelo());
            pstm.setInt(4, carro.getAnoFabricacao());
            pstm.setInt(5, carro.getCodigo());
            if (pstm.executeUpdate() > 0) {
                return carro;
            }
            return null;

            // Se a atualização acontecer corretamente, o valor é a quantidade de linhas afetada na execuação,
            //senão retorna 0 indicando que a  atualização não afetou nenhuma linha.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar item do pedido. " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }


    @Override
    public Carro mount(ResultSet res) {
        try {
            Carro carro = new Carro();
            carro.setCodigo(rs.getInt("idcarro"));
            carro.setModelo(rs.getString("modelo"));
            carro.setMarca(rs.getString("marca"));
            carro.setAnoModelo(rs.getInt("anomodelo"));
            carro.setAnoFabricacao(rs.getInt("anofabricacao"));
            return carro;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar carro " + ex.getMessage());
            return null;
        }
    }

    private List<Carro> mountList() {
        List<Carro> listaCarros = new ArrayList();
        try {
            while (rs.next()) {
                Carro carro = mount(rs);
                listaCarros.add(carro);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return listaCarros;
    }

    @Override
    public List<Carro> mountList(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
