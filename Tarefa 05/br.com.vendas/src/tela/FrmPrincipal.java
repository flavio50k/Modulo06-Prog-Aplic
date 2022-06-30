/**
 * @author Flavio
 */
package tela;

import apoio.ConexaoBD;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class FrmPrincipal extends javax.swing.JFrame {

    public FrmPrincipal() {
        initComponents();
        setTitle("Vendas de Mercadorias");
        this.setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCadastros = new javax.swing.JMenu();
        submenuClientes = new javax.swing.JMenuItem();
        submenuFornecedores = new javax.swing.JMenuItem();
        submenuProdutos = new javax.swing.JMenuItem();
        submenuEnderecos = new javax.swing.JMenuItem();
        submenuUsuarios = new javax.swing.JMenuItem();
        menuVendas = new javax.swing.JMenu();
        submenuPedido = new javax.swing.JMenuItem();
        menuCompras = new javax.swing.JMenu();
        submenuCompra = new javax.swing.JMenuItem();
        menuRelatorios = new javax.swing.JMenu();
        submenuListaClientes = new javax.swing.JMenuItem();
        submenuListaFornecedores = new javax.swing.JMenuItem();
        submenuRelComprasFornec = new javax.swing.JMenuItem();
        submenuRelUsuarios = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();
        submenuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1152, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        menuCadastros.setText("Cadastros");

        submenuClientes.setText("Clientes");
        submenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuClientesActionPerformed(evt);
            }
        });
        menuCadastros.add(submenuClientes);

        submenuFornecedores.setText("Fornecedores");
        submenuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuFornecedoresActionPerformed(evt);
            }
        });
        menuCadastros.add(submenuFornecedores);

        submenuProdutos.setText("Produtos");
        submenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuProdutosActionPerformed(evt);
            }
        });
        menuCadastros.add(submenuProdutos);

        submenuEnderecos.setText("Endereços");
        submenuEnderecos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuEnderecosActionPerformed(evt);
            }
        });
        menuCadastros.add(submenuEnderecos);

        submenuUsuarios.setText("Usuários");
        submenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuUsuariosActionPerformed(evt);
            }
        });
        menuCadastros.add(submenuUsuarios);

        jMenuBar1.add(menuCadastros);

        menuVendas.setText("Vendas");

        submenuPedido.setText("Pedido");
        submenuPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuPedidoActionPerformed(evt);
            }
        });
        menuVendas.add(submenuPedido);

        jMenuBar1.add(menuVendas);

        menuCompras.setText("Compras");

        submenuCompra.setText("Compra");
        submenuCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuCompraActionPerformed(evt);
            }
        });
        menuCompras.add(submenuCompra);

        jMenuBar1.add(menuCompras);

        menuRelatorios.setText("Relatórios");

        submenuListaClientes.setText("Lista de Clientes");
        submenuListaClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuListaClientesActionPerformed(evt);
            }
        });
        menuRelatorios.add(submenuListaClientes);

        submenuListaFornecedores.setText("Lista de Fornecedores");
        submenuListaFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuListaFornecedoresActionPerformed(evt);
            }
        });
        menuRelatorios.add(submenuListaFornecedores);

        submenuRelComprasFornec.setText("Compras por Fornecedor");
        submenuRelComprasFornec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRelComprasFornecActionPerformed(evt);
            }
        });
        menuRelatorios.add(submenuRelComprasFornec);

        submenuRelUsuarios.setText("Usuários");
        submenuRelUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuRelUsuariosActionPerformed(evt);
            }
        });
        menuRelatorios.add(submenuRelUsuarios);

        jMenuBar1.add(menuRelatorios);

        menuAjuda.setText("Ajuda");

        submenuSair.setText("Sair");
        submenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenuSairActionPerformed(evt);
            }
        });
        menuAjuda.add(submenuSair);

        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuClientesActionPerformed
        IfrClientes ifrClientes = new IfrClientes();
        jDesktopPane1.add(ifrClientes);
        ifrClientes.setVisible(true);
    }//GEN-LAST:event_submenuClientesActionPerformed

    private void submenuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuFornecedoresActionPerformed
        IfrFornecedores ifrFornecedores = new IfrFornecedores();
        jDesktopPane1.add(ifrFornecedores);
        ifrFornecedores.setVisible(true);
    }//GEN-LAST:event_submenuFornecedoresActionPerformed

    private void submenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuProdutosActionPerformed
        IfrProdutos ifrProdutos = new IfrProdutos();
        jDesktopPane1.add(ifrProdutos);
        ifrProdutos.setVisible(true);
    }//GEN-LAST:event_submenuProdutosActionPerformed

    private void submenuEnderecosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuEnderecosActionPerformed
        IfrEnderecos ifrEnderecos = new IfrEnderecos();
        jDesktopPane1.add(ifrEnderecos);
        ifrEnderecos.setVisible(true);
    }//GEN-LAST:event_submenuEnderecosActionPerformed

    private void submenuPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submenuPedidoActionPerformed

    private void submenuCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuCompraActionPerformed
        IfrCompras ifrCompras = new IfrCompras();
        jDesktopPane1.add(ifrCompras);
        ifrCompras.setVisible(true);
    }//GEN-LAST:event_submenuCompraActionPerformed

    private void submenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_submenuSairActionPerformed

    private void submenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuUsuariosActionPerformed
        IfrUsuarios ifrUsuarios = new IfrUsuarios();
        jDesktopPane1.add(ifrUsuarios);
        ifrUsuarios.setVisible(true);
    }//GEN-LAST:event_submenuUsuariosActionPerformed

    private void submenuListaClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuListaClientesActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/ListaClientes.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_submenuListaClientesActionPerformed

    private void submenuListaFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuListaFornecedoresActionPerformed
        try {
            // Compila o relatorio
            JasperReport relatorio = JasperCompileManager.compileReport(getClass().getResourceAsStream("/relatorios/ListaFornecedores.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map parametros = new HashMap();

            // Executa relatoio
            JasperPrint impressao = JasperFillManager.fillReport(relatorio, parametros, ConexaoBD.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(impressao, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_submenuListaFornecedoresActionPerformed

    private void submenuRelComprasFornecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRelComprasFornecActionPerformed
        DlgRelCompras dlgRelCompras = new DlgRelCompras(this, true);
        dlgRelCompras.setVisible(true);
    }//GEN-LAST:event_submenuRelComprasFornecActionPerformed

    private void submenuRelUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenuRelUsuariosActionPerformed
        DlgRelUsuarios dlgRelUsuarios = new DlgRelUsuarios(this, true);
        dlgRelUsuarios.setVisible(true);
    }//GEN-LAST:event_submenuRelUsuariosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuCadastros;
    private javax.swing.JMenu menuCompras;
    private javax.swing.JMenu menuRelatorios;
    private javax.swing.JMenu menuVendas;
    private javax.swing.JMenuItem submenuClientes;
    private javax.swing.JMenuItem submenuCompra;
    private javax.swing.JMenuItem submenuEnderecos;
    private javax.swing.JMenuItem submenuFornecedores;
    private javax.swing.JMenuItem submenuListaClientes;
    private javax.swing.JMenuItem submenuListaFornecedores;
    private javax.swing.JMenuItem submenuPedido;
    private javax.swing.JMenuItem submenuProdutos;
    private javax.swing.JMenuItem submenuRelComprasFornec;
    private javax.swing.JMenuItem submenuRelUsuarios;
    private javax.swing.JMenuItem submenuSair;
    private javax.swing.JMenuItem submenuUsuarios;
    // End of variables declaration//GEN-END:variables
}
