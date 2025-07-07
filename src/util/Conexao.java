package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class Conexao {

    public static Connection conector;

    public Statement stm; // RESPONSAVEL POR PREPARAR E REALIZAR PESQUISAS NO BANCO DE DADOS
    public ResultSet rs; // RESPONSAVEL POR ARMAZENAR O RESULTADO DE UMA PESQUISA PASSADA PARA O STATEMENT

    public static void conectar() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:/vendas";
            String usuario = "root";
            String senha = "admadm";

            try {
                conector = DriverManager.getConnection(url, usuario, senha);
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro do Driver..... (Conexao ln34) ");
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro do Driver..... (Conexao ln39) ");
        }
    }

    public static void desconectar() {
        try {
            conector.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão! (Conexao ln46)" + e.getMessage());
        }
    }

}
