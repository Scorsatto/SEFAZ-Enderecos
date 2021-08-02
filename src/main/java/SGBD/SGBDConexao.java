/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SGBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fabiano Rodrigo Scorsatto
 */
public class SGBDConexao {
    
    private Connection conexao = null;
    private String banco = "jjjMySQL";

    // Cria conexão com o banco de dados
    public Connection Conectar() {
        
        if (banco.equals("MySQL")) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost/enderecos_sefaz", "root", "?RKU}Yux");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection("jdbc:sqlite:enderecos_sefaz.db3");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        
        return conexao;
    }
}
