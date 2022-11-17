package dao;

import model.Conveniado;
import model.Medico;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try {
            String query;
            String senha = null;
            query = "INSERT INTO table_registro_conveniado (cpf, nomeCompleto, senha) VALUES (?, ?, ?)";

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(conveniado.getSenha().getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : resultByteArray) {
                senha = String.valueOf(stringBuilder.append(String.format("%02x", b)));
            }
            conveniado.setSenha(senha);

            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getCpf());
            ps.setString(2, conveniado.getNomeCompleto());
            ps.setString(3, conveniado.getSenha());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }

        return rsBoolean;
    }

    // Método para cadastrar um telefone de um conveniado
    public Boolean cadastrarTelefoneConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "INSERT INTO table_telefone (telefone, conveniado_cpf, conveniado_ID) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getNumDeTelefone());
            ps.setString(2, conveniado.getCpf());
            ps.setInt(3, conveniado.getId());
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
            query = "INSERT INTO table_endereco (cep, rua, numero, telefone_conveniado_cpf, conveniado_ID) VALUES (?, ?, ?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getCep());
            ps.setString(2, conveniado.getRuaDaCasa());
            ps.setFloat(3, conveniado.getNumDaCasa());
            ps.setString(4, conveniado.getCpf());
            ps.setInt(5, conveniado.getId());
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
            String senha = null;

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(medico.getSenha().getBytes());

            byte[] resultByteArray = messageDigest.digest();

            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : resultByteArray) {
                senha = String.valueOf(stringBuilder.append(String.format("%02x", b)));
            }
            medico.setSenha(senha);

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
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }

        return rsBoolean;
    }

    public Boolean cadastrarTelefoneMedico(Medico medico) {
        try {
            String query;
            query = "INSERT INTO table_telefone (telefone, medico_cpf, medico_id) VALUES (?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            ps.setString(2, medico.getCpf());
            ps.setInt(3, medico.getId());
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
            query = "INSERT INTO table_endereco (cep, rua, numero, medico_cpf, medico_ID) VALUES (?, ?, ?, ?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            ps.setString(4, medico.getCpf());
            ps.setInt(5, medico.getId());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public Boolean buscarConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "select conveniado_ID from table_registro_conveniado where cpf=? and senha=?";

            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getValidaCpf());
            ps.setString(2, conveniado.getValidaSenha());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rsBoolean=true;
            }
            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public Boolean buscarMedico(Medico medico) {
        try {
            String query;
            query = "select * from table_registro_medico where cpf=? and senha=?";

            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, medico.getValidaCpf());
            ps.setString(2, medico.getValidaSenha());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rsBoolean=true;
            }
            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
}
