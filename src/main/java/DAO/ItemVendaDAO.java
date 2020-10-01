package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objects.ItemVenda;

public class ItemVendaDAO {
    public void create(ItemVenda itemV){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Itens_Venda (COD_Itens_Venda,Quantidade,Sub_Total,COD_Venda,COD_Produto) VALUES (?,?,?,?,?)");
            stmt.setInt(1,itemV.getCodigoItemVenda());
            stmt.setInt(2,itemV.getQuantidade());
            stmt.setFloat(3,itemV.getSubTotal());
            stmt.setInt(4,itemV.getCodigoVenda());
            stmt.setInt(5,itemV.getCodigoProd());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ItemVenda salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ItemVenda> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ItemVenda> itemVendaList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ItemVenda");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                ItemVenda itemV = new ItemVenda();
                
                itemV.setCodigoItemVenda(rs.getInt("COD_Itens_Venda"));
                itemV.setQuantidade(rs.getInt("Quantidade"));
                itemV.setSubTotal(rs.getFloat("Sub_Total"));
                itemV.setCodigoVenda(rs.getInt("COD_Venda"));
                itemV.setCodigoProd(rs.getInt("COD_Produto"));
                
                itemVendaList.add(itemV);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itemVendaList;
    }
    
    public void update(ItemVenda itemV){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE ItemVenda SET Quantidade = ?,Sub_Total = ?,COD_Venda = ?,COD_Produto = ? WHERE COD_Itens_Venda = ?");
            stmt.setInt(1,itemV.getQuantidade());
            stmt.setFloat(2,itemV.getSubTotal());
            stmt.setInt(3,itemV.getCodigoVenda());
            stmt.setInt(4,itemV.getCodigoProd());
            stmt.setInt(5,itemV.getCodigoItemVenda());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ItemVenda atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(ItemVenda itemV){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM ItemVenda WHERE COD_Itens_Venda = ?");
            stmt.setInt(1,itemV.getCodigoItemVenda());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "ItemVenda excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }    
}
