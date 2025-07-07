package model;

/**
 *
 * @author felip
 */
public class CelasModel {

    //--------- VARIAVEIS
    private int idcelas;
    private String qtde_max, qtde_atua;
    private VisitasModel visita;

    //--------- CONSTRUTORES
    public CelasModel() {
        this.idcelas = 0;
        this.qtde_max = "";
        this.qtde_atua = "";
        this.visita = new VisitasModel();
    }

    public CelasModel(int idcelas, String qtde_max, String qtde_atua, VisitasModel visita) {
        this.idcelas = idcelas;
        this.qtde_max = qtde_max;
        this.qtde_atua = qtde_atua;
        this.visita = visita;
    }

    //--------- GETs
    public int getIdcelas() {
        return idcelas;
    }

    public String getQtde_max() {
        return qtde_max;
    }

    public String getQtde_atua() {
        return qtde_atua;
    }

    public VisitasModel getVisita() {
        return visita;
    }

    //--------- SETs
    public void setIdcelas(int idcelas) {
        this.idcelas = idcelas;
    }

    public void setQtde_max(String qtde_max) {
        this.qtde_max = qtde_max;
    }

    public void setQtde_atua(String qtde_atua) {
        this.qtde_atua = qtde_atua;
    }

    public void setVisita(VisitasModel visita) {
        this.visita = visita;
    }

    //--------- METODOS
}
