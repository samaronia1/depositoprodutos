/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.map.projeto_produtos.gui;

import br.com.map.projeto_produtos.dao.ProdutoDao;
import br.com.map.projeto_produtos.model.Produto;
import br.com.map.projeto_produtos.util.MensagensUtil;
import br.com.map.projeto_produtos.util.RelatorioManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Samaronia
 */
public class ProdutosJframe extends javax.swing.JFrame {

     private ProdutoDao dao= new ProdutoDao();;
     private Produto produtoSelecionado;
    
    public ProdutosJframe()  {
       
        this.setTitle("Produtos");
        initComponents();
    }
    
        private void setProperties(){
        jMenu1.setText(MensagensUtil.getString(MensagensUtil.MSG_IDIOMA));
        LabelProdutos.setText(MensagensUtil.getString(MensagensUtil.MSG_LABEL_TITULO));
        ButtonNovo.setText(MensagensUtil.getString(MensagensUtil.MSG_BUTTON_NOVO));
        ButtonEditar.setText(MensagensUtil.getString(MensagensUtil.MSG_BUTTON_EDITAR));
        ButtonExcluir.setText(MensagensUtil.getString(MensagensUtil.MSG_BUTTON_EXCLUIR));
        ButtonSair.setText(MensagensUtil.getString(MensagensUtil.MSG_BUTTON_SAIR));
        preencherTabela(null);
    }
    public void preencherTabela( List<Produto> lista) 
    {
       try{
        List<Produto> produtos = (lista == null) ? dao.listar() : lista ;
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.setColumnCount(7);
        model.setColumnIdentifiers(new String[]{ 
            MensagensUtil.getString(MensagensUtil.MSG_TABELA_NOME),
            MensagensUtil.getString(MensagensUtil.MSG_TABELA_VALOR),
            MensagensUtil.getString(MensagensUtil.MSG_TABELA_MARCA), 
            MensagensUtil.getString(MensagensUtil.MSG_TABELA_DETALHES)});
        model.setRowCount(produtos.size());
        
        for( int i = 0; i < produtos.size(); i++){
            
            Produto p = produtos.get(i);
            
            model.setValueAt(p.getCodigo(), i, 0);
            model.setValueAt(p.getNome_produto(), i, 1);
            model.setValueAt(p.getPreco_produto(), i, 2);
            model.setValueAt(p.getEspecificacao().getMarca(), i, 3);
            model.setValueAt(p.getEspecificacao().getSistemaOpe(), i, 4);
            model.setValueAt(p.getEspecificacao().getCor(), i, 5);
            model.setValueAt(p.getEspecificacao().getDetalhes(), i, 6);
            
        }
        TableProdutos.setModel(model);
        
        
    }
       catch(Exception ex){
           ex.printStackTrace();
           JOptionPane.showMessageDialog(this, "Erro:" + ex.getMessage());
       
       }
       
    }   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        LabelProdutos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProdutos = new javax.swing.JTable();
        ButtonNovo = new javax.swing.JButton();
        ButtonEditar = new javax.swing.JButton();
        ButtonExcluir = new javax.swing.JButton();
        ButtonSair = new javax.swing.JButton();
        TextBuscar = new javax.swing.JTextField();
        LabelBuscar = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelProdutos.setFont(new java.awt.Font("Laksaman", 1, 18)); // NOI18N
        LabelProdutos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelProdutos.setText("PRODUTOS");
        LabelProdutos.setToolTipText("");

        TableProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUTO", "PREÇO", "MARCA", "DETALHES"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TableProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProdutosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProdutos);

