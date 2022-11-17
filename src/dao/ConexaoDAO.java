package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDAO {
    private Connection conn;

    // Método construtor da classe
    public ConexaoDAO() {
        // hospitaldb é o nome do banco de dados no MySql
        // deve ser criado com o usuário "root" e senha "013710"
        // Variáveis
        String conBanco = "jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false";
        String usuarioMysql = "root";
        String senhaMysql = "013710";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(conBanco, usuarioMysql, senhaMysql);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Método para obter estado da conexão
    public Connection getConexao() {
        return this.conn;
    }
}