package view;

import DAO.ItemVendaDAO;
import connection.ConnectionFactory;
import utilities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import objects.ItemVenda;
import java.sql.Statement;

/*Listagem de clientes sem e-mail
 Listagem de produtos que estão vencidos na data atual
 Quantidade de vendas realizadas no ano de 2020 (agrupadas por cliente)
 Listagem de vendas (contendo o valor total da mesma).*/

public class frmItemVenda extends javax.swing.JFrame {

    public frmItemVenda() {
        initComponents();     
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        grdClientes.setRowSorter(new TableRowSorter(modelo));
        
        carregarGrade();
    }

    public void carregarGrade()
    {
        ItemVendaDAO ivDAO = new ItemVendaDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        modelo.setNumRows(0);
        
        for(ItemVenda iv: ivDAO.read()){
            modelo.addRow(new Object[]{
                iv.getCodigoItemVenda(),
                iv.getQuantidade(),
                iv.getSubTotal(),
                iv.getCodigoVenda(),
                iv.getCodigoProd()});
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtQuantidade = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        lblQuantidade = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblCodigoP = new javax.swing.JLabel();
        txtCodigoP = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblCodigoV = new javax.swing.JLabel();
        txtCodigoV = new javax.swing.JTextField();
        jmbCliente = new javax.swing.JMenuBar();
        jmnOpcoes = new javax.swing.JMenu();
        jmiSair = new javax.swing.JMenuItem();
        jmnNavegacao = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiDistribuidores = new javax.swing.JMenuItem();
        jmiItemVenda = new javax.swing.JMenuItem();
        jmiProduto = new javax.swing.JMenuItem();
        jmiVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ItemXVenda");

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });

        btnNovo.setText("Cadastrar");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Atualizar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        grdClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Quantidade", "Sub Total", "Código Venda", "Código Produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grdClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grdClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(grdClientes);

        lblQuantidade.setText("Quantidade:");

        lblSubTotal.setText("Sub Total:");

        lblCodigoP.setText("Código Produto:");

