package dao;

import model.Conveniado;
import model.Medico;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {
    // Variáveis
    private final ConexaoDAO conn;
    private boolean rsBoolean;
    private PreparedStatement ps;

    // Método construtor da classe
    public CadastroDAO(){
        conn = new ConexaoDAO();
    }

    // Método para cadastrar um conveniado
    public Boolean cadastrarConveniado(Conveniado conveniado) {
        // UTILIZAR O VALOR DE RETORNO
        try {
            String query;
            query = "INSERT INTO table_conveniado (cpf, nomeCompleto, senha) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getCpf());
            ps.setString(2, conveniado.getNomeCompleto());
            ps.setString(3, conveniado.getSenha());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    // Método para cadastrar um telefone de um conveniado
    public Boolean cadastrarTelefoneConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO telefone(telefone) VALUE (?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getNumDeTelefone());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    // Método para cadastrar um endereço de um conveniado
    public Boolean cadastrarEnderecoConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO endereco (cep, rua, numero) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getCep());
            ps.setString(2, conveniado.getRuaDaCasa());
            ps.setFloat(3, conveniado.getNumDaCasa());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
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
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public Boolean cadastrarTelefoneMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO telefone (telefone) VALUE (?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public Boolean cadastrarEnderecoMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO endereco (cep, rua, numero) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
}
