/**
 * @author Flavio
 */
package dao;

import apoio.ConexaoBD;
import apoio.IDAOT;
import entidade.Compras;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ComprasDAO implements IDAOT <Compras> {

    @Override
    public String salvar(Compras o) {
        String retornoConsulta = "";
        try {
            Statement st = ConexaoBD.getInstance().getConnection().createStatement();

            String sql = "insert into compra "
                    + "values"
                    + "(default, "
                    + "'" + o.getData() + "', "
                    + "" + o.getFornecedor_id() + ") returning id";

            System.out.println("SQL: " + sql);

            ResultSet retorno = st.executeQuery(sql);

            if (retorno.next()) 
                retornoConsulta = retorno.getString(1);
 
        } catch (Exception e) {
            System.out.println("Erro ao inserir Compra: " + e);
            retornoConsulta = "ERROR:" + e.toString();
        }
        return retornoConsulta;
    }

    @Override
    public String atualizar(Compras o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compras> consultarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Compras> consultar(String criterio) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compras consultarId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