        txtCodigoP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCodigoPFocusLost(evt);
            }
        });
        txtCodigoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoPActionPerformed(evt);
            }
        });

        txtSubTotal.setEditable(false);

        lblCodigo.setText("Código:");

        lblCodigoV.setText("Código Venda:");

        jmnOpcoes.setText("Opções");
        jmnOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnOpcoesActionPerformed(evt);
            }
        });

        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jmnOpcoes.add(jmiSair);

        jmbCliente.add(jmnOpcoes);

        jmnNavegacao.setText("Navegação");

        jmiClientes.setText("Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        jmnNavegacao.add(jmiClientes);

        jmiDistribuidores.setText("Distribuidores");
        jmiDistribuidores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDistribuidoresActionPerformed(evt);
            }
        });
        jmnNavegacao.add(jmiDistribuidores);

        jmiItemVenda.setText("ItemXVenda");
        jmiItemVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiItemVendaActionPerformed(evt);
            }
        });
        jmnNavegacao.add(jmiItemVenda);

        jmiProduto.setText("Produto");
        jmiProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProdutoActionPerformed(evt);
            }
        });
        jmnNavegacao.add(jmiProduto);

        jmiVenda.setText("Venda");
        jmiVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiVendaActionPerformed(evt);
            }
        });
        jmnNavegacao.add(jmiVenda);

        jmbCliente.add(jmnNavegacao);

        setJMenuBar(jmbCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 825, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQuantidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtCodigoP))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtSubTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigoV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoV)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubTotal)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoV)
                    .addComponent(txtCodigoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoP))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private float total = 0;   
    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        if(this.ValidacoesCampos()) {
            ItemVenda iv = new ItemVenda();
            ItemVendaDAO ivDAO = new ItemVendaDAO();
          
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;   

            try {               
                stmt = con.prepareStatement("UPDATE Vendas SET Total_Venda = ? +"+total+" WHERE COD_Venda ="+txtCodigoV.getText()+"");
                total = (Float.parseFloat(txtSubTotal.getText()));

                if(Float.toString(total).isEmpty()){
                    stmt.setFloat(1, 0);
                    stmt.executeUpdate();
                } else if(Float.toString(total) != "") {
                    stmt.setFloat(1,total);
                    stmt.executeUpdate();
                } else {
                    stmt.setFloat(1,total);
                    stmt.executeUpdate();
                }
                        
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
            } finally {
                ConnectionFactory.closeConnection(con, stmt);
            }
              
           
            iv.setCodigoItemVenda(Integer.parseInt(txtCodigo.getText()));
            iv.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
            iv.setSubTotal(Float.parseFloat(txtSubTotal.getText()));
            iv.setCodigoVenda(Integer.parseInt(txtCodigoV.getText()));
            iv.setCodigoProd(Integer.parseInt(txtCodigoP.getText()));

            ivDAO.create(iv);

            this.carregarGrade();
            this.limparCampos();
        } 
    }//GEN-LAST:event_btnNovoActionPerformed

    private boolean ValidacoesCodigo() {
        if(txtCodigo.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o código.");
            return false;
        } 
      
        if(!Validador.ValorENumeroInteiro(txtCodigo.getText())) {
            Mensagem.ExibirMensagemErro("Preencha um número inteiro válido.");
            return false;
        }
      
        return true;
    }
        
    private boolean ValidacoesCampos() {
        if(txtQuantidade.getText().trim().isEmpty()) {
          Mensagem.ExibirMensagemErro("Preencha o Quantidade.");
          return false;
        }

        if(!ValidacoesCodigo())
          return false;      
        
        if(txtCodigoP.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Código do Produto.");
            return false;
        }
        return true;
    }
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtQuantidade.setText("");
        txtSubTotal.setText("");
        txtCodigoV.setText("");
        txtCodigoP.setText("");
    }
    
    private void AtribuirValoresGradeParaEdits() {
        int row = grdClientes.getSelectedRow();
        txtCodigo.setText(grdClientes.getModel().getValueAt(row, 1).toString());
        txtQuantidade.setText(grdClientes.getModel().getValueAt(row, 2).toString());
        txtSubTotal.setText("%.2f"+grdClientes.getModel().getValueAt(row, 3).toString());
        txtCodigoV.setText(grdClientes.getModel().getValueAt(row, 4).toString()); 
        txtCodigoP.setText(grdClientes.getModel().getValueAt(row, 5).toString());
    }
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if (this.ValidacoesCampos()) {
           ItemVenda iv = new ItemVenda();
           ItemVendaDAO ivDAO = new ItemVendaDAO();
           
           iv.setCodigoItemVenda(Integer.parseInt(txtCodigo.getText()));
           iv.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
           iv.setSubTotal(Float.parseFloat(txtSubTotal.getText()));
           iv.setCodigoVenda(Integer.parseInt(txtCodigoV.getText()));
           iv.setCodigoProd(Integer.parseInt(txtCodigoP.getText()));

           ivDAO.update(iv);

           this.carregarGrade();
           this.limparCampos();
        }   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdClientesMouseClicked

        this.AtribuirValoresGradeParaEdits();
    }//GEN-LAST:event_grdClientesMouseClicked

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        ItemVenda iv = new ItemVenda();
        ItemVendaDAO ivDAO = new ItemVendaDAO();

        iv.setCodigoItemVenda(Integer.parseInt(txtCodigo.getText()));
            
        ivDAO.delete(iv);            
        
        this.carregarGrade();
        this.limparCampos();  
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        ItemVendaDAO ivDAO = new ItemVendaDAO();
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Itens_Venda WHERE COD_Itens_Venda = '"+txtCodigo.getText()+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                ItemVenda iv = new ItemVenda();
                
                txtCodigo.setText(rs.getString("COD_Itens_Venda"));
                txtQuantidade.setText(rs.getString("Quantidade"));                
                txtSubTotal.setText(rs.getString("Sub_Total"));
                txtCodigoV.setText(rs.getString("COD_Venda"));
                txtCodigoP.setText(rs.getString("COD_Produto"));                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtCodigoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoPActionPerformed

    }//GEN-LAST:event_txtCodigoPActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnOpcoesActionPerformed

    }//GEN-LAST:event_jmnOpcoesActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        frmCliente form = new frmCliente();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiDistribuidoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDistribuidoresActionPerformed
        frmDistribuidores form = new frmDistribuidores();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiDistribuidoresActionPerformed

    private void jmiItemVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiItemVendaActionPerformed
        frmItemVenda form = new frmItemVenda();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiItemVendaActionPerformed

    private void jmiProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProdutoActionPerformed
        frmProduto form = new frmProduto();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiProdutoActionPerformed

    private void jmiVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVendaActionPerformed
        frmVenda form = new frmVenda();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiVendaActionPerformed

    private void txtCodigoPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoPFocusLost
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
                
            stmt = con.prepareStatement("SELECT Preco_Venda FROM Produtos WHERE COD_Prod='"+txtCodigoP.getText()+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                String converte = rs.getString("Preco_Venda");
                txtSubTotal.setText(Float.toString(Float.parseFloat(converte)*Float.parseFloat(txtQuantidade.getText())));
            
            }
          
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
                ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_txtCodigoPFocusLost

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmItemVenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTable grdClientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar jmbCliente;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiDistribuidores;
    private javax.swing.JMenuItem jmiItemVenda;
    private javax.swing.JMenuItem jmiProduto;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiVenda;
    private javax.swing.JMenu jmnNavegacao;
    private javax.swing.JMenu jmnOpcoes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoP;
    private javax.swing.JLabel lblCodigoV;
    private javax.swing.JLabel lblQuantidade;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoP;
    private javax.swing.JTextField txtCodigoV;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JTextField txtSubTotal;
    // End of variables declaration//GEN-END:variables
}
