package dao;

import model.Conveniado;
import model.Medico;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacaoDAO {
    // Variáveis
    private final ConexaoDAO conn;
    private ResultSet rs;
    private PreparedStatement ps;

    // Método construtor da classe
    public AutenticacaoDAO(){
        conn = new ConexaoDAO();
    }

    // Método para autenticar conveniado
    public Boolean autenticarConveniado (Conveniado conveniado){
        try{
            String query;
            query = "SELECT * FROM table_conveniado WHERE cpf=? AND senha=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getCpf());
            ps.setString(2, conveniado.getSenha());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean autenticarMedico (Medico medico) {
        try {
            String query;
            query = "SELECT * FROM table_registro_medico WHERE cpf=? AND senha=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getSenha());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }
}
