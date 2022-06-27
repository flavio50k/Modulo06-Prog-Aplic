/**
 * @author Flavio
 */
package tela;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.Validacao;
import dao.ClientesDAO;
import entidade.Clientes;
import java.awt.Color;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IfrClientes extends javax.swing.JInternalFrame {

    int idCliente = 0;

    public IfrClientes() {
        initComponents();
        
        Formatacao.formatarCpf(tffClientesCadCpf);
        Formatacao.formatarTelefone(tffClientesCadTelefone);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnClientesFechar = new javax.swing.JButton();
        tpnClientes = new javax.swing.JTabbedPane();
        pnlClientesCad = new javax.swing.JPanel();
        lblClientesCadNome = new javax.swing.JLabel();
        tfdClientesCadNome = new javax.swing.JTextField();
        lblClientesCadEmail = new javax.swing.JLabel();
        lblClientesCadCpf = new javax.swing.JLabel();
        lblClientesCadTelefone = new javax.swing.JLabel();
        tfdClientesCadEmail = new javax.swing.JTextField();
        tffClientesCadCpf = new javax.swing.JFormattedTextField();
        tffClientesCadTelefone = new javax.swing.JFormattedTextField();
        pnlClientesCons = new javax.swing.JPanel();
        spnClientesCons = new javax.swing.JScrollPane();
        tblClientesCons = new javax.swing.JTable();
        lblClientesConsBusca = new javax.swing.JLabel();
        tfdClientesConsConsultar = new javax.swing.JTextField();
        btnClientesConsConsultar = new javax.swing.JButton();
        btnClientesSalvar = new javax.swing.JButton();
        btnClientesEditar = new javax.swing.JButton();
        btnClientesExcluir = new javax.swing.JButton();

        setTitle("Cadastro de Clientes");

        btnClientesFechar.setText("Fechar");
        btnClientesFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesFecharActionPerformed(evt);
            }
        });

        lblClientesCadNome.setText("Nome: ");

        lblClientesCadEmail.setText("E-mail: ");

        lblClientesCadCpf.setText("CPF: ");

        lblClientesCadTelefone.setText("Telefone: ");

        tffClientesCadCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tffClientesCadCpfFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnlClientesCadLayout = new javax.swing.GroupLayout(pnlClientesCad);
        pnlClientesCad.setLayout(pnlClientesCadLayout);
        pnlClientesCadLayout.setHorizontalGroup(
            pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesCadLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClientesCadEmail)
                    .addComponent(lblClientesCadCpf)
                    .addComponent(lblClientesCadNome))
                .addGap(29, 29, 29)
                .addGroup(pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlClientesCadLayout.createSequentialGroup()
                        .addComponent(tffClientesCadCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(lblClientesCadTelefone)
                        .addGap(18, 18, 18)
                        .addComponent(tffClientesCadTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 390, Short.MAX_VALUE))
                    .addComponent(tfdClientesCadNome)
                    .addComponent(tfdClientesCadEmail))
                .addContainerGap())
        );
        pnlClientesCadLayout.setVerticalGroup(
            pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClientesCadLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientesCadNome)
                    .addComponent(tfdClientesCadNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientesCadEmail)
                    .addComponent(tfdClientesCadEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlClientesCadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientesCadCpf)
                    .addComponent(lblClientesCadTelefone)
                    .addComponent(tffClientesCadCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tffClientesCadTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        tpnClientes.addTab("Cadastro", pnlClientesCad);

        tblClientesCons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "E-mail", "CPF", "Telefone"
            }
        ));
        spnClientesCons.setViewportView(tblClientesCons);

        lblClientesConsBusca.setText("Busca");

        btnClientesConsConsultar.setText("Consultar");
        btnClientesConsConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesConsConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClientesConsLayout = new javax.swing.GroupLayout(pnlClientesCons);
        pnlClientesCons.setLayout(pnlClientesConsLayout);
        pnlClientesConsLayout.setHorizontalGroup(
            pnlClientesConsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spnClientesCons, javax.swing.GroupLayout.DEFAULT_SIZE, 1060, Short.MAX_VALUE)
            .addGroup(pnlClientesConsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientesConsBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdClientesConsConsultar)
                .addGap(18, 18, 18)
                .addComponent(btnClientesConsConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlClientesConsLayout.setVerticalGroup(
            pnlClientesConsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClientesConsLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(pnlClientesConsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientesConsBusca)
                    .addComponent(tfdClientesConsConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClientesConsConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnClientesCons, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tpnClientes.addTab("Consulta", pnlClientesCons);

        btnClientesSalvar.setText("Salvar");
        btnClientesSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesSalvarActionPerformed(evt);
            }
        });

        btnClientesEditar.setText("Editar");
        btnClientesEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesEditarActionPerformed(evt);
            }
        });

        btnClientesExcluir.setText("Excluir");
        btnClientesExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpnClientes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClientesEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnClientesSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnClientesExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btnClientesFechar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tpnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientesFechar)
                    .addComponent(btnClientesSalvar)
                    .addComponent(btnClientesEditar)
                    .addComponent(btnClientesExcluir))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClientesFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnClientesFecharActionPerformed

    private void btnClientesSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesSalvarActionPerformed
        String nomeCliente = tfdClientesCadNome.getText();
        String nomeEmail = tfdClientesCadEmail.getText();
        String nomeCpf = tffClientesCadCpf.getText();
        String nomeTelefone = tffClientesCadTelefone.getText();

        Clientes cliente = new Clientes();
        cliente.setId(idCliente);
        cliente.setNome(nomeCliente);
        cliente.setE_mail(nomeEmail);
        cliente.setCpf(nomeCpf);
        cliente.setTelefone(nomeTelefone);

        ClientesDAO clienteDAO = new ClientesDAO();

        if (idCliente == 0) {
            if (clienteDAO.salvar(cliente) == null) {
                tfdClientesCadNome.setText("");
                tfdClientesCadEmail.setText("");
                tffClientesCadCpf.setText("");
                tffClientesCadTelefone.setText("");

                JOptionPane.showMessageDialog(this, "Registro salvo com sucesso!");
                tfdClientesCadNome.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao salvar registro!");
            }
        } else {
            if (clienteDAO.atualizar(cliente) == null) {
                tfdClientesCadNome.setText("");
                tfdClientesCadEmail.setText("");
                tffClientesCadCpf.setText("");
                tffClientesCadTelefone.setText("");

                JOptionPane.showMessageDialog(this, "Registro alterado com sucesso!");
                tfdClientesCadNome.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Problemas ao alterar registro!");
            }
        }
        idCliente = 0;
    }//GEN-LAST:event_btnClientesSalvarActionPerformed

    private void btnClientesEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesEditarActionPerformed
        String idTabela = String.valueOf(tblClientesCons.getValueAt(tblClientesCons.getSelectedRow(), 0));
        idCliente = Integer.parseInt(idTabela);
        Clientes cliente = new ClientesDAO().consultarId(idCliente);

        if (cliente != null) {
            tpnClientes.setSelectedIndex(0);
            tfdClientesCadNome.setText(cliente.getNome());
            tfdClientesCadEmail.setText(cliente.getE_mail());
            tffClientesCadCpf.setText(cliente.getCpf());
            tffClientesCadTelefone.setText(cliente.getTelefone());
            
            tfdClientesCadNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Código do cliente não encontrado!");
        }
    }//GEN-LAST:event_btnClientesEditarActionPerformed

    private void btnClientesConsConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesConsConsultarActionPerformed
        new ClientesDAO().popularTabela(tblClientesCons, tfdClientesConsConsultar.getText());
    }//GEN-LAST:event_btnClientesConsConsultarActionPerformed

    private void btnClientesExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesExcluirActionPerformed
        String idTabela = String.valueOf(tblClientesCons.getValueAt(tblClientesCons.getSelectedRow(), 0));
        idCliente = Integer.parseInt(idTabela);
        if (new ClientesDAO().excluir(idCliente) == null){
            JOptionPane.showMessageDialog(this, "Registro Excluído com Sucesso!");
            new ClientesDAO().popularTabela(tblClientesCons, tfdClientesConsConsultar.getText());
        } else{
            JOptionPane.showMessageDialog(this, "Problema ao excluir o Registro!");
        }
        idCliente = 0;
    }//GEN-LAST:event_btnClientesExcluirActionPerformed

    private void tffClientesCadCpfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tffClientesCadCpfFocusLost
        if (!Validacao.validarCPF(Formatacao.removerFormatacao(tffClientesCadCpf.getText()))) {
            tffClientesCadCpf.setBackground(Color.YELLOW);
        } else {
            tffClientesCadCpf.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_tffClientesCadCpfFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientesConsConsultar;
    private javax.swing.JButton btnClientesEditar;
    private javax.swing.JButton btnClientesExcluir;
    private javax.swing.JButton btnClientesFechar;
    private javax.swing.JButton btnClientesSalvar;
    private javax.swing.JLabel lblClientesCadCpf;
    private javax.swing.JLabel lblClientesCadEmail;
    private javax.swing.JLabel lblClientesCadNome;
    private javax.swing.JLabel lblClientesCadTelefone;
    private javax.swing.JLabel lblClientesConsBusca;
    private javax.swing.JPanel pnlClientesCad;
    private javax.swing.JPanel pnlClientesCons;
    private javax.swing.JScrollPane spnClientesCons;
    private javax.swing.JTable tblClientesCons;
    private javax.swing.JTextField tfdClientesCadEmail;
    private javax.swing.JTextField tfdClientesCadNome;
    private javax.swing.JTextField tfdClientesConsConsultar;
    private javax.swing.JFormattedTextField tffClientesCadCpf;
    private javax.swing.JFormattedTextField tffClientesCadTelefone;
    private javax.swing.JTabbedPane tpnClientes;
    // End of variables declaration//GEN-END:variables
}
