
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Acessorio;
import br.edu.utfpr.entidades.Carro;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*public class AcessorioDao extends AbstractDaoImpl<Acessorio> {

    private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Acessorio insert(Acessorio acessorio) {//cliente criado com os dados dos componentes
        try {
            pstm = getConn().prepareStatement("INSERT INTO acessorio "
                    + "(descricao, quantidade, preco, idcarro) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
//Statement.RETURN_GENERATED_KEYS permite recuperar as chaves geradas automaticamente por meio do método getGeneratedKeys
            pstm.setString(1, acessorio.getDescricao());
            pstm.setInt(2, acessorio.getQuantidade());
            pstm.setDouble(3, acessorio.getPreco());
            pstm.setInt(4, acessorio.getCarro().getCodigo());
            if (pstm.executeUpdate() > 0) {//Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                acessorio.setCodigo(rs.getInt("idacessorio"));
                return acessorio;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public List<Acessorio> findAll() {
        List<Acessorio> listaAcessorio = new ArrayList<>();
        try {
            pstm = getConn().prepareStatement("SELECT * FROM acessorio");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
        return listaAcessorio;
    }

    public List<Acessorio> findAll(int id) {
        List<Acessorio> listaAcessorio = new ArrayList<>();
        try {
            pstm =  getConn().prepareStatement("SELECT  * FROM acessorio  "
                    + "JOIN carro "
                    + "ON acessorio.idcarro = carro.idcarro "
                    + "WHERE carro.idcarro = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Carro carro = new Carro();
                carro.setCodigo(rs.getInt("idcarro"));
                carro.setModelo(rs.getString("modelo"));
                carro.setMarca(rs.getString("marca"));
                carro.setAnoModelo(rs.getInt("anomodelo"));
                carro.setAnoFabricacao(rs.getInt("anofabricacao"));
                
                Acessorio acessorio = new Acessorio();
                acessorio.setCarro(carro);
                acessorio.setCodigo(rs.getInt("idacessorio"));
                acessorio.setDescricao(rs.getString("descricao"));
                acessorio.setPreco(rs.getDouble("preco"));
                acessorio.setQuantidade(rs.getInt("quantidade"));
                listaAcessorio.add(acessorio);

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar lista de produtos." + ex.getMessage());
        } finally {
             super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
        return listaAcessorio;
    }

    @Override
    public boolean delete(int id) {
        try {
            pstm = getConn().prepareStatement("DELETE FROM acessorio WHERE idacessorio = ?");
            pstm.setInt(1, id);
            pstm.executeUpdate();
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir o acessorio." + ex.getMessage());
            return false;
        } finally {
            super.closePreparedStatement(pstm);
        }
    }

    @Override
    public Acessorio findById(int id) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from acessorio  "
                    + "WHERE idacessorio = ?");
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
    public Acessorio update(Acessorio acessorio) {
        try {
            pstm = getConn().prepareStatement("UPDATE acessorio "
                    + "SET descricao=?, quantidade=?, preco=?, idcarro=? "
                    + "WHERE idacessorio=?");

            pstm.setString(1, acessorio.getDescricao());
            pstm.setInt(2, acessorio.getQuantidade());
            pstm.setDouble(3, acessorio.getPreco());
            pstm.setInt(4, acessorio.getCarro().getCodigo());
            pstm.setInt(5, acessorio.getCodigo());
            if (pstm.executeUpdate() > 0) {
                return acessorio;
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
    public Acessorio mount(ResultSet rs) {
        try {

            Carro carro = new Carro();
            carro.setCodigo(rs.getInt("idcarro"));

            Acessorio acessorio = new Acessorio();
            acessorio.setCodigo(rs.getInt("idacessorio"));
            acessorio.setDescricao(rs.getString("descricao"));
            acessorio.setQuantidade(rs.getInt("quantidade"));
            acessorio.setPreco(rs.getDouble("preco"));
            acessorio.setCarro(carro);
            return acessorio;
        } catch (SQLException ex) {
            Logger.getLogger(AcessorioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private List<Acessorio> mountList() {
        List<Acessorio> listaClientes = new ArrayList();
        try {
            while (rs.next()) {
                Acessorio acessorio = mount(rs);
                listaClientes.add(acessorio);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return listaClientes;
    }

}*/
