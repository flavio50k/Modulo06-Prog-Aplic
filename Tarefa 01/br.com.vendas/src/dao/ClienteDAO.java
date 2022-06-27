/**
 * @author Flavio
 */

package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Cliente;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ClienteDAO implements IDAOT <Cliente> {

    @Override
    public String salvar(Cliente o) {
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();
            String sql = "insert into cliente "
                    + "values"
                    + "(default, "
                    + "'" + o.getNome() + "', "
                    + "'" + o.getE_mail()+ "', "
                    + "'" + o.getCpf()+ "', "
                    + "'" + o.getTelefone()+ "')";

            System.out.println("SQL: " + sql);
            
            int retorno = st.executeUpdate(sql);
            return null;
        } catch (Exception e) {
            System.out.println("Erro ao Salvar Cliente: " + e);
            return e.toString();
        }
    }

    @Override
    public String atualizar(Cliente o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Cliente> consultarTodos() {
        ArrayList<Cliente> clientes = new ArrayList();
        
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = ""
                    + "select * "
                    + "from cliente "
                    + "order by nome";

            System.out.println("SQL: " + sql);
            ResultSet retorno = st.executeQuery(sql);
          
            while (retorno.next()) {
                Cliente cliente = new Cliente();
                
                cliente.setId(retorno.getInt("id"));
                cliente.setNome(retorno.getString("nome"));
                cliente.setE_mail(retorno.getString("e_mail"));
                cliente.setCpf(retorno.getString("cpf"));
                cliente.setTelefone(retorno.getString("telefone"));
                
                clientes.add(cliente);                
            }
        } catch (Exception e) {
            System.out.println("Erro ao consultar Clientes: " + e);
        }
        return clientes;
    }

    @Override
    public ArrayList<Cliente> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cliente consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
