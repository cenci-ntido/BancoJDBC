package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractDaoImpl<T> implements AbstractDao<T> {

    protected Connection connection;

    public Connection getConn() {
        Conexao conexao = Conexao.getInstance();//Obtém a instancia unica
        connection = conexao.getConexao();//Retorna a conexao com o bd
        return connection;
    }

    public void closePreparedStatement(PreparedStatement psmt) {
        if (psmt == null) {
            return;
        }

        try {
            if (!psmt.isClosed()) {
                psmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void closeResultSet(ResultSet rs) {
        if (rs == null) {
            return;
        }

        try {
            if (!rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
