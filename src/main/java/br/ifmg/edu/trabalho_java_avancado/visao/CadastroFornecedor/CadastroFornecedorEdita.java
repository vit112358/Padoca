package br.ifmg.edu.trabalho_java_avancado.visao.CadastroFornecedor;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.service.FornecedorService;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import br.ifmg.edu.trabalho_java_avancado.util.ValidaCNPJ;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class CadastroFornecedorEdita extends javax.swing.JDialog {

    /**
     * Creates new form CadastroVendedorInclui
     */
    private FornecedorService fService;
    private Fornecedor f;

    public CadastroFornecedorEdita(JDialog parent, boolean modal, FornecedorService fService, Fornecedor f) {
        super(parent, modal);
        initComponents();

        this.fService = fService;
        this.f = f;
        
        carregaCombo();
        
        jCbxRazao.setSelectedItem(this.f.getRazaoSocial());
        jTxtNomeFan.setText(this.f.getNomeFantasia());
        jTxtEnd.setText(this.f.getEndereco());
        
        String cnpj = this.f.getCNPJ();
        cnpj = cnpj.replace(".", "");
        cnpj = cnpj.replace("-", "");
        cnpj = cnpj.replace("/", "");
        jFmtCNPJ.setText(cnpj);
        
        String tel = this.f.getTelefone();
        tel = tel.replace("(", "");
        tel = tel.replace("-", "");
        tel = tel.replace(")", "");
        jFmtTelefone.setText(tel);
        
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
        jTxtNomeFan = new javax.swing.JTextField();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jTxtEnd = new javax.swing.JTextField();
        jFmtCNPJ = new javax.swing.JFormattedTextField();
        jCbxRazao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jBtnSalva = new javax.swing.JButton();
        jBtnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Padaria");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Fornecedor"));

        jLabel1.setText("Razão Social:");

        jLabel2.setText("Nome Fantasia:");

        jLabel3.setText("Telefone:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("CNPJ:");

        try {
            jFmtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFmtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jCbxRazao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtNomeFan)
                    .addComponent(jFmtTelefone)
                    .addComponent(jTxtEnd)
                    .addComponent(jFmtCNPJ, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                    .addComponent(jCbxRazao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jCbxRazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtNomeFan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jFmtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
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
                .addContainerGap(195, Short.MAX_VALUE)
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
        if (jTxtNomeFan.getText() == null || jTxtNomeFan.getText().trim().equals("")
                || jCbxRazao.getSelectedItem() == null
                || jTxtEnd.getText() == null || jTxtEnd.getText().trim().equals("")
                || jFmtCNPJ.getText() == null || jFmtTelefone.getText() == null) {
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
        
        f.setNomeFantasia(jTxtNomeFan.getText());
        f.setRazaoSocial(jCbxRazao.getSelectedItem().toString());
        f.setEndereco(jTxtEnd.getText());
        f.setTelefone(jFmtTelefone.getText());
        f.setCNPJ(jFmtCNPJ.getText());
        String a = jFmtCNPJ.getText();
        a = a.replace(".", "");
        a = a.replace("-", "");
        a = a.replace("/", "");
        if (ValidaCNPJ.isCNPJ(a)) {
            try {
                fService.salvar(f);
            } catch (NegocioException ex) {
                Logger.getLogger(CadastroFornecedorEdita.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "CNPJ Inválido!!");
        }
    }//GEN-LAST:event_jBtnSalvaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnSalva;
    private javax.swing.JComboBox<String> jCbxRazao;
    private javax.swing.JFormattedTextField jFmtCNPJ;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTxtEnd;
    private javax.swing.JTextField jTxtNomeFan;
    // End of variables declaration//GEN-END:variables

    private void carregaCombo() {
        Vector<Fornecedor> Fornecedores = new Vector<>(fService.buscarTodos());
        
        DefaultComboBoxModel dcmForn = new DefaultComboBoxModel(Fornecedores);
        
        jCbxRazao.setModel(dcmForn);
    }
}
