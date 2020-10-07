package view;

import DAO.ClientesDAO;
import connection.ConnectionFactory;
import utilities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import objects.Clientes;
import javax.swing.JOptionPane;

/*Listagem de clientes sem e-mail
 Listagem de produtos que estão vencidos na data atual
 Quantidade de vendas realizadas no ano de 2020 (agrupadas por cliente)
 Listagem de vendas (contendo o valor total da mesma).*/

public class frmCliente extends javax.swing.JFrame {

    public frmCliente() {
        initComponents();     
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        grdClientes.setRowSorter(new TableRowSorter(modelo));
        
        carregarGrade();
    }

    public void carregarGrade()
    {
        ClientesDAO cliDAO = new ClientesDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        modelo.setNumRows(0);
        
        for(Clientes cli: cliDAO.read()){
            modelo.addRow(new Object[]{
                cli.getCodigo(),
                cli.getNome(),
                cli.getNascimento(),
                cli.getEndereco(),
                cli.getTelefone(),
                cli.getEmail()});
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        lblNascimento = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTelefone = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblEndereco = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jmbCliente = new javax.swing.JMenuBar();
        jmnOpcoes = new javax.swing.JMenu();
        jmiNoEmail = new javax.swing.JMenuItem();
        jmiSair = new javax.swing.JMenuItem();
        jmnNavegacao = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        jmiDistribuidores = new javax.swing.JMenuItem();
        jmiItemVenda = new javax.swing.JMenuItem();
        jmiProduto = new javax.swing.JMenuItem();
        jmiVenda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente");

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Nascimento", "Endereço", "Telefone", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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

        lblNome.setText("Nome:");

        lblNascimento.setText("Nascimento:");

        lblEmail.setText("Email:");

        lblTelefone.setText("Telefone:");

        txtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefoneActionPerformed(evt);
            }
        });

        lblCodigo.setText("Código:");

        lblEndereco.setText("Endereço:");

        jmnOpcoes.setText("Opções");
        jmnOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnOpcoesActionPerformed(evt);
            }
        });

        jmiNoEmail.setText("Cliente sem Email");
        jmiNoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNoEmailActionPerformed(evt);
            }
        });
        jmnOpcoes.add(jmiNoEmail);

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
                                .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtTelefone))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNascimento))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEndereco)))))
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
                    .addComponent(lblNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNascimento)
                    .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEndereco)
                    .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelefone))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed

        if(this.ValidacoesCampos()) {
           Clientes cli = new Clientes();
           ClientesDAO cliDAO = new ClientesDAO();
           
           cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
           cli.setNome(txtNome.getText());
           cli.setNascimento(Conversor.StringParaData(txtNascimento.getText()));
           cli.setEndereco(txtEndereco.getText());
           cli.setTelefone(txtTelefone.getText());
           cli.setEmail(txtEmail.getText());

           cliDAO.create(cli);
           
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
        if(txtNome.getText().trim().isEmpty()) {
          Mensagem.ExibirMensagemErro("Preencha o Nome.");
          return false;
        }

        if(!ValidacoesCodigo())
          return false;      

        if(txtNascimento.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha a data de nascimento.");
            return false;
        }
      
        if(!Validador.ValorEDataValida(txtNascimento.getText())) {
            Mensagem.ExibirMensagemErro("Preencha uma Data Válida.");
            return false;
        }
       
        if(txtEndereco.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Endereço.");
            return false;
        }
        
        if(txtTelefone.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Telefone.");
            return false;
        }
        
        /*if(txtEmail.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Email.");
            return false;
        }*/ 
        return true;
    }
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtNome.setText("");
        txtNascimento.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }
    
    private void AtribuirValoresGradeParaEdits() {
        int row = grdClientes.getSelectedRow();
        txtCodigo.setText(grdClientes.getModel().getValueAt(row, 1).toString());
        txtNome.setText(grdClientes.getModel().getValueAt(row, 2).toString());
        txtNascimento.setText(grdClientes.getModel().getValueAt(row, 3).toString());
        txtEndereco.setText(grdClientes.getModel().getValueAt(row, 4).toString()); 
        txtTelefone.setText(grdClientes.getModel().getValueAt(row, 5).toString());
        txtEmail.setText(grdClientes.getModel().getValueAt(row, 6).toString());
    }
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
       
        if (this.ValidacoesCampos()) {
           Clientes cli = new Clientes();
           ClientesDAO cliDAO = new ClientesDAO();
           
           cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
           cli.setNome(txtNome.getText());
           cli.setNascimento(Conversor.StringParaData(txtNascimento.getText()));
           cli.setEndereco(txtEndereco.getText());
           cli.setTelefone(txtTelefone.getText());
           cli.setEmail(txtEmail.getText());

           cliDAO.update(cli);

           this.carregarGrade();
           this.limparCampos();
        }   
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grdClientesMouseClicked

        this.AtribuirValoresGradeParaEdits();
    }//GEN-LAST:event_grdClientesMouseClicked

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed

        Clientes cli = new Clientes();
        ClientesDAO cliDAO = new ClientesDAO();

        cli.setCodigo(Integer.parseInt(txtCodigo.getText()));
            
        cliDAO.delete(cli);            
        
        this.carregarGrade();
        this.limparCampos();  
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        // TODO add your handling code here:
        ClientesDAO cliDAO = new ClientesDAO();
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Clientes WHERE COD_Cli = '"+txtCodigo.getText()+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Clientes cli = new Clientes();
                
                txtCodigo.setText(rs.getString("COD_Cli"));
                txtNome.setText(rs.getString("Nome"));                
                txtNascimento.setText(rs.getString("Data_Nasc"));
                txtEndereco.setText(rs.getString("Endereco"));
                txtTelefone.setText(rs.getString("Telefone"));
                txtEmail.setText(rs.getString("Email"));                
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefoneActionPerformed

    }//GEN-LAST:event_txtTelefoneActionPerformed

    private void jmnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnOpcoesActionPerformed
        
    }//GEN-LAST:event_jmnOpcoesActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        frmCliente form = new frmCliente();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiVendaActionPerformed
        frmVenda form = new frmVenda();
        form.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jmiVendaActionPerformed

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

    private void jmiNoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNoEmailActionPerformed
        ClientesDAO cliDAO = new ClientesDAO();
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT COD_Cli,Nome FROM Clientes WHERE Email = NULL OR Email = ''");
            rs = stmt.executeQuery();
            
            StringBuilder sb = new StringBuilder();
            
            while (rs.next()) {
		sb.append(rs.getString("COD_Cli")+" - ");
                sb.append(rs.getString("Nome")+"\n");
				
            }

            System.out.println(sb);
            JOptionPane.showMessageDialog(null, sb);
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }//GEN-LAST:event_jmiNoEmailActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCliente().setVisible(true);
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
    private javax.swing.JMenuItem jmiNoEmail;
    private javax.swing.JMenuItem jmiProduto;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiVenda;
    private javax.swing.JMenu jmnNavegacao;
    private javax.swing.JMenu jmnOpcoes;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEndereco;
    private javax.swing.JLabel lblNascimento;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblTelefone;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
