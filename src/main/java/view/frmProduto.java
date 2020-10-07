package view;

import DAO.ProdutosDAO;
import connection.ConnectionFactory;
import utilities.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import objects.Produtos;

/*Listagem de clientes sem e-mail
 Listagem de produtos que estão vencidos na data atual
 Quantidade de vendas realizadas no ano de 2020 (agrupadas por cliente)
 Listagem de vendas (contendo o valor total da mesma).*/

public class frmProduto extends javax.swing.JFrame {

    public frmProduto() {
        initComponents();     
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        grdClientes.setRowSorter(new TableRowSorter(modelo));
        
        carregarGrade();
    }

    public void carregarGrade()
    {
        ProdutosDAO prodDAO = new ProdutosDAO();
        
        DefaultTableModel modelo = (DefaultTableModel) grdClientes.getModel();
        modelo.setNumRows(0);
        
        for(Produtos prod: prodDAO.read()){
            modelo.addRow(new Object[]{
                prod.getCodigoProd(),
                prod.getPrecoVenda(),
                prod.getDescricao(),
                prod.getValidade(),
                prod.getPrecoCusto(),
                prod.getEstoque(),
                prod.getCodigoDist()});
        }
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnConsultar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtEstoque = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        grdClientes = new javax.swing.JTable();
        lblPrecoV = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        lblEstoque = new javax.swing.JLabel();
        lblPrecoC = new javax.swing.JLabel();
        txtPrecoC = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        lblDataV = new javax.swing.JLabel();
        txtDataV = new javax.swing.JTextField();
        lblCodigoDist = new javax.swing.JLabel();
        txtCodigoDist = new javax.swing.JTextField();
        txtPrecoV = new javax.swing.JTextField();
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
        setTitle("Produto");

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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Preço Venda", "Descrição", "Data Válidade", "Preço Custo", "Estoque", "Código Dist..."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
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

        lblPrecoV.setText("Preço Venda:");

        lblDescricao.setText("Descrição:");

        lblEstoque.setText("Estoque:");

        lblPrecoC.setText("Preço Custo:");

        lblCodigo.setText("Código:");

        lblDataV.setText("Data Validade:");

        lblCodigoDist.setText("Código Distribuidor:");

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
                                .addComponent(lblPrecoV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecoV)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPrecoC, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(txtPrecoC))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEstoque))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigo))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDescricao))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDataV, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDataV))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCodigoDist, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoDist)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
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
                    .addComponent(lblPrecoV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPrecoV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescricao)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataV)
                    .addComponent(txtDataV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrecoC))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigoDist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigoDist, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {                                        

        if(this.ValidacoesCampos()) {
           Produtos prod = new Produtos();
           ProdutosDAO prodDAO = new ProdutosDAO();
           
           prod.setCodigoProd(Integer.parseInt(txtCodigo.getText()));
           prod.setPrecoVenda(Float.parseFloat(txtPrecoV.getText()));
           prod.setDescricao(txtDescricao.getText());
           prod.setDataValidade(Conversor.StringParaData(txtDataV.getText()));
           prod.setPrecoCusto(Float.parseFloat(txtPrecoC.getText()));
           prod.setEstoque(Integer.parseInt(txtEstoque.getText()));
           prod.setCodigoDist(Integer.parseInt(txtCodigoDist.getText()));

           prodDAO.create(prod);
           
           this.carregarGrade();
           this.limparCampos();
        } 
    }                                       

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
        if(txtPrecoV.getText().trim().isEmpty()) {
          Mensagem.ExibirMensagemErro("Preencha o Preço da Venda.");
          return false;
        }

        if(!ValidacoesCodigo())
          return false;      

        if(txtDescricao.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha a Descrição.");
            return false;
        }
       
        if(!Validador.ValorEDataValida(txtDataV.getText())) {
            Mensagem.ExibirMensagemErro("Preencha o Data da Válidade.");
            return false;
        }
        
        if(txtPrecoC.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Preço de Custo.");
            return false;
        }
        
        /*if(txtEstoque.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Estoque.");
            return false;
        }*/
        
        if(txtCodigoDist.getText().trim().isEmpty()) {
            Mensagem.ExibirMensagemErro("Preencha o Código do Distribuidor.");
            return false;
        } 
        return true;
    }
    
    private void limparCampos() {
        txtCodigo.setText("");
        txtPrecoV.setText("");
        txtDescricao.setText("");
        txtDataV.setText("");
        txtPrecoC.setText("");
        txtEstoque.setText("");
        txtCodigoDist.setText("");
    }
    
    private void AtribuirValoresGradeParaEdits() {
        int row = grdClientes.getSelectedRow();
        txtCodigo.setText(grdClientes.getModel().getValueAt(row, 1).toString());
        txtPrecoV.setText(grdClientes.getModel().getValueAt(row, 2).toString());
        txtDescricao.setText(grdClientes.getModel().getValueAt(row, 3).toString());
        txtDataV.setText(grdClientes.getModel().getValueAt(row, 4).toString()); 
        txtPrecoC.setText(grdClientes.getModel().getValueAt(row, 5).toString());
        txtEstoque.setText(grdClientes.getModel().getValueAt(row, 6).toString());
        txtCodigoDist.setText(grdClientes.getModel().getValueAt(row, 7).toString());
    }
    
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
       
        if (this.ValidacoesCampos()) {
           Produtos prod = new Produtos();
           ProdutosDAO prodDAO = new ProdutosDAO();
           
           prod.setCodigoProd(Integer.parseInt(txtCodigo.getText()));
           prod.setPrecoVenda(Float.parseFloat(txtPrecoV.getText()));
           prod.setDescricao(txtDescricao.getText());
           prod.setDataValidade(Conversor.StringParaData(txtDataV.getText()));
           prod.setPrecoCusto(Float.parseFloat(txtPrecoC.getText()));
           prod.setEstoque(Integer.parseInt(txtEstoque.getText()));
           prod.setCodigoDist(Integer.parseInt(txtCodigoDist.getText()));

           prodDAO.update(prod);

           this.carregarGrade();
           this.limparCampos();
        }   
    }                                         

    private void grdClientesMouseClicked(java.awt.event.MouseEvent evt) {                                         

        this.AtribuirValoresGradeParaEdits();
    }                                        

    
    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           

        Produtos prod = new Produtos();
        ProdutosDAO prodDAO = new ProdutosDAO();

        prod.setCodigoProd(Integer.parseInt(txtCodigo.getText()));
            
        prodDAO.delete(prod);            
        
        this.carregarGrade();
        this.limparCampos();  
    }                                          

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        ProdutosDAO prodDAO = new ProdutosDAO();
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Produtos WHERE COD_Prod = '"+txtCodigo.getText()+"'");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produtos prod = new Produtos();
                
                txtCodigo.setText(rs.getString("COD_Prod"));
                txtPrecoV.setText(rs.getString("Preco_Venda"));                
                txtDescricao.setText(rs.getString("Descricao"));
                txtDataV.setText(rs.getString("Data_Validade"));
                txtPrecoC.setText(rs.getString("Preco_Custo"));
                txtEstoque.setText(rs.getString("Estoque"));
                txtCodigoDist.setText(rs.getString("COD_Dist"));
                
                Validador.DataValidade(rs.getString("Data_Validade"));
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    private void txtPrecoCActionPerformed(java.awt.event.ActionEvent evt) {                                            
    
    }

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {                                        
        System.exit(0);
    }                                       

    private void jmnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {                                          

    }                                         

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {                                            
        frmCliente form = new frmCliente();
        form.setVisible(true);
        this.setVisible(false);
    }                                           

    private void jmiDistribuidoresActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        frmDistribuidores form = new frmDistribuidores();
        form.setVisible(true);
        this.setVisible(false);
    }                                                 

    private void jmiItemVendaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        frmItemVenda form = new frmItemVenda();
        form.setVisible(true);
        this.setVisible(false);
    }                                            

    private void jmiProdutoActionPerformed(java.awt.event.ActionEvent evt) {                                           
        frmProduto form = new frmProduto();
        form.setVisible(true);
        this.setVisible(false);
    }                                          

    private void jmiVendaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        frmVenda form = new frmVenda();
        form.setVisible(true);
        this.setVisible(false);
    }                                        
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
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
    private javax.swing.JLabel lblCodigoDist;
    private javax.swing.JLabel lblDataV;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblEstoque;
    private javax.swing.JLabel lblPrecoC;
    private javax.swing.JLabel lblPrecoV;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoDist;
    private javax.swing.JTextField txtDataV;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEstoque;
    private javax.swing.JTextField txtPrecoC;
    private javax.swing.JTextField txtPrecoV;
    // End of variables declaration                   
}

