package dao;

import com.mysql.cj.protocol.Resultset;
import model.Conveniado;
import model.Medico;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
            query = "INSERT INTO telefone_conveniado (telefone,table_conveniado_cpf) VALUE (?,?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getNumDeTelefone());
            ps.setString(2, conveniado.getCpf());
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
            query = "INSERT INTO endereco_conveniado (cep, rua, numero,table_conveniado_cpf) VALUES (?, ?, ?,?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getCep());
            ps.setString(2, conveniado.getRuaDaCasa());
            ps.setFloat(3, conveniado.getNumDaCasa());
            ps.setString(4, conveniado.getCpf());
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
            query = "INSERT INTO telefone_medico (telefone,table_registro_medico_cpf) VALUE (?,?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            ps.setString(2, medico.getCpf());
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
            query = "INSERT INTO endereco_medico (cep, rua, numero,table_registro_medico_cpf) VALUES (?, ?, ?,?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            ps.setString(4, medico.getCpf());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }


    // Metodo para editar (alteração) de um conveniado.
    public Boolean editarConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "update table_conveniado set cpf = ?, nomeCompleto = ?, senha = ? where cpf = ?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, conveniado.getCpf());
            ps.setString(2, conveniado.getNomeCompleto());
            ps.setString(3, conveniado.getSenha());
            ps.setString(4, conveniado.getValidaCpf());

            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    // Metodo para editar (alteração), telefone de um conveniado
    public Boolean editarTelefoneConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "update telefone_conveniado set telefone=?, table_conveniado_cpf=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getNumDeTelefone());
            ps.setString(2, conveniado.getValidaCpf());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    // Metodo para editar (alteração), endereço de um conveniado
    public Boolean editarEnderecoConveniado(Conveniado conveniado) {
        try {
            String query;
            query = "update endereco_conveniado set cep = ?, rua=?, numero=? where table_conveniado_cpf=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, conveniado.getCep());
            ps.setString(2, conveniado.getRuaDaCasa());
            ps.setFloat(3, conveniado.getNumDaCasa());
            ps.setString(4, conveniado.getValidaCpf());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
    // Metodo para editar (alteração) de um medico.
    public Boolean editarMedico(Medico medico) {
        try {
            String query;
            query = "update table_registro_medico set cpf=?, nome_completo=?, area_atuante=?, senha=? where cpf=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNomeCompleto());
            ps.setString(3, medico.getAreaAtuante());
            ps.setString(4, medico.getSenha());
            ps.setString(5, medico.getValidaCpf());

            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
    // Metodo para editar (alteração), telefone de um medico.
    public Boolean editarTelefoneMedico(Medico medico) {
        try {
            String query;
            query = "update telefone_medico set telefone=? where table_registro_medico_cpf=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getNumDeTelefone());
            ps.setString(2, medico.getValidaCpf());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch(SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
    // Metodo para editar (alteração), Endereço de um medico.
    public Boolean editarEnderecoMedico(Medico medico) {
        try {
            String query;
            query = "update endereco_medico set cep=?, rua=?, numero=? where table_registro_medico_cpf=?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setFloat(1, medico.getCep());
            ps.setString(2, medico.getRuaDaCasa());
            ps.setFloat(3, medico.getNumDaCasa());
            ps.setString(4, medico.getValidaCpf());
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
            query = "select conveniado_ID from table_conveniado where cpf=? and senha=?";

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