        ButtonNovo.setText("CADASTRAR");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        ButtonEditar.setText("EDITAR");
        ButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEditarActionPerformed(evt);
            }
        });

        ButtonExcluir.setText("EXCLUIR");
        ButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonExcluirActionPerformed(evt);
            }
        });

        ButtonSair.setText("SAIR");
        ButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSairActionPerformed(evt);
            }
        });

        TextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextBuscarActionPerformed(evt);
            }
        });
        TextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextBuscarKeyReleased(evt);
            }
        });

        LabelBuscar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        LabelBuscar.setText("Buscar :");

        jMenu1.setText("Idioma");

        jMenuItem2.setText("pt_BR");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setText("es_ES");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("en_US");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Relatorio");

        jMenuItem4.setText("Lista de Produtos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Lista de Produtos por Preço");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(TextBuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ButtonNovo)
                                .addGap(43, 43, 43)
                                .addComponent(ButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(ButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(LabelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSair)
                    .addComponent(ButtonNovo)
                    .addComponent(ButtonExcluir)
                    .addComponent(ButtonEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSairActionPerformed

        this.dispose();
    }//GEN-LAST:event_ButtonSairActionPerformed

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed

        ProdutoJFrame janela = new ProdutoJFrame(this, null);
        janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        janela.setVisible(true);
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void TextBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextBuscarKeyReleased
         try {
             String busca= TextBuscar.getText();
             List<Produto> produtos = dao.buscar(busca);
             
             preencherTabela( produtos);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, "Erro"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_TextBuscarKeyReleased

    private void TableProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProdutosMouseClicked
         try {
        JTable TableProdutos = (JTable) evt.getSource();
        int linha = TableProdutos.rowAtPoint(evt.getPoint());
        int codigo = (int) TableProdutos.getModel().getValueAt(linha, 0);
        
        
             produtoSelecionado = dao.buscarPorCodigo(codigo);
             
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(this, "erro: "+ex.getMessage());
         }
        
        
    }//GEN-LAST:event_TableProdutosMouseClicked

    private void ButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonExcluirActionPerformed
        try {       
        if (produtoSelecionado!=null){
           int op = JOptionPane.showConfirmDialog(this, "Excluir "+ produtoSelecionado.getNome_produto()+ "?", "Excluir", JOptionPane.OK_CANCEL_OPTION);
           if(op == JOptionPane.OK_OPTION)
               dao.excluir(produtoSelecionado);
           produtoSelecionado = null;
           preencherTabela(null);
           }
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(this, "erro: "+ex.getMessage());
        }        
    }//GEN-LAST:event_ButtonExcluirActionPerformed

    private void ButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEditarActionPerformed
        
        if(produtoSelecionado!=null){
            ProdutoJFrame janela = new ProdutoJFrame(this,null);
            janela.setVisible(true);
            
        }
    }//GEN-LAST:event_ButtonEditarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         MensagensUtil.setLocale(MensagensUtil.LOCALE_ES_ES);
        setProperties();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
         MensagensUtil.setLocale(MensagensUtil.LOCALE_PT_BR);
        setProperties();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
         MensagensUtil.setLocale(MensagensUtil.LOCALE_EN_US);
        setProperties();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void TextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextBuscarActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      try {
            // TODO add your handling code here:
            String titrel = "Relatório de Produtos por Preço";
            Double preco_produto = null ;
            JasperPrint relatorio = RelatorioManager.gerarRelatorioProdutos(dao.listar(preco_produto));
            JFrame frame = new JFrame();
            frame.setSize(1000, 800);
            JRViewer viewer = new JRViewer(relatorio);
            frame.add(viewer);
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
         // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            JasperPrint relatorio = RelatorioManager.gerarRelatorioProdutos(dao.listar());
            String titrel = "Relatório";
            JFrame frame = new JFrame();
            frame.setSize(1000, 800);
            JRViewer viewer = new JRViewer(relatorio);
            frame.add(viewer);
            frame.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(ProdutoJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

  
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 new ProdutosJframe().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonEditar;
    private javax.swing.JButton ButtonExcluir;
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonSair;
    private javax.swing.JLabel LabelBuscar;
    private javax.swing.JLabel LabelProdutos;
    private javax.swing.JTable TableProdutos;
    private javax.swing.JTextField TextBuscar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
