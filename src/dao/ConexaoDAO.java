package dao;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    // Variáveis
    private final String con_banco;
    private final String usuario_mysql;
    private final String senha_mysql;
    private Connection conn;
    private static ConexaoDAO instance;

    // Método construtor da classe
    public ConexaoDAO() {
        // hospitaldb é o nome do banco de dados no MySql
        // deve ser criado com o usuário "root" e senha "013710"
        this.con_banco = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        this.usuario_mysql = "root";
        this.senha_mysql = "013710";
        instance = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(con_banco, usuario_mysql, senha_mysql);
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

    // Método para obter estado da conexão
    public Connection getConexao() {
        return this.conn;
    }
}