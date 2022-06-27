/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.Formatacao;
import apoio.IItemPesquisa;
import dao.OSDAO;
import dao.OSItemDAO;
import entidade.OS;
import entidade.OSItem;
import javax.swing.JOptionPane;

/**
 *
 * @author pretto
 */
public class IfrOS extends javax.swing.JInternalFrame implements IItemPesquisa {

    int idOS = 0;
    double total = 0.0;

    /**
     * Creates new form IfrOS
     */
    public IfrOS() {
        initComponents();

        // setup
        tffDataOS.setText(Formatacao.getDataAtual());

        tfdIdPessoa.setEditable(false);
        tfdNomePessoa.setEditable(false);
        tfdTotal.setEditable(false);

        tfdIdItem.setEditable(false);
        tfdItem.setEditable(false);
        tfdValor.setEditable(false);

        btnLocalizarItem.setEnabled(false);
        btnRemover.setEnabled(false);
        btnInserir.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tffDataOS = new javax.swing.JFormattedTextField();
        tfdNomePessoa = new javax.swing.JTextField();
        tfdIdPessoa = new javax.swing.JTextField();
        btnLocalizarPessoa = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItemOS = new javax.swing.JTable();
        tfdItem = new javax.swing.JTextField();
        btnLocalizarItem = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        tfdValor = new javax.swing.JTextField();
        tfdIdItem = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfdQtde = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdTotal = new javax.swing.JTextField();

        setTitle("Ordem de Serviço");

        jLabel1.setText("Data");

        jLabel2.setText("Cliente");

        tffDataOS.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnLocalizarPessoa.setText("Localizar");
        btnLocalizarPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarPessoaActionPerformed(evt);
            }
        });

        btnCriar.setText("Criar");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        jLabel3.setText("Item");

        tblItemOS.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblItemOS);

        btnLocalizarItem.setText("Localizar");
        btnLocalizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarItemActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        jLabel5.setText("TOTAL");

        tfdTotal.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tfdTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCriar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnFechar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfdQtde, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                    .addComponent(tfdIdItem))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(tfdItem, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLocalizarItem))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tffDataOS)
                            .addComponent(tfdIdPessoa, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(tfdNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLocalizarPessoa)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(tffDataOS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdIdPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarPessoa))
                .addGap(26, 26, 26)
                .addComponent(btnCriar)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizarItem)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdIdItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInserir)
                    .addComponent(btnRemover)
                    .addComponent(jLabel4)
                    .addComponent(tfdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(jLabel5)
                    .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnLocalizarPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarPessoaActionPerformed
        new DlgLocalizar(null, true, this, "pessoa").setVisible(true);
    }//GEN-LAST:event_btnLocalizarPessoaActionPerformed

    private void btnLocalizarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarItemActionPerformed
        new DlgLocalizar(null, true, this, "item").setVisible(true);
    }//GEN-LAST:event_btnLocalizarItemActionPerformed

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed

        OS os = new OS();
        
        os.setData(tffDataOS.getText());
        os.setPessoa_id(Integer.parseInt(tfdIdPessoa.getText()));
        os.setSituacao('a');

        String retorno = new OSDAO().salvar(os);

        System.out.println("Id Os retorno: " + retorno);

        if (!retorno.contains("ERROR")) {
            idOS = Integer.parseInt(retorno);

            btnCriar.setEnabled(false);
            btnLocalizarItem.setEnabled(true);
            btnRemover.setEnabled(true);
            btnInserir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao criar OS: " + retorno);
        }
    }//GEN-LAST:event_btnCriarActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        OSItem osItem = new OSItem();

        osItem.setOsId(idOS);
        osItem.setItemId(Integer.parseInt(tfdIdItem.getText()));
        osItem.setQtde(Double.parseDouble(tfdQtde.getText()));
        osItem.setValor(Double.parseDouble(tfdValor.getText()));

        if (new OSItemDAO().salvar(osItem) == null) {
            JOptionPane.showMessageDialog(null, "Item inserido.");

            new OSItemDAO().popularTabela(tblItemOS, "", idOS);

            total += (osItem.getValor() * osItem.getQtde());

            tfdTotal.setText(String.valueOf(total));

            tfdIdItem.setText("");
            tfdItem.setText("");
            tfdValor.setText("");
            tfdQtde.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Erro na inserção.");
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblItemOS.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um registro.");
        } else {
            int idOSIt = Integer.parseInt(String.valueOf(tblItemOS.getValueAt(tblItemOS.getSelectedRow(), 0)));

            System.out.println("OSIt: " + idOSIt);

            String retorno = new OSItemDAO().excluir(idOSIt);

            if (retorno == null) {
                JOptionPane.showMessageDialog(null, "Registro remvodio.");

                double qtde = Double.parseDouble(String.valueOf(tblItemOS.getValueAt(tblItemOS.getSelectedRow(), 3)));
                double valor = Double.parseDouble(String.valueOf(tblItemOS.getValueAt(tblItemOS.getSelectedRow(), 4)));

                total -= (qtde * valor);

                tfdTotal.setText(String.valueOf(total));

                new OSItemDAO().popularTabela(tblItemOS, "", idOS);
            } else {
                JOptionPane.showMessageDialog(null, "Erro: Problemas ao remover registro.\n\n" + retorno);
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    @Override
    public void definirValor(String[] valores, String itemPesquisa) {
        if (itemPesquisa.equalsIgnoreCase("pessoa")) {
            tfdIdPessoa.setText(valores[0]);
            tfdNomePessoa.setText(valores[1]);
        } else if (itemPesquisa.equalsIgnoreCase("item")) {
            tfdIdItem.setText(valores[0]);
            tfdItem.setText(valores[1]);
            tfdValor.setText(valores[2]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnLocalizarItem;
    private javax.swing.JButton btnLocalizarPessoa;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblItemOS;
    private javax.swing.JTextField tfdIdItem;
    private javax.swing.JTextField tfdIdPessoa;
    private javax.swing.JTextField tfdItem;
    private javax.swing.JTextField tfdNomePessoa;
    private javax.swing.JTextField tfdQtde;
    private javax.swing.JTextField tfdTotal;
    private javax.swing.JTextField tfdValor;
    private javax.swing.JFormattedTextField tffDataOS;
    // End of variables declaration//GEN-END:variables

}
