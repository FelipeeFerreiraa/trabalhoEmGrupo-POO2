package model;

/**
 *
 * @author felip
 */
public class CrimesModel {

    //--------- VARIAVEIS
    private int idcrimes;
    private String descricao, data_cometido;

    //--------- CONSTRUTORES
    public CrimesModel() {
        this.idcrimes = 0;
        this.descricao = "";
        this.data_cometido = "";
    }

    public CrimesModel(int idcrimes, String descricao, String data_cometido) {
        this.idcrimes = idcrimes;
        this.descricao = descricao;
        this.data_cometido = data_cometido;
    }

    //--------- GETs
    public int getIdcrimes() {
        return idcrimes;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_cometido() {
        return data_cometido;
    }

    //--------- SETs
    public void setIdcrimes(int idcrimes) {
        this.idcrimes = idcrimes;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData_cometido(String data_cometido) {
        this.data_cometido = data_cometido;
    }

    //--------- METODOS
}
