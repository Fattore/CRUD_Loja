package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objects.Vendas;

public class VendasDAO {
    public void create(Vendas venda){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Vendas (COD_Venda,Data_Venda,Hora_Venda,Total_Venda,COD_Cli) VALUES (?,?,?,?,?)");
            stmt.setInt(1,venda.getCodigo());
            stmt.setString(2,venda.getDataVenda());
            stmt.setString(3,venda.getHoraVenda());
            stmt.setFloat(4,venda.getTotal());
            stmt.setInt(5,venda.getCodigoCli());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Venda salva com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Vendas> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendas> vendaList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Vendas");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Vendas venda = new Vendas();
                
                venda.setCodigo(rs.getInt("COD_Venda"));
                venda.setDataVenda(rs.getString("Data_Venda"));
                venda.setHoraVenda(rs.getString("Hora_Venda"));
                venda.setTotal(rs.getFloat("Total_Venda"));
                venda.setCodigoCli(rs.getInt("COD_Cli"));
                
                vendaList.add(venda);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return vendaList;
    }
    
    public void update(Vendas venda){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Vendas SET Data_Venda = ?,Hora_Venda = ?,Total_Venda = ?,COD_Cli = ? WHERE COD_Venda = ?");
            stmt.setString(1,venda.getDataVenda());
            stmt.setString(2,venda.getHoraVenda());
            stmt.setFloat(3,venda.getTotal());
            stmt.setInt(4,venda.getCodigoCli());
            stmt.setInt(5,venda.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Venda atualizada com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Vendas venda){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Vendas WHERE COD_Venda = ?");
            stmt.setInt(1,venda.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Venda excluída com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}    
