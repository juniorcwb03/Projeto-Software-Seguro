package dao;

import model.Conveniado;
import model.Medico;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CadastroDAO {
    // Variáveis
    private final ConexaoDAO conn;
    private ResultSet rs;
    PreparedStatement ps;

    // Método construtor da classe
    public CadastroDAO(){
        conn = new ConexaoDAO();
    }

    // Método para cadastrar um conveniado
    public Boolean cadastrarConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO table_conveniado (cpf, nome_completo, senha) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getCpf());
            ps.setString(2, conveniado.getNomeCompleto());
            ps.setString(3, conveniado.getSenha());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    // Método para cadastrar um telefone de um conveniado
    Boolean cadastrarTelefoneConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO telefone_conveniado (telefone) VALUE (?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getNumDeTelefone());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }

    // Método para cadastrar um endereço de um conveniado
    Boolean cadastrarEnderecoConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO endereco_conveniado(cep, rua, numero) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getCep());
            ps.setString(2, conveniado.getRuaDaCasa());
            ps.setFloat(3, conveniado.getNumDaCasa());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean cadastrarMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO table_registro_medico (cpf, nome_completo, area_atuante, senha) VALUES (?, ?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNomeCompleto());
            ps.setString(3, medico.getAreaAtuante());
            ps.setString(4, medico.getSenha());
            this.rs = ps.executeQuery();

            query = "INSERT INTO telefone_medico (telefone) VALUE (?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            this.rs = ps.executeQuery();

            query = "INSERT INTO endereco_medico(cep, rua, numero) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean cadastrarTelefoneMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO telefone_medico (telefone) VALUE (?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }

    public Boolean cadastrarEnderecoMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO endereco_medico(cep, rua, numero) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            this.rs = ps.executeQuery();

            return rs.next();
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }

        return false;
    }
}
