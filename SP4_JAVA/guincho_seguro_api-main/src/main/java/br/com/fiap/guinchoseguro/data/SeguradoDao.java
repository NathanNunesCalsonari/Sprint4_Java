package br.com.fiap.guinchoseguro.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.guinchoseguro.model.Segurado;

public class SeguradoDao {
	
	public ArrayList<Segurado> listaDeSegurados() {
        ArrayList<Segurado> segurado = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_GUISR_SEGURADO";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    segurado.add(new Segurado(
                        rs.getLong("idSegurado"),
                        rs.getString("cpfSegurado"),
                        rs.getInt("numeroDaApolice")

                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return segurado;
    }
    
    public Segurado obterSeguradoPorId(long seguradoId) {
        Segurado segurado = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_GUISR_SEGURADO WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, seguradoId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    segurado = new Segurado(
                    		rs.getLong("idSegurado"),
                            rs.getString("cpfSegurado"),
                            rs.getInt("numeroDaApolice")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return segurado;
    }
    
        public boolean deletarSegurado(long seguradoId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_GUISR_SEGURADO WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, seguradoId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoSegurado(Segurado novoSegurado) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_GUISR_SEGURADO (ID_SEGURADO, NR_CPF, NR_APOLICE) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoSegurado.idSegurado());
                    pstmt.setString(2, novoSegurado.cpfSegurado());
                    pstmt.setInt(3, novoSegurado.numeroDaApolice());


                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarSegurado(long seguradoId, Segurado segurado) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_GUISR_SEGURADO SET NR_CPF = ?, NR_APOLICE = ?, WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, segurado.cpfSegurado());
                    pstmt.setInt(2, segurado.numeroDaApolice());
                    pstmt.setLong(5, seguradoId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

}
