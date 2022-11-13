package dao;

import model.Consulta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            query = "INSERT INTO table_consulta (data, hora) VALUES (?, ?)";
            ps = conn.getConexao().prepareStatement(query);
            ps.setString(1, consulta.getData());
            ps.setString(2, consulta.getHora());
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
            return rsBoolean;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rsBoolean;
    }
}
