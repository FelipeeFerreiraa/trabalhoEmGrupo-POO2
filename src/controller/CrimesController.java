package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CrimesModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class CrimesController {

    public Boolean inserir(CrimesModel crimes) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO crimes (descricao, data_cometido) VALUES (?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, crimes.getDescricao());
            sentenca.setString(2, crimes.getData_cometido());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrimesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO INSERIR() (CrimesController ln37) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(CrimesModel crimes) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE crimes SET descricao=?, data_cometido=? WHERE idcrimes=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, crimes.getDescricao());
            sentenca.setString(2, crimes.getData_cometido());
            sentenca.setInt(3, crimes.getIdcrimes());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrimesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (CrimesController ln65) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(CrimesModel crimes) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM crimes WHERE idcrimes=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, crimes.getIdcrimes());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrimesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EXCLUIR() (CrimesController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public CrimesModel selecionar(CrimesModel crimes) {

        CrimesModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM crimes WHERE idcrimes=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, crimes.getIdcrimes());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new CrimesModel();
                retorno.setIdcrimes(result.getInt("idcrimes"));
                retorno.setDescricao(result.getString("descricao"));
                retorno.setData_cometido(result.getString("data_cometido"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrimesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONAR() (CrimesController ln116) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<CrimesModel> selecionarTodos() {

        ArrayList<CrimesModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT * FROM crimes";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {
            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {
                CrimesModel pp = new CrimesModel();
                pp.setIdcrimes(result.getInt("idcrimes"));
                pp.setDescricao(result.getString("descricao"));
                pp.setData_cometido(result.getString("data_cometido"));
                retorno_lista.add(pp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CrimesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (CrimesController ln153) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (CrimesController ln165) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
