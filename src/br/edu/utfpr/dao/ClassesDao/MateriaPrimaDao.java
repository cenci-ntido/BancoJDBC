package br.edu.utfpr.dao.ClassesDao;

import br.edu.utfpr.dao.AbstractDaoImpl;
import br.edu.utfpr.entidades.MateriaPrima;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;

public class MateriaPrimaDao extends AbstractDaoImpl<MateriaPrima> {

    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public MateriaPrima insert(MateriaPrima materiaPrima) {
        try {
            pstm = getConn().prepareStatement("INSERT INTO materiaprima\n"
                    + "(descricao, unidade, saldo)\n"
                    + "VALUES(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, materiaPrima.getDescricao());
            pstm.setString(2, materiaPrima.getUnidade());
            pstm.setFloat(3, materiaPrima.getSaldo());
            if (pstm.executeUpdate() > 0) { //Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                materiaPrima.setId(rs.getInt("id"));
                return materiaPrima;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir MP: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }

    }

    @Override
    public List<MateriaPrima> findAll() {
        try {
            pstm = getConn().prepareStatement("SELECT * FROM materiaprima");
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
            pstm = getConn().prepareStatement("DELETE FROM materiaprima WHERE id = ?");
            pstm.setInt(1, id);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
            return false;
        } finally {
            super.closePreparedStatement(pstm);
        }
    }

    @Override
    public MateriaPrima findById(int id) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from materiaprima WHERE id = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    public MateriaPrima findByDescricao(String descricao) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from materiaprima WHERE descricao = '?'");
            pstm.setString(1, descricao);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    public List<MateriaPrima> filtraDescricao(String descricao) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from materiaprima WHERE descricao like '%" + descricao + "%'");
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
    public MateriaPrima update(MateriaPrima materiaPrima) {
        try {
            pstm = getConn().prepareStatement("UPDATE materiaprima "
                    + "SET descricao=?, unidade=?, saldo=?"
                    + "WHERE id=?");

            pstm.setString(1, materiaPrima.getDescricao());
            pstm.setString(2, materiaPrima.getUnidade());
            pstm.setFloat(3, materiaPrima.getSaldo());
            pstm.setInt(4, materiaPrima.getId());
            if (pstm.executeUpdate() > 0) {
                return materiaPrima;
            }
            return null;

            // Se a atualização acontecer corretamente, o valor é a quantidade de linhas afetada na execuação,
            //senão retorna 0 indicando que a  atualização não afetou nenhuma linha.
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public MateriaPrima mount(ResultSet res) {
        try {
            MateriaPrima materiaPrima = new MateriaPrima();
            materiaPrima.setId(rs.getInt("id"));
            materiaPrima.setDescricao(rs.getString("descricao"));
            materiaPrima.setUnidade(rs.getString("unidade"));
            materiaPrima.setSaldo(rs.getFloat("saldo"));
            return materiaPrima;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        }
    }

    private List<MateriaPrima> mountList() {
        List<MateriaPrima> listaMp = new ArrayList();
        try {
            while (rs.next()) {
                MateriaPrima materiaPrima = mount(rs);
                listaMp.add(materiaPrima);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        return listaMp;
    }

    public MateriaPrima updateSaldo(MateriaPrima materiaPrima) {
        try {
            pstm = getConn().prepareStatement("UPDATE materiaprima "
                    + "SET saldo=?"
                    + "WHERE id=?");

            pstm.setFloat(1, materiaPrima.getSaldo());
            pstm.setInt(2, materiaPrima.getId());
            if (pstm.executeUpdate() > 0) {
                return materiaPrima;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

}
