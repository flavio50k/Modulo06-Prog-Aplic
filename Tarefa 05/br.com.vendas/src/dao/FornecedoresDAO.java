/**
 * @author Flavio
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Fornecedores;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FornecedoresDAO implements IDAOT<Fornecedores> {

    @Override
    public String salvar(Fornecedores o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into fornecedor "
                    + "values "
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getTelefone() + "', "
                    + "'" + o.getCnpj() + "')";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao salvar registro: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Fornecedores o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE fornecedor "
                    + "SET "
                    + "nome = '" + o.getNome() + "', "
                    + "e_mail = '" + o.getEmail() + "', "
                    + "telefone = '" + o.getTelefone() + "', "
                    + "cnpj = '" + o.getCnpj() + "' "
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
            String sql = "DELETE FROM fornecedor "
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
    public ArrayList<Fornecedores> consultarTodos() {
        ArrayList<Fornecedores> fornecedores = new ArrayList();
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "select * "
                    + "from fornecedor "
                    + "order by nome";
            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                Fornecedores fornecedor = new Fornecedores();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("e_mail"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));

                fornecedores.add(fornecedor);
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }
        return fornecedores;
    }

    @Override
    public ArrayList<Fornecedores> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Fornecedores consultarId(int id) {
        Fornecedores fornecedor = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "select * "
                    + "from fornecedor "
                    + "where id = " + id;
            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                fornecedor = new Fornecedores();

                fornecedor.setId(retorno.getInt("id"));
                fornecedor.setNome(retorno.getString("nome"));
                fornecedor.setEmail(retorno.getString("e_mail"));
                fornecedor.setTelefone(retorno.getString("telefone"));
                fornecedor.setCnpj(retorno.getString("cnpj"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }
        return fornecedor;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[5];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Email";
        cabecalho[3] = "Telefone";
        cabecalho[4] = "CNPJ";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM fornecedor "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][5];

        } catch (Exception e) {
            System.out.println("Erro ao consultar registros: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT id, nome, e_mail, telefone, cnpj "
                    + "FROM fornecedor "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");
            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("e_mail");
                dadosTabela[lin][3] = resultadoQ.getString("telefone");
                dadosTabela[lin][4] = resultadoQ.getString("cnpj");

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
                    column.setPreferredWidth(140);
                    break;
                case 2:
                    column.setPreferredWidth(140);
                    break;
                case 3:
                    column.setPreferredWidth(60);
                    break;
                case 4:
                    column.setPreferredWidth(60);
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
}
