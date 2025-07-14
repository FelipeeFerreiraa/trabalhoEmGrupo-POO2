package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CelasModel;
import model.IPLModel;
import util.Conexao;

/**
 *
 * @author felip
 */
public class IPLController {

    public Boolean inserir(IPLModel ipl) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "INSERT INTO ipl (nome, cpf, crime, parentesco, refeicao, policial) VALUES (?,?,?,?,?,?)";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, ipl.getIpl_nome());
            sentenca.setString(2, ipl.getIpl_cpf());
            sentenca.setInt(3, ipl.getCrime().getIdcrimes());
            sentenca.setInt(4, ipl.getParentesco().getIdvisitas());
            sentenca.setInt(5, ipl.getRefeicao().getIdrefeicao());
            sentenca.setInt(6, ipl.getPolicial().getIdpolicialpenal());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(IPLController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "------------------------------------- ERRO AO INSERIR() (IPLController ln38) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean editar(IPLModel ipl) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "UPDATE celas SET nome=?, cpf=?, crime=?, parentesco=?, refeicao=?, policial=? WHERE idipl=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setString(1, ipl.getIpl_nome());
            sentenca.setString(2, ipl.getIpl_cpf());
            sentenca.setInt(3, ipl.getCrime().getIdcrimes());
            sentenca.setInt(4, ipl.getParentesco().getIdvisitas());
            sentenca.setInt(5, ipl.getRefeicao().getIdrefeicao());
            sentenca.setInt(6, ipl.getPolicial().getIdpolicialpenal());
            sentenca.setInt(7, ipl.getIdipl());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(IPLController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "------------------------------------- ERRO AO EDITAR() (IPLController ln72) -------------------------------------)");
        }

        Conexao.desconectar();
        return retorno;
    }

    public Boolean excluir(IPLModel ipl) {

        boolean retorno = false;

        Conexao.conectar();
        String sql = "DELETE FROM ipl WHERE idipl=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, ipl.getIdipl());

            if (!sentenca.execute()) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(IPLController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "------------------------------------- ERRO AO EXCLUIR() (IPLController ln65) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public IPLModel selecionar(IPLModel ipl) {

        IPLModel retorno = null;

        Conexao.conectar();
        String sql = "SELECT * FROM ipl WHERE idipl=?";

        try {
            PreparedStatement sentenca = Conexao.conector.prepareStatement(sql);
            sentenca.setInt(1, ipl.getIdipl());
            ResultSet result = sentenca.executeQuery();

            if (result.next()) {
                retorno = new IPLModel();
                retorno.setIdipl(result.getInt("idipl"));
                retorno.setIpl_nome(result.getString("nome"));
                retorno.setIpl_cpf(result.getString("cpf"));
                retorno.getCrime().setDescricao(result.getString("descricao"));
                retorno.getParentesco().setParentesco(result.getString("parentesco"));
                retorno.getRefeicao().setComida(result.getString("comida"));
                retorno.getPolicial().setNome(result.getString("pp_nome"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(IPLController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "------------------------------------- ERRO AO SELECIONAR() (IPLController ln129) -------------------------------------)");

        }

        Conexao.desconectar();
        return retorno;
    }

    public ArrayList<IPLModel> selecionarTodos() {

        ArrayList<IPLModel> retorno_lista = new ArrayList<>();
        Conexao.conectar();
        String sql = "SELECT i.idipl, i.nome, i.cpf, c.descricao, v.parentesco, r.comida, p.pp_nome FROM ipl i INNER JOIN crimes c ON i.crime = c.idcrimes INNER JOIN visitas v ON i.parentesco = v.idvisitas INNER JOIN refeicao r ON i.refeicao = r.idrefeicao INNER JOIN policialpenal p ON i.policial = p.idpolicialPenal";

        ResultSet result = null;
        PreparedStatement sentenca = null;

        try {

            sentenca = Conexao.conector.prepareStatement(sql);
            result = sentenca.executeQuery();
            while (result.next()) {

                ResultSetMetaData meta = result.getMetaData();
                int columnCount = meta.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Coluna #" + i + " = " + meta.getColumnName(i));
                }

                IPLModel i = new IPLModel();

                i.setIdipl(result.getInt("idipl"));
                i.setIpl_nome(result.getString("nome"));
                i.setIpl_cpf(result.getString("cpf"));
                i.getCrime().setDescricao(result.getString("descricao"));
                i.getParentesco().setParentesco(result.getString("parentesco"));
                i.getRefeicao().setComida(result.getString("comida"));
                i.getPolicial().setNome(result.getString("pp_nome"));
                retorno_lista.add(i);
            }

        } catch (SQLException ex) {
            Logger.getLogger(IPLController.class
                    .getName()).log(Level.SEVERE, null, ex);
            System.out.println(
                    "------------------------------------- ERRO AO SELECIONATODOS() (IPLController ln173) -------------------------------------)");

        } finally {
            try {
                if (result != null) {
                    result.close();
                }

                if (sentenca != null) {
                    sentenca.close();
                }
            } catch (SQLException e) {
                System.out.println(
                        "------------------------------------- ERRO AO SELECIONATODOS() (IPLController ln185) -------------------------------------)");

            }
        }

        Conexao.desconectar();
        return retorno_lista;
    }

}
