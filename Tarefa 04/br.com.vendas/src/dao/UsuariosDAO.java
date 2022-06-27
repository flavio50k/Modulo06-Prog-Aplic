/**
 * @author Flavio
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import apoio.BCrypt;
import entidade.Usuarios;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class UsuariosDAO implements IDAOT<Usuarios> {

    @Override
    public String salvar(Usuarios o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into usuario "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getEmail() + "', "
                    + "'" + o.getSenha() + "', "
                    + "'" + o.getSituacao() + "')";

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Usuarios o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE usuario "
                    + "SET "
                    + "nome = '" + o.getNome() + "', "
                    + "email = '" + o.getEmail() + "', "
                    + "senha = '" + o.getSenha() + "', "
                    + "situacao = '" + o.getSituacao() + "' "
                    + "WHERE id = " + o.getId();

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuarios> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Usuarios> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuarios consultarId(int id) {
        Usuarios usuarios = null;
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = ""
                    + "select * "
                    + "from usuario "
                    + "where id = " + id;
            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);

            while (retorno.next()) {
                usuarios = new Usuarios();

                usuarios.setId(retorno.getInt("id"));
                usuarios.setNome(retorno.getString("nome"));
                usuarios.setEmail(retorno.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Cliente: " + e);
        }
        return usuarios;
    }

    public void popularTabela(JTable tabela, String criterio) {

        ResultSet resultadoQ;

        // dados da tabela
        Object[][] dadosTabela = null;

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Código";
        cabecalho[1] = "Nome";
        cabecalho[2] = "E-mail";
        cabecalho[3] = "Situação";

        // cria matriz de acordo com nº de registros da tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT count(*) "
                    + "FROM usuario "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%'");

            resultadoQ.next();

            dadosTabela = new Object[resultadoQ.getInt(1)][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar Endereços: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
            resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(""
                    + "SELECT id, nome, email, situacao "
                    + "FROM usuario "
                    + "WHERE "
                    + "nome ILIKE '%" + criterio + "%' "
                    + "ORDER BY nome");
            while (resultadoQ.next()) {

                dadosTabela[lin][0] = resultadoQ.getInt("id");
                dadosTabela[lin][1] = resultadoQ.getString("nome");
                dadosTabela[lin][2] = resultadoQ.getString("email");
                if (resultadoQ.getString("situacao").equalsIgnoreCase("a")) {
                    dadosTabela[lin][3] = "Ativo";
                } else {
                    dadosTabela[lin][3] = "Inativo";
                }
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

    public boolean autenticar(Usuarios u) {
        try {
            String sql
                    = "SELECT email, senha "
                    + "FROM usuario "
                    + "WHERE "
                    + "email = '" + u.getEmail() + "' and "
                    + "situacao = 'a'";
            ResultSet resultadoQ = ConexaoBD.getInstance().getConnection().createStatement().executeQuery(sql);

            System.out.println("SQL..........: " + sql);

            if (resultadoQ.next()) {
                String test_passwd = u.getSenha();
                String test_hash = resultadoQ.getString("senha");

                Boolean compare_test = BCrypt.checkPassword(test_passwd, test_hash);
                if (compare_test == true) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Erro ao autenticar usuário: " + e);
            return false;
        }
    }

    public String desbloquear(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE usuario "
                    + "SET situacao = 'a' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Excluir Endereço: " + e);
            return e.toString();
        }
    }
    
    public String bloquear(int id) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "UPDATE usuario "
                    + "SET situacao = 'i' "
                    + "WHERE id = " + id;

            System.out.println("SQL: " + sql);
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Bloquear Usuário: " + e);
            return e.toString();
        }
    }
}
