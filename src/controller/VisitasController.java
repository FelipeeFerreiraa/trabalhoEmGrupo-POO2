package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.VisitasModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class VisitasController {

    public Boolean inserir(VisitasModel visitas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO visitas (parentesco, data_visita, presente) VALUES (?,?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, visitas.getParentesco());
            sentenca.setString(2, visitas.getData_visita());
            sentenca.setString(3, visitas.getPresente());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO INSERIR() (VisitasController ln38) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(VisitasModel visitas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE visitas SET parentesco=?, data_visita=?, presente=? WHERE idvisitas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, visitas.getParentesco());
            sentenca.setString(2, visitas.getData_visita());
            sentenca.setString(3, visitas.getPresente());
            sentenca.setInt(4, visitas.getIdvisitas());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (VisitasController ln65) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(VisitasModel visitas) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM visitas WHERE idvisitas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, visitas.getIdvisitas());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EXCLUIR() (VisitasController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public VisitasModel selecionar(VisitasModel visitas) {

        VisitasModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM visitas WHERE isvisitas=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, visitas.getIdvisitas());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new VisitasModel();
                retorno.setIdvisitas(result.getInt("idvisitas"));
                retorno.setParentesco(result.getString("parentesco"));
                retorno.setData_visita(result.getString("data_visita"));
                retorno.setPresente(result.getString("presente"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONAR() (VisitasController ln119) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<VisitasModel> selecionarTodos() {

        ArrayList<VisitasModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT * FROM visitas";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {
            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {
                VisitasModel v = new VisitasModel();
                v.setIdvisitas(result.getInt("idvisitas"));
                v.setParentesco(result.getString("parentesco"));
                v.setData_visita(result.getString("data_visita"));
                v.setPresente(result.getString("presente"));
                retorno_lista.add(v);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitasController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (VisitasController ln153) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (VisitasController ln165) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
