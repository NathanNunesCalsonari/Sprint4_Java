package br.com.fiap.guinchoseguro.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.guinchoseguro.model.Guincho;

public class GuinchoDao {
	
	public ArrayList<Guincho> listaDeGuinchos() {
        ArrayList<Guincho> guincho = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_GUISR_GUINCHO";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    guincho.add(new Guincho(
                        rs.getLong("idGuincho"),
                        rs.getString("descricaoGuincho"),
                        rs.getInt("numeroDaApolice")

                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guincho;
    }
    
    public Guincho obterGuinchoPorId(long guinchoId) {
        Guincho guincho = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_GUISR_GUINCHO WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, guinchoId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    guincho = new Guincho(
                    		rs.getLong("idGuincho"),
                            rs.getString("descricaoGuincho"),
                            rs.getInt("numeroDaPlaca")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return guincho;
    }
    
        public boolean deletarGuincho(long guinchoId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_GUISR_GUINCHO WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, guinchoId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoGuincho(Guincho novoGuincho) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_GUISR_GUINCHO (ID_GUINCHO, DS_GUINCHO, NR_PLACA) VALUES (?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoGuincho.idGuincho());
                    pstmt.setString(2, novoGuincho.descricaoGuincho());
                    pstmt.setInt(3, novoGuincho.numeroDaPlaca());


                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarGuincho(long guinchoId, Guincho guincho) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_GUISR_GUINCHO SET DS_GUINCHO = ?, NR_PLACA = ?, WHERE ID_FUNC = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, guincho.descricaoGuincho());
                    pstmt.setInt(2, guincho.numeroDaPlaca());
                    pstmt.setLong(5, guinchoId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }

}
