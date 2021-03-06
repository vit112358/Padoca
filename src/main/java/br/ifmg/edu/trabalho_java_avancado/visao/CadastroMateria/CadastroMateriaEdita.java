/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.visao.CadastroMateria;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.modelo.Materia_Prima;
import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import br.ifmg.edu.trabalho_java_avancado.service.FornecedorService;
import br.ifmg.edu.trabalho_java_avancado.service.Materia_PrimaService;
import br.ifmg.edu.trabalho_java_avancado.service.VendedorService;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Vitor
 */
public class CadastroMateriaEdita extends javax.swing.JDialog {

    /**
     * Creates new form CadastroVendedorInclui
     */
    private Materia_PrimaService mService;
    private Materia_Prima materia;

    public CadastroMateriaEdita(JDialog parent, boolean modal, Materia_PrimaService mService, Materia_Prima m) {
        super(parent, modal);
        initComponents();

        this.mService = mService;
        this.materia = m;

        carregaCombo();
        jTxtNome.setText(m.getNome());
        jTxtPreco.setText(String.valueOf(m.getPreco()));
        jTxtEstoque.setText(String.valueOf(m.getEstoque()));
        jTxtEstoqueMin.setText(String.valueOf(m.getEstoque_min()));
        jcbxFornecedor.setSelectedItem(m.getFornecedor());
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtEstoque = new javax.swing.JTextField();
        jTxtPreco = new javax.swing.JTextField();
        jTxtEstoqueMin = new javax.swing.JTextField();
        jcbxFornecedor = new javax.swing.JComboBox<>();
        jTxtNome = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jBtnSalva = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Padaria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Vendedor"));

        jLabel1.setText("Descrição:");

        jLabel2.setText("Preço:");

        jLabel3.setText("Estoque:");

        jLabel4.setText("Esroque Mínimo:");

        jLabel5.setText("Fornecedor:");

        jcbxFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbxFornecedor, javax.swing.GroupLayout.Alignment.TRAILING, 0, 197, Short.MAX_VALUE)
                    .addComponent(jTxtPreco)
                    .addComponent(jTxtEstoqueMin)
                    .addComponent(jTxtEstoque)
                    .addComponent(jTxtNome))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTxtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtEstoqueMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbxFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jBtnSalva.setText("Salvar");
        jBtnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalvaActionPerformed(evt);
            }
        });

        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSalva)
                .addGap(30, 30, 30)
                .addComponent(jBtnFechar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSalva)
                    .addComponent(jBtnFechar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(399, 352));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalvaActionPerformed
        // TODO add your handling code here:

        if (jTxtNome.getText() == null || jTxtNome.getText().trim().equals("")
                || jTxtEstoque.getText() == null || jTxtEstoque.getText().trim().equals("")
                || jTxtEstoqueMin.getText() == null || jTxtEstoqueMin.getText().trim().equals("")
                || jTxtPreco.getText() == null || jTxtPreco.getText().trim().equals("")
                || jcbxFornecedor.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this,
                    "Existem Campos obrigatórios não preenchidos");
            return;
        }

        int resp = JOptionPane.showConfirmDialog(this,
                "Confirma a inclusão?",
                "Incluir registro",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resp != JOptionPane.YES_OPTION) {
            return;
        }
        
        if(jTxtPreco.getText().contains(",")){
            jTxtPreco.setText(jTxtPreco.getText().replace(",", "."));
        }
        
        materia.setNome(jTxtNome.getText());
        materia.setPreco(Float.parseFloat(jTxtPreco.getText()));
        materia.setEstoque(Float.parseFloat(jTxtEstoque.getText()));
        materia.setEstoque_min(Float.parseFloat(jTxtEstoqueMin.getText()));
        materia.setFornecedor((Fornecedor)jcbxFornecedor.getSelectedItem());
       
        try {
            mService.salvar(materia);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

    }//GEN-LAST:event_jBtnSalvaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnSalva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTxtEstoque;
    private javax.swing.JTextField jTxtEstoqueMin;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPreco;
    private javax.swing.JComboBox<String> jcbxFornecedor;
    // End of variables declaration//GEN-END:variables

    private void carregaCombo() {
        
        FornecedorService fService = new FornecedorService();
        Vector<Fornecedor> fornecedor = new Vector<>(fService.buscarTodos());
        DefaultComboBoxModel dcmFornecedores = new DefaultComboBoxModel(fornecedor);
        jcbxFornecedor.setModel(dcmFornecedores);
    }
}
