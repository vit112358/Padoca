package br.ifmg.edu.trabalho_java_avancado.visao.CadastroProdProduzidos;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutoProduzido;
import br.ifmg.edu.trabalho_java_avancado.service.ProdutosProduzidosService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class CadastroProdProduzidosListagem extends javax.swing.JDialog {
    
    private final ProdutosProduzidosService PTService = new ProdutosProduzidosService();
    private List<ProdutoProduzido> prods;
    private ProdProduzidosTableModel prodTabModel;
    
    public CadastroProdProduzidosListagem(java.awt.Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        
        atualizaDados();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProdTerc = new javax.swing.JTable();
        jTBBotoes = new javax.swing.JToolBar();
        jBtnIncluir = new javax.swing.JButton();
        jBtnEditar = new javax.swing.JButton();
        jBtnRemover = new javax.swing.JButton();
        jBtnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Padaria");

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jTableProdTerc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableProdTerc);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );

        jTBBotoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastro - Produto Produzidos"));
        jTBBotoes.setRollover(true);

        jBtnIncluir.setText("Incluir");
        jBtnIncluir.setFocusable(false);
        jBtnIncluir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnIncluir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jBtnIncluirMouseEntered(evt);
            }
        });
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnIncluir);

        jBtnEditar.setText("Editar");
        jBtnEditar.setFocusable(false);
        jBtnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditarActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnEditar);

        jBtnRemover.setText("Remover");
        jBtnRemover.setFocusable(false);
        jBtnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRemoverActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnRemover);

        jBtnAtualizar.setText("Atualizar");
        jBtnAtualizar.setFocusable(false);
        jBtnAtualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jBtnAtualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jBtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizarActionPerformed(evt);
            }
        });
        jTBBotoes.add(jBtnAtualizar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTBBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTBBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(701, 543));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBtnIncluirMouseEntered
        // TODO add your handling code here:
        jBtnIncluir.setToolTipText("Neste Botão será possível cadastrar um "
                + "Produto que foi Produzido pela Padaria!");
    }//GEN-LAST:event_jBtnIncluirMouseEntered

    private void jBtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizarActionPerformed
        // TODO add your handling code here:
        atualizaDados();
    }//GEN-LAST:event_jBtnAtualizarActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        CadastroProdProdInclui dialog = new CadastroProdProdInclui(this, true, PTService);
        dialog.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditarActionPerformed
        // TODO add your handling code here:
        if(jTableProdTerc.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, 
                    "Por favor, selecione um registro");            
            return;
        }
        
        ProdutoProduzido p = prods.get(jTableProdTerc.getSelectedRow());
        
        CadastroProdProdEdita dialog = new CadastroProdProdEdita(this, true, PTService, p);
        dialog.setVisible(true);
        atualizaDados();
    }//GEN-LAST:event_jBtnEditarActionPerformed

    private void jBtnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRemoverActionPerformed
        // TODO add your handling code here:
        if(jTableProdTerc.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, 
                    "Por favor, selecione um registro");            
            return;
        }
        
        int resp = JOptionPane.showConfirmDialog(this, 
                "Confirma a exclusão?",
                "Excluir registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        
        if (resp != JOptionPane.YES_OPTION)
           return;
        
        ProdutoProduzido p = prods.get(jTableProdTerc.getSelectedRow());
        PTService.remover(p);
        atualizaDados();
    }//GEN-LAST:event_jBtnRemoverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProdProduzidosListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdProduzidosListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdProduzidosListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdProduzidosListagem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroProdProduzidosListagem dialog = new CadastroProdProduzidosListagem(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAtualizar;
    private javax.swing.JButton jBtnEditar;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnRemover;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jTBBotoes;
    private javax.swing.JTable jTableProdTerc;
    // End of variables declaration//GEN-END:variables

    private void atualizaDados() {
        //1-buscando os dados do BD
       prods = PTService.buscarTodos();
       //vendas.add(vService.buscarPorCodigo(2));
        //2-configurando o modelo com os dados do bd
       prodTabModel = new ProdProduzidosTableModel(prods);
       //3-configurando o Jtable com o modelo criado
       jTableProdTerc.setModel(prodTabModel);
    }
}
