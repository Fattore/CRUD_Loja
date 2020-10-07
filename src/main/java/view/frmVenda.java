package view;

import DAO.VendasDAO;
import connection.ConnectionFactory;
import utilities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import objects.Vendas;

/*Listagem de clientes sem e-mail
 Listagem de produtos que estão vencidos na data atual
 Quantidade de vendas realizadas no ano de 2020 (agrupadas por cliente)
 Listagem de vendas (contendo o valor total da mesma).*/

public class frmVenda extends javax.swing.JFrame {

    public frmVenda() {
        initComponents();     
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        grdClientes.setRowSorter(new TableRowSorter(modelo));
        
        carregarGrade();
    }

    public void carregarGrade()
    {
        VendasDAO VDao = new VendasDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        modelo.setNumRows(0);
        
        for(Vendas venda: VDao.read()){
            modelo.addRow(new Object[]{
                venda.getCodigo(),
                venda.getDataVenda(),
                venda.getHoraVenda(),
                venda.getTotal(),
                venda.getCodigoCli()});
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtDataVenda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        lblDataVenda = new javax.swing.JLabel();
        lblHoraVenda = new javax.swing.JLabel();
        lblCodigoCli = new javax.swing.JLabel();
        txtCodigoCli = new javax.swing.JTextField();
        txtHoraVenda = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblTotalVenda = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JTextField();
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
        setTitle("Venda");

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
                "Código", "Dt_Venda", "Hr_Venda", "Total", "Cliente"
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

        lblDataVenda.setText("Data Venda:");

        lblHoraVenda.setText("Hora Venda:");

        lblCodigoCli.setText("Cliente:");

        txtCodigoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoCliActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código:");

        lblTotalVenda.setText("Total Venda:");

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
                                .addComponent(lblDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataVenda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtCodigoCli))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHoraVenda))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalVenda)))))
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
                    .addComponent(lblDataVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDataVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraVenda)
                    .addComponent(txtHoraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalVenda)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoCli))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        if(this.ValidacoesCampos()) {
           Vendas venda = new Vendas();
           VendasDAO VDAO = new VendasDAO();
           
           venda.setCodigo(Integer.parseInt(txtCodigo.getText()));
           venda.setDataVenda(txtDataVenda.getText());
           venda.setHoraVenda(txtHoraVenda.getText());
           venda.setTotal(Float.parseFloat(txtTotalVenda.getText()));
           /*INSERT INTO dbo.Vendas (Total_Venda) SELECT Quantidade * Sub_Total FROM Itens_Venda*/
           venda.setCodigoCli(Integer.parseInt(txtCodigoCli.getText()));

           VDAO.create(venda);
           
           this.carregarGrade();
           this.limparCampos();
        } 
    }//GEN-LAST:event_btnNovoActionPerformed

    private boolean ValidacoesCodigo() {
        if(txtCodigo.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Código.");
            return false;
        } 
      
        if(!Validador.ValorENumeroInteiro(txtCodigo.getText())) {
            Mensagem.ExibirMensagemErro("Preencha um número inteiro válido.");
            return false;
        }
      
        return true;
    }
        
    private boolean ValidacoesCampos() {
        if(txtDataVenda.getText().trim().isEmpty()) {
          Mensagem.ExibirMensagemErro("Preencha a Data da Venda.");
          return false;
        }

        if(!ValidacoesCodigo())
          return false;      

        if(txtHoraVenda.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha a Hora da Venda.");
            return false;
        }
       
        if(txtTotalVenda.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Total da Venda.");
            return false;
        }
        
        if(txtCodigoCli.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Código do Cliente.");
            return false;
        }
        return true;
    }
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtDataVenda.setText("");
        txtHoraVenda.setText("");
        txtTotalVenda.setText("");
        txtCodigoCli.setText("");
    }
    
    private void AtribuirValoresGradeParaEdits() {
        int row = grdClientes.getSelectedRow();
        txtCodigo.setText(grdClientes.getModel().getValueAt(row, 1).toString());
        txtDataVenda.setText(grdClientes.getModel().getValueAt(row, 2).toString());
        txtHoraVenda.setText(grdClientes.getModel().getValueAt(row, 3).toString());
        txtTotalVenda.setText(grdClientes.getModel().getValueAt(row, 4).toString()); 
        txtCodigoCli.setText(grdClientes.getModel().getValueAt(row, 5).toString());
    }
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if (this.ValidacoesCampos()) {
           Vendas venda = new Vendas();
           VendasDAO VDAO = new VendasDAO();
           
           venda.setCodigo(Integer.parseInt(txtCodigo.getText()));
           venda.setDataVenda(txtDataVenda.getText());
           venda.setHoraVenda(txtHoraVenda.getText());
           venda.setTotal(Float.parseFloat(txtTotalVenda.getText()));
           venda.setCodigoCli(Integer.parseInt(txtCodigoCli.getText()));

           VDAO.update(venda);

           this.carregarGrade();
           this.limparCampos();
        }   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdClientesMouseClicked

        this.AtribuirValoresGradeParaEdits();
    }//GEN-LAST:event_grdClientesMouseClicked

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        Vendas venda = new Vendas();
        VendasDAO VDAO = new VendasDAO();

        venda.setCodigo(Integer.parseInt(txtCodigo.getText()));
            
        VDAO.delete(venda);            
        
        this.carregarGrade();
        this.limparCampos();  
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        VendasDAO VDAO = new VendasDAO();
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Vendas WHERE COD_Venda = '"+txtCodigo.getText()+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Vendas venda = new Vendas();
                
                txtCodigo.setText(rs.getString("COD_Venda"));
                txtDataVenda.setText(rs.getString("Data_Venda"));                
                txtHoraVenda.setText(rs.getString("Hora_Venda"));
                txtTotalVenda.setText(rs.getString("Total_Venda"));
                txtCodigoCli.setText(rs.getString("COD_Cli"));                
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtCodigoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoCliActionPerformed

    }//GEN-LAST:event_txtCodigoCliActionPerformed

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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVenda().setVisible(true);
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
    private javax.swing.JLabel lblCodigoCli;
    private javax.swing.JLabel lblDataVenda;
    private javax.swing.JLabel lblHoraVenda;
    private javax.swing.JLabel lblTotalVenda;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoCli;
    private javax.swing.JTextField txtDataVenda;
    private javax.swing.JTextField txtHoraVenda;
    private javax.swing.JTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
