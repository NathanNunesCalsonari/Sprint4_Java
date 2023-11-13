package br.com.fiap.guinchoseguro.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.guinchoseguro.model.Funcionario;

public class FuncionarioDao {
    public ArrayList<Funcionario> listaDeFuncionarios() {
        ArrayList<Funcionario> funcionario = new ArrayList<>();
        
        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "SELECT * FROM T_GUISR_FUNCIONARIO";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    funcionario.add(new Funcionario(
                        rs.getLong("id"),
                        rs.getString("nomeFuncionario"),
                        rs.getString("cpfFuncionario"),
                        rs.getString("dataDeNascimento"),
                        rs.getDouble("salario")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
    
    public Funcionario obterFuncionarioPorId(long funcionarioId) {
        Funcionario funcionario = null;

        try (Connection con = ConnectionFactory.createConnection()) {
            String query = "T_GUISR_FUNCIONARIO WHERE id = ?";
            try (PreparedStatement pstmt = con.prepareStatement(query)) {
                pstmt.setLong(1, funcionarioId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    funcionario = new Funcionario(
                    		rs.getLong("id"),
                            rs.getString("nomeFuncionario"),
                            rs.getString("cpfFuncionario"),
                            rs.getString("dataDeNascimento"),
                            rs.getDouble("salario")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return funcionario;
    }
    
        public boolean deletarFuncionario(long funcionarioId) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "DELETE FROM T_GUISR_FUNCIONARIO WHERE id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, funcionarioId);
                    int rowsDeleted = pstmt.executeUpdate();

                    return rowsDeleted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean novoFuncionario(Funcionario novoFuncionario) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "INSERT INTO T_GUISR_FUNCIONARIO (ID_FUNC, NM_FUNC, NR_CPF, DT_NASCIMENTO, VL_SALARIO) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setLong(1, novoFuncionario.idFuncionario());
                    pstmt.setString(2, novoFuncionario.nomeFuncionario());
                    pstmt.setString(3, novoFuncionario.cpfFuncionario());
                    pstmt.setString(4, novoFuncionario.dataDeNascimento());
                    pstmt.setDouble(5, novoFuncionario.salario());

                    int rowsInserted = pstmt.executeUpdate();

                    return rowsInserted > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        public boolean atualizarFuncionario(long funcionarioId, Funcionario funcionario) {
            try (Connection con = ConnectionFactory.createConnection()) {
                String query = "UPDATE INTO T_GUISR_FUNCIONARIO SET NM_FUNC = ?, NR_CPF = ?, DT_NASCIMENTO = ?, VL_SALARIO = ? WHERE ID_FUNC = ?";
                try (PreparedStatement pstmt = con.prepareStatement(query)) {
                    pstmt.setString(1, funcionario.nomeFuncionario());
                    pstmt.setString(2, funcionario.cpfFuncionario());
                    pstmt.setString(3, funcionario.dataDeNascimento());
                    pstmt.setDouble(4, funcionario.salario());
                    pstmt.setLong(5, funcionarioId);

                    int rowsUpdated = pstmt.executeUpdate();

                    return rowsUpdated > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
}





