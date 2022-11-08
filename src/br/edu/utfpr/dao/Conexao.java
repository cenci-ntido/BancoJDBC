package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private final String URL = "jdbc:postgresql://localhost:5432/locacao";
    private final String USUARIO = "postgres";
    private final String SENHA = "01thiago";
    private Connection conexao;
    private static Conexao instancia;

    public Conexao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectou");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro" + ex.getMessage());
        }
    }

    public static Conexao getInstance() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }
    
    public static void main(String[] args) {
        getInstance();
    }
}
