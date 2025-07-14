package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CelasModel;
import model.RefeicaoModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class CelasController {

    public Boolean inserir(CelasModel celas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO celas (qtde_max, qtde_atual, visita) VALUES (?,?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, celas.getQtde_max());
            sentenca.setString(2, celas.getQtde_atua());
            sentenca.setInt(3, celas.getVisita().getIdvisitas());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CelasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO INSERIR() (CelasController ln38) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(CelasModel celas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE celas SET qtde_max=?, qtde_atual=?, visita=? WHERE idcelas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, celas.getQtde_max());
            sentenca.setString(2, celas.getQtde_atua());
            sentenca.setInt(3, celas.getVisita().getIdvisitas());
            sentenca.setInt(4, celas.getIdcelas());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CelasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (CelasController ln65) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(CelasModel celas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM celas WHERE idcelas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, celas.getIdcelas());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CelasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EXCLUIR() (CelasController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public CelasModel selecionar(CelasModel celas) {

        CelasModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM celas WHERE idcelas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, celas.getIdcelas());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new CelasModel();
                retorno.setIdcelas(result.getInt("idcelas"));
                retorno.setQtde_max(result.getString("qtde_max"));
                retorno.setQtde_atua(result.getString("qtde_atual"));
                retorno.getVisita().setParentesco(result.getString("parentesco"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CelasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONAR() (CelasController ln119) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<CelasModel> selecionarTodos() {

        ArrayList<CelasModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT idcelas, qtde_max, qtde_atual, visita, visitas.parentesco FROM penitenciaria.celas, penitenciaria.visitas WHERE celas.visita = visitas.idvisitas";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {

            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {

                /*
                ResultSetMetaData meta = result.getMetaData();
                int columnCount = meta.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Coluna #" + i + " = " + meta.getColumnName(i));
                }
                 */
                CelasModel c = new CelasModel();
                c.setIdcelas(result.getInt("idcelas"));
                c.setQtde_max(result.getString("qtde_max"));
                c.setQtde_atua(result.getString("qtde_atual"));
                c.getVisita().setParentesco(result.getString("parentesco"));
                retorno_lista.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CelasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (CelasController ln153) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (CelasController ln165) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
