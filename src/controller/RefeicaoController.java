package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CrimesModel;
import model.RefeicaoModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class RefeicaoController {

    public Boolean inserir(RefeicaoModel refeicao) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO refeicao (comida, dia_semana, horario) VALUES (?,?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, refeicao.getComida());
            sentenca.setString(2, refeicao.getDia_semana());
            sentenca.setString(3, refeicao.getHorario());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO INSERIR() (RefeicaoController ln38) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(RefeicaoModel refeicao) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE refeicao SET comida=?, dia_semana=?, horario=? WHERE idrefeicao=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, refeicao.getComida());
            sentenca.setString(2, refeicao.getDia_semana());
            sentenca.setString(3, refeicao.getHorario());
            sentenca.setInt(4, refeicao.getIdrefeicao());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EDITAR() (RefeicaoController ln65) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(RefeicaoModel refeicao) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM refeicao WHERE idrefeicao=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, refeicao.getIdrefeicao());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO EXCLUIR() (RefeicaoController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public RefeicaoModel selecionar(RefeicaoModel refeicao) {

        RefeicaoModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM refeicao WHERE idrefeicao=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, refeicao.getIdrefeicao());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new RefeicaoModel();
                retorno.setIdrefeicao(result.getInt("idrefeicao"));
                retorno.setComida(result.getString("comida"));
                retorno.setDia_semana(result.getString("dia_semana"));
                retorno.setHorario(result.getString("horario"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONAR() (RefeicaoController ln119) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<RefeicaoModel> selecionarTodos() {

        ArrayList<RefeicaoModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT * FROM refeicao";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {
            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {
                RefeicaoModel r = new RefeicaoModel();
                r.setIdrefeicao(result.getInt("idrefeicao"));
                r.setComida(result.getString("comida"));
                r.setDia_semana(result.getString("dia_semana"));
                r.setHorario(result.getString("horario"));
                retorno_lista.add(r);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RefeicaoController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (RefeicaoController ln153) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println("------------------------------------- ERRO AO SELECIONATODOS() (RefeicaoController ln165) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
