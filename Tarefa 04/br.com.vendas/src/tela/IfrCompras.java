/**
 * @author Flavio
 */
package tela;

import apoio.Formatacao;
import apoio.IItemPesquisa;
import dao.ComprasDAO;
import dao.Itens_ComprasDAO;
import dao.ProdutosDAO;
import entidade.Compras;
import entidade.Itens_Compras;
import entidade.Produtos;
import javax.swing.JOptionPane;

public class IfrCompras extends javax.swing.JInternalFrame implements IItemPesquisa {

    int idCompra = 0;
    double total = 0.0;

    public IfrCompras() {
        initComponents();

        tffData.setText(Formatacao.getDataAtual());

        tfdTotal.setEditable(false);
        tffData.setEditable(false);

        tfdFornecedorID.setEditable(false);
        tfdFornecedorNome.setEditable(false);

        tfdItemID.setEditable(false);
        tfdItemDescr.setEditable(false);
        btnItemConsultar.setEnabled(false);
        tfdQtde.setEditable(false);
        tfdValor.setEditable(false);

        tblConsulta.setEnabled(false);

        btnNovo.setEnabled(false);
        btnInserir.setEnabled(false);
        btnRemover.setEnabled(false);

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tffData = new javax.swing.JFormattedTextField();
        tfdTotal = new javax.swing.JTextField();
        tfdFornecedorID = new javax.swing.JTextField();
        tfdFornecedorNome = new javax.swing.JTextField();
        btnFornecedorConsultar = new javax.swing.JButton();
        tfdItemID = new javax.swing.JTextField();
        tfdItemDescr = new javax.swing.JTextField();
        btnItemConsultar = new javax.swing.JButton();
        tfdQtde = new javax.swing.JTextField();
        scrollConsulta = new javax.swing.JScrollPane();
        tblConsulta = new javax.swing.JTable();
        btnNovo = new javax.swing.JButton();
        btnInserir = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        tfdValor = new javax.swing.JTextField();

        setTitle("Compras");

        jLabel1.setText("Data:");

        jLabel2.setText("Fornecedor:");

        jLabel3.setText("Item:");

        jLabel4.setText("Qtde:");

        jLabel5.setText("Total da Compra:");

        tffData.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfdTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tfdFornecedorID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnFornecedorConsultar.setText("Consultar");
        btnFornecedorConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFornecedorConsultarActionPerformed(evt);
            }
        });

        tfdItemID.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btnItemConsultar.setText("Consultar");
        btnItemConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemConsultarActionPerformed(evt);
            }
        });

        tfdQtde.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfdQtde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdQtdeKeyTyped(evt);
            }
        });

        tblConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "C??digo", "Descri????o", "Quantidade", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollConsulta.setViewportView(tblConsulta);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
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

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        tfdValor.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfdValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfdValorKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(tfdFornecedorID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(tfdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(tfdItemID, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel5))
                                        .addComponent(tfdFornecedorNome))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnFornecedorConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfdTotal)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tfdItemDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(btnInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(tfdValor))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnRemover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnItemConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addComponent(scrollConsulta))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInserir, btnNovo});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tffData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(tfdTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdFornecedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdFornecedorNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFornecedorConsultar)
                    .addComponent(jLabel2))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfdItemID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdItemDescr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnItemConsultar)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfdQtde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnRemover)
                    .addComponent(btnInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnNovo))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (tfdItemID.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Realize uma Consulta de Item!");
        } else {
            if (tfdQtde.getText().length() == 0) {
                JOptionPane.showMessageDialog(this, "Quantidade n??o Informada!");
            } else {
                Itens_Compras itens_Compras = new Itens_Compras();

                itens_Compras.setCompra_id(idCompra);
                itens_Compras.setProduto_id(Integer.parseInt(tfdItemID.getText()));
                itens_Compras.setQtde(Double.parseDouble(tfdQtde.getText()));
                itens_Compras.setValor(Double.parseDouble(tfdValor.getText().replace(",", ".")));

                if (new Itens_ComprasDAO().salvar(itens_Compras) == null) {
                    JOptionPane.showMessageDialog(null, "Item inserido.");

                    new Itens_ComprasDAO().popularTabela(tblConsulta, "", idCompra);
                    Double calculo = itens_Compras.getValor() * itens_Compras.getQtde();
                    total = total + calculo;
                    tfdTotal.setText(String.valueOf(total));

                    Double qtdeEstoque = new ProdutosDAO().consultarQtde(Integer.parseInt(tfdItemID.getText()));
                    qtdeEstoque = qtdeEstoque + Double.parseDouble(tfdQtde.getText());

                    Produtos produtos = new Produtos();
                    produtos.setId(Integer.parseInt(tfdItemID.getText()));
                    produtos.setDescricao(tfdItemDescr.getText());
                    produtos.setQtde_estoque(qtdeEstoque);
                    produtos.setValor_unitario(Double.valueOf(tfdValor.getText().replace(",", ".")));

                    ProdutosDAO produtosDAO = new ProdutosDAO();
                    produtosDAO.atualizarQtde(produtos);

                    tfdItemID.setText("");
                    tfdItemDescr.setText("");
                    tfdValor.setText("");
                    tfdQtde.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Erro na inser????o.");
                }
            }
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Compras compras = new Compras();

        compras.setData(tffData.getText());
        compras.setFornecedor_id(Integer.parseInt(tfdFornecedorID.getText()));

        String retorno = new ComprasDAO().salvar(compras);

        System.out.println("ID Compra retorno: " + retorno);

        if (!retorno.contains("ERROR")) {
            idCompra = Integer.parseInt(retorno);

            btnNovo.setEnabled(false);
            btnFornecedorConsultar.setEnabled(false);
            btnItemConsultar.setEnabled(true);
            tfdQtde.setEditable(true);
            tblConsulta.setEnabled(true);

            btnRemover.setEnabled(true);
            btnInserir.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao criar nova Compra: " + retorno);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        if (tblConsulta.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Selecione um registro na Tabela Consulta!");
        } else {
            int idItensCompras = Integer.parseInt(String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 0)));
            int idProduto = Integer.parseInt(String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 1)));
            System.out.println("Id da Tabela: " + idItensCompras);

            if (new Itens_ComprasDAO().excluir(idItensCompras) == null) {
                JOptionPane.showMessageDialog(null, "Item exclu??do.");


                double qtde = Double.parseDouble(String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 3)));
                double valor = Double.parseDouble(String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 4)));
                double calculo = qtde * valor;
                total = total - calculo;
              
                tfdTotal.setText(String.valueOf(total));

                Double qtdeEstoque = new ProdutosDAO().consultarQtde(idProduto);
                qtdeEstoque -= qtde;

                Produtos produtos = new Produtos();
                produtos.setId(Integer.parseInt(String.valueOf(tblConsulta.getValueAt(tblConsulta.getSelectedRow(), 1))));
                produtos.setQtde_estoque(qtdeEstoque);

                ProdutosDAO produtosDAO = new ProdutosDAO();
                produtosDAO.atualizarQtde(produtos);

                new Itens_ComprasDAO().popularTabela(tblConsulta, "", idCompra);

            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void btnFornecedorConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFornecedorConsultarActionPerformed
        new DlgLocalizar(null, true, this, "fornecedor").setVisible(true);
        btnNovo.setEnabled(true);
    }//GEN-LAST:event_btnFornecedorConsultarActionPerformed

    private void btnItemConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemConsultarActionPerformed
        new DlgLocalizar(null, true, this, "item").setVisible(true);
    }//GEN-LAST:event_btnItemConsultarActionPerformed

    private void tfdQtdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdQtdeKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_tfdQtdeKeyTyped

    private void tfdValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfdValorKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdValorKeyTyped

    @Override
    public void definirValor(String[] valores, String itemPesquisa) {
        if (itemPesquisa.equalsIgnoreCase("fornecedor")) {
            tfdFornecedorID.setText(valores[0]);
            tfdFornecedorNome.setText(valores[1]);
        } else if (itemPesquisa.equalsIgnoreCase("item")) {
            tfdItemID.setText(valores[0]);
            tfdItemDescr.setText(valores[1]);
            tfdValor.setText(valores[2]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFornecedorConsultar;
    private javax.swing.JButton btnInserir;
    private javax.swing.JButton btnItemConsultar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scrollConsulta;
    private javax.swing.JTable tblConsulta;
    private javax.swing.JTextField tfdFornecedorID;
    private javax.swing.JTextField tfdFornecedorNome;
    private javax.swing.JTextField tfdItemDescr;
    private javax.swing.JTextField tfdItemID;
    private javax.swing.JTextField tfdQtde;
    private javax.swing.JTextField tfdTotal;
    private javax.swing.JTextField tfdValor;
    private javax.swing.JFormattedTextField tffData;
    // End of variables declaration//GEN-END:variables

}
