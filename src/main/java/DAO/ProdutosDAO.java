package DAO;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import objects.Produtos;

public class ProdutosDAO {
    public void create(Produtos prod){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Produto (COD_Prod,Preco_Venda,Descricao,Data_Validade,Preco_Custo,Estoque,COD_Dist) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1,prod.getCodigoProd());
            stmt.setFloat(2,prod.getPrecoVenda());
            stmt.setString(3,prod.getDescricao());
            stmt.setDate(4, (Date) prod.getDataValidade());
            stmt.setFloat(5,prod.getPrecoCusto());
            stmt.setInt(6,prod.getEstoque());
            stmt.setInt(7,prod.getCodigoDist());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Produtos> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produtos> prodList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produtos");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produtos prod = new Produtos();
                
                prod.setCodigoProd(rs.getInt("COD_Prod"));
                prod.setPrecoVenda(rs.getFloat("Preco_Venda"));
                prod.setDescricao(rs.getString("Descricao"));
                prod.setDataValidade(rs.getDate("Data_Validade"));
                prod.setPrecoCusto(rs.getFloat("Preco_Custo"));
                prod.setEstoque(rs.getInt("Estoque"));
                prod.setCodigoDist(rs.getInt("COD_Dist"));
                
                prodList.add(prod);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return prodList;
    }
    
    public void update(Produtos prod){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Produtos SET Preco_Venda = ?,Descricao = ?,Data_Validade = ?,Preco_Custo = ?,Estoque = ?,COD_Dist = ? WHERE COD_Prod = ?");
            stmt.setFloat(1,prod.getPrecoVenda());
            stmt.setString(2,prod.getDescricao());
            stmt.setDate(3,prod.getDataValidade());
            stmt.setFloat(4,prod.getPrecoCusto());
            stmt.setInt(5,prod.getEstoque());
            stmt.setInt(6,prod.getCodigoDist());
            stmt.setInt(7,prod.getCodigoProd());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Produtos prod){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Produtos WHERE COD_Prod = ?");
            stmt.setInt(1,prod.getCodigoProd());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }    
}
