package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    private Connection conn;
    private static ConexaoDAO instance;

    // Método construtor da classe
    public ConexaoDAO() {
        // hospitaldb é o nome do banco de dados no MySql
        // deve ser criado com o usuário "root" e senha "013710"
        // Variáveis
        String conBanco = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false";
        String usuarioMysql = "root";
        String senhaMysql = "root";
        instance = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(conBanco, usuarioMysql, senhaMysql);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static ConexaoDAO getInstance() {
        return instance;
    }

    public static void setInstance(ConexaoDAO instance) {
        ConexaoDAO.instance = instance;
    }

    // Método para obter estado da conexão
    public Connection getConexao() {
        return this.conn;
    }
}