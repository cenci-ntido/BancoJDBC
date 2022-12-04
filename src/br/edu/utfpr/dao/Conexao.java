package br.edu.utfpr.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

import br.edu.utfpr.arquivos.GravaErroArquivo;

public class Conexao {

    private final String URL = "jdbc:postgresql://localhost:5432/PROJETO_OO";
    private final String USUARIO = "postgres";
    private final String SENHA = "01thiago";
    private Connection conexao;
    private static Conexao instancia;

    public Conexao() {
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Conectou");
        } catch (SQLException ex) {
            GravaErroArquivo g = new GravaErroArquivo();
            File file = new File(System.getProperty("user.dir") + "/src/log.txt");
            g.gravar(file, ex.toString());
        }
    }

    public static Conexao getInstance() {
        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }
    //
    // public static void main(String[] args) {
    // getInstance();
    // }

    public Connection getConexao() {
        return conexao;
    }

}
