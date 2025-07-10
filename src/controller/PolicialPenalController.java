package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.PolicialPenalModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class PolicialPenalController {

    public Boolean inserir(PolicialPenalModel policial) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO policialpenal (pp_cpf, pp_nome, pp_turno_entrada, pp_turno_saida) VALUES (?,?,?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, policial.getCpf());
            sentenca.setString(2, policial.getNome());
            sentenca.setString(3, policial.getTurno_entrada());
            sentenca.setString(4, policial.getTurno_saida());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO INSERIR() (PolicialPenalController ln37) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(PolicialPenalModel policial) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE policialpenal SET pp_nome=?, pp_cpf=?, pp_turno_entrada=?, pp_turno_saida=? WHERE idpolicialPenal=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, policial.getNome());
            sentenca.setString(2, policial.getCpf());
            sentenca.setString(3, policial.getTurno_entrada());
            sentenca.setString(4, policial.getTurno_saida());
            sentenca.setInt(5, policial.getIdpolicialpenal());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (PolicialPenalController ln65) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(int idPolicial) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE policialpenal SET status=0 WHERE idpolicialPenal=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, String.valueOf(idPolicial));

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR1() (PolicialPenalController ln90) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(PolicialPenalModel policial) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM policialpenal WHERE idpolicialPenal=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, policial.getIdpolicialpenal());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (PolicialPenalController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public PolicialPenalModel selecionar(PolicialPenalModel policial) {

        PolicialPenalModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM policialpenal WHERE idpolicialPenal=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, policial.getIdpolicialpenal());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new PolicialPenalModel();
                retorno.setIdpolicialpenal(result.getInt("idpolicialPenal"));
                retorno.setNome(result.getString("pp_nome"));
                retorno.setCpf(result.getString("pp_cpf"));
                retorno.setTurno_entrada(result.getString("pp_turno_entrada"));
                retorno.setTurno_saida(result.getString("pp_turno_saida"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONA() (PolicialPenalController ln121) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<PolicialPenalModel> selecionarTodos() {

        ArrayList<PolicialPenalModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT * FROM policialpenal WHERE status = 1";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {
            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {
                PolicialPenalModel pp = new PolicialPenalModel();
                pp.setIdpolicialpenal(result.getInt("idpolicialPenal"));
                pp.setCpf(result.getString("pp_cpf"));
                pp.setNome(result.getString("pp_nome"));
                pp.setTurno_entrada(result.getString("pp_turno_entrada"));
                pp.setTurno_saida(result.getString("pp_turno_saida"));
                retorno_lista.add(pp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PolicialPenalController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (PolicialPenalController ln153) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (PolicialPenalController ln165) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
