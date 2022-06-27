 /**
 * @author Flavio
 */
package main;

import java.sql.*;
import tela.DlgLogin;

public class Vendas {
    static Connection conexao = null;
    
    public static void main(String[] args) {
        new DlgLogin(null, true).setVisible(true);
    }
}
 