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
import objects.Clientes;

public class ClientesDAO {
    
    public void create(Clientes cli){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO Cliente (COD_Cli,Nome,Data_Nasc,Endereco,Telefone,Email) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1,cli.getCodigo());
            stmt.setString(2,cli.getNome());
            stmt.setDate(3, (Date) cli.getNascimento());
            stmt.setString(4,cli.getEndereco());
            stmt.setString(5,cli.getTelefone());
            stmt.setString(6,cli.getEmail());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Clientes> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Clientes> cliList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Clientes cli = new Clientes();
                
                cli.setCodigo(rs.getInt("COD_Cli"));
                cli.setNome(rs.getString("Nome"));
                cli.setNascimento(rs.getDate("Data_Nasc"));
                cli.setEndereco(rs.getString("Endereco"));
                cli.setTelefone(rs.getString("Telefone"));
                cli.setEmail(rs.getString("Email"));
                
                cliList.add(cli);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cliList;
    }
    
    public void update(Clientes cli){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Cliente SET Nome = ?,Data_Nasc = ?,Endereco = ?,Telefone = ?,Email = ? WHERE COD_Cli = ?");
            stmt.setString(1,cli.getNome());
            stmt.setDate(2, (Date) cli.getNascimento());
            stmt.setString(3,cli.getEndereco());
            stmt.setString(4,cli.getTelefone());
            stmt.setString(5,cli.getEmail());
            stmt.setInt(6,cli.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Clientes cli){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Cliente WHERE COD_Cli = ?");
            stmt.setInt(1,cli.getCodigo());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}