package br.edu.utfpr.dao.ClassesDao;

import br.edu.utfpr.arquivos.GravaErroArquivo;
import br.edu.utfpr.dao.AbstractDaoImpl;
import br.edu.utfpr.entidades.Compra;
import br.edu.utfpr.entidades.MateriaPrima;
import br.edu.utfpr.entidades.Producao;

import java.io.File;
import java.lang.System.Logger;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;

public class ProducaoDao extends AbstractDaoImpl<Producao> {

    private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public Producao insert(Producao producao) {
        try {
            pstm = getConn().prepareStatement("INSERT INTO producao\n"
                    + "(\"data\", materiaprima, quantidade)\n"
                    + "VALUES(?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
//Statement.RETURN_GENERATED_KEYS permite recuperar as chaves geradas automaticamente por meio do método getGeneratedKeys
            pstm.setDate(1, java.sql.Date.valueOf(producao.getData()));
            pstm.setInt(2, producao.getMateriaPrima().getId());
            pstm.setFloat(3, producao.getQuantidade());
            if (pstm.executeUpdate() > 0) { //Executa uma instrução SQL referente a um INSERT, UPDATE e DELETE, o retorno é o número de linhas afetadas
                rs = pstm.getGeneratedKeys();//Recupera todas as chaves geradas automaticamente 
                rs.next();
                producao.setId(rs.getInt("id"));
                return producao;
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + ex.getMessage());
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }

    }

    public List<Producao> filtrarData(String data) {
        try {
            if (data == null || data.equals((String) "")) {
                pstm = getConn().prepareStatement("SELECT  * from producao");
                rs = pstm.executeQuery();
            } else {
                pstm = getConn().prepareStatement("SELECT  * from producao WHERE \"data\" = '" + data + "'");
                rs = pstm.executeQuery();
            }

            return mountList();

        } catch (SQLException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public List<Producao> findAll() {
        try {
            pstm = getConn().prepareStatement("SELECT * FROM producao");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
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
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            return false;
        } finally {
            super.closePreparedStatement(pstm);
        }
    }

    @Override
    public Producao findById(int id) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from producao WHERE id = ?");
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return mount(rs);
            }
            return null;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
    }

    @Override
    public Producao update(Producao producao) {
        try {
            pstm = getConn().prepareStatement("UPDATE producao "
                    + "SET data=?, materiaprima=?, quantidade=?"
                    + "WHERE id=?");

            pstm.setDate(1, java.sql.Date.valueOf(producao.getData()));
            pstm.setInt(2, producao.getMateriaPrima().getId());
            pstm.setFloat(3, producao.getQuantidade());
            pstm.setInt(4, producao.getId());
            if (pstm.executeUpdate() > 0) {
                return producao;
            }
            return null;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o cadastro: " + ex.getMessage());
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            return null;
        } finally {
            super.closePreparedStatement(pstm);
        }
    }

    @Override
    public Producao mount(ResultSet res) {
        try {
            MateriaPrima materiaPrima = new MateriaPrima();
            materiaPrima.setId(res.getInt("materiaprima"));
            
            Producao producao = new Producao();
            producao.setId(rs.getInt("id"));
            producao.setMateriaPrima(materiaPrima);
            producao.setData(rs.getDate("data").toLocalDate());
            producao.setQuantidade(rs.getFloat("quantidade"));
            return producao;
        } catch (SQLException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            return null;
        }
    }

    public List<Producao> mountList() {
        List<Producao> listaProducao = new ArrayList();
        try {
            while (rs.next()) {
                Producao producao = mount(rs);
                listaProducao.add(producao);
            }
        } catch (SQLException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
            java.util.logging.Logger.getLogger(ProducaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProducao;
    }

}
