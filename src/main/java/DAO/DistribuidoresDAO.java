package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objects.Distribuidores;

public class DistribuidoresDAO {
    public void create(Distribuidores dist){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Distribuidores (COD_Dist,Nome_Fantasia,Razao_Social,Telefone,Email) VALUES (?,?,?,?,?)");
            stmt.setInt(1,dist.getCodigo());
            stmt.setString(2,dist.getNomeFantasia());
            stmt.setString(3,dist.getRazaoSocial());
            stmt.setString(4,dist.getTelefone());
            stmt.setString(5,dist.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Distribuidor salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Distribuidores> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Distribuidores> distList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Distribuidores");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Distribuidores dist = new Distribuidores();
                
                dist.setCodigo(rs.getInt("COD_Dist"));
                dist.setNomeFantasia(rs.getString("Nome_Fantasia"));
                dist.setRazaoSocial(rs.getString("Razao_Social"));
                dist.setTelefone(rs.getString("Telefone"));
                dist.setEmail(rs.getString("Email"));
                
                distList.add(dist);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return distList;
    }
    
    public void update(Distribuidores dist){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Distribuidores SET Nome_Fantasia = ?,Razao_Social = ?,Telefone = ?,Email = ? WHERE COD_Dist = ?");
            stmt.setString(1,dist.getNomeFantasia());
            stmt.setString(2,dist.getRazaoSocial());
            stmt.setString(3,dist.getTelefone());
            stmt.setString(4,dist.getEmail());
            stmt.setInt(5,dist.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Distribuidor atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Distribuidores dist){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Distribuidores WHERE COD_Dist = ?");
            stmt.setInt(1,dist.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Distribuidor excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }    
}
