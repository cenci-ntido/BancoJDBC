
package br.edu.utfpr.dao;

import br.edu.utfpr.entidades.Cliente;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Andreia
 */
public class ClienteDao extends AbstractDaoImpl<Cliente> {

    private PreparedStatement pstm; //insert, update e delete
    private ResultSet rs; //select

    @Override
    public List<Cliente> findAll() {
        List<Cliente> listaClientes = new ArrayList<>();
        try {
            pstm = getConn().prepareStatement("SELECT * FROM cliente");
            rs = pstm.executeQuery();
            return mountList();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closePreparedStatement(pstm);
            super.closeResultSet(rs);
        }
        return listaClientes;
    }

    @Override
    public Cliente mount(ResultSet rs) {
        try {
            Cliente cliente = new Cliente();
            cliente.setCodigo(rs.getInt("idcliente"));
            cliente.setNome(rs.getString("nomecliente"));
            cliente.setCpf(rs.getLong("cpf"));
            cliente.setGenero(rs.getString("genero").charAt(0));
            cliente.setDataNascimento(rs.getDate("datanascimento").toLocalDate());
            return cliente;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar cliente: " + ex.getMessage());
            return null;
        }
    }

    private List<Cliente> mountList() {
        List<Cliente> listaClientes = new ArrayList();
        try {
            while (rs.next()) {
                Cliente cliente = mount(rs);
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao criar lista de clientes: " + ex.getMessage());
        }
        return listaClientes;
    }


    @Override
    public Cliente update(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente findById(int id) {
        try {
            pstm = getConn().prepareStatement("SELECT  * from cliente  "
                    + "WHERE idcliente = ?");
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
    public Cliente insert(Cliente obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> mountList(ResultSet res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
