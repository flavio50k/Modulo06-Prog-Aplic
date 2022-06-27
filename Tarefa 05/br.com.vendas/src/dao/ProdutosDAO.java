/**
 * @author Flavio
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Produtos;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ProdutosDAO implements IDAOT<Produtos> {

    @Override
    public String salvar(Produtos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into produto "
                    + "values "
                    + "(default, "
                    + "'" + o.getDescricao() + "', "
                    + o.getValor_unitario() + ", "
                    + "0.0)";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar registro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Produtos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE produto "
                    + "SET "
                    + "descricao = '" + o.getDescricao() + "', "
                    + "valor_unitario = " + o.getValor_unitario() + " "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar registro: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "DELETE FROM produto "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao excluir registro: " + e);
            return e.toString();
        }
    }

    @Override
    public ArrayList<Produtos> consultarTodos() {
        ArrayList<Produtos> produtos = new ArrayList();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "select * "
                    + "from produto "
                    + "order by descricao";
            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Produtos produto = new Produtos();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
                produto.setValor_unitario(retorno.getDouble("valor_unitario"));
                produto.setQtde_estoque(retorno.getDouble("qtde_estoque"));

                produtos.add(produto);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }
        return produtos;
    }

    @Override
    public ArrayList<Produtos> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Produtos consultarId(int id) {
        Produtos produto = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "select * "
                    + "from produto "
                    + "where id = " + id;
            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                produto = new Produtos();

                produto.setId(retorno.getInt("id"));
                produto.setDescricao(retorno.getString("descricao"));
                produto.setValor_unitario(retorno.getDouble("valor_unitario"));
                produto.setQtde_estoque(retorno.getDouble("qtde_estoque"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }
        return produto;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Valor Unit.";
        cabecalho[3] = "Qtde. Estoque";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM produto "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT * "
                    + "FROM produto "
                    + "WHERE "
                    + "descricao ILIKE '%" + criterio + "%' "
                    + "ORDER BY descricao");
            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("descricao");
                dadosTabela[lin][2] = Double.toString(resultadoQ.getDouble("valor_unitario")).replace(".", ",");
                dadosTabela[lin][3] = Double.toString(resultadoQ.getDouble("qtde_estoque")).replace(".", ",");

                // caso a coluna precise exibir uma imagem
//                if (resultadoQ.getBoolean("Situacao")) {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_ativo.png"));
//                } else {
//                    dadosTabela[lin][2] = new ImageIcon(getClass().getClassLoader().getResource("Interface/imagens/status_inativo.png"));
//                }
                lin++;
            }
        } catch (Exception e) {
            System.out.println("O sistema apresentou um problema para exibir a tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
                /*  
                 if (column == 3) {  // apenas a coluna 3 sera editavel
                 return true;
                 } else {
                 return false;
                 }
                 */
            }

            // alteracao no metodo que determina a coluna em que o objeto ImageIcon devera aparecer
            @Override
            public Class getColumnClass(int column) {
                if (column == 2) {
//                    return ImageIcon.class;
                }
                return Object.class;
            }
        });

        // permite selecao de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(5);
                    break;
                case 1:
                    column.setPreferredWidth(5);
                    break;
                case 2:
                    column.setPreferredWidth(140);
                    break;
                case 3:
                    column.setPreferredWidth(30);
                    break;
                case 4:
                    column.setPreferredWidth(30);
                    break;
            }
        }
        // renderizacao das linhas da tabela = mudar a cor
//        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
//
//            @Override
//            public Component getTableCellRendererComponent(JTable table, Object value,
//                    boolean isSelected, boolean hasFocus, int row, int column) {
//                super.getTableCellRendererComponent(table, value, isSelected,
//                        hasFocus, row, column);
//                if (row % 2 == 0) {
//                    setBackground(Color.GREEN);
//                } else {
//                    setBackground(Color.LIGHT_GRAY);
//                }
//                return this;
//            }
//        });
    }

    public Double consultarQtde(int idProduto) {
        Double estoque = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "SELECT qtde_estoque "
                    + "FROM produto "
                    + "WHERE "
                    + "id = " + idProduto;
            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);
            while (retorno.next()) {
                estoque = retorno.getDouble("qtde_estoque");
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }
        return estoque;
    }

    public String atualizarQtde(Produtos o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE produto "
                    + "SET "
                    + "qtde_estoque = " + o.getQtde_estoque() + " "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao atualizar registro: " + e);
            return e.toString();
        }
    }
}
