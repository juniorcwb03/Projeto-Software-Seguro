package dao;

import model.Consulta;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TelaPrincipalDAO {
    private boolean rsBoolean;
    private PreparedStatement ps;
    private final ConexaoDAO conn;

    public TelaPrincipalDAO(){
        conn = new ConexaoDAO();
    }

    public boolean marcarConsulta(Consulta consulta) {
        try {
            String query;
            query = "INSERT INTO table_consulta (data, hora, cod_consulta_ID) VALUES (?, ? ,?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, consulta.getData());
            ps.setString(2, consulta.getHora());
            ps.setInt(3, consulta.getId());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public boolean atualizarConsulta(Consulta consulta) {
        try {
            String query;
            query = "UPDATE table_consulta SET data = ?, hora = ? WHERE cod_consulta_ID = ?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, consulta.getData());
            ps.setString(2, consulta.getHora());
            ps.setInt(3, consulta.getId());
            this.rsBoolean = ps.execute();

            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }

    public boolean deletarConsulta(Consulta consulta) {
        try {
            String query;
            query = "DELETE FROM table_consulta WHERE cod_consulta_ID = ?";
            ps = conn.getConexao().prepareStatement(query);
            ps.setInt(1, consulta.getId());
            this.rsBoolean = ps.execute();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
}
