package model;

/**
 *
 * @author felip
 */
public class VisitasModel {

    //--------- VARIAVEIS
    private int idvisitas;
    private String parentesco, data_visita, presente;

    //--------- CONSTRUTORES
    public VisitasModel() {
        this.idvisitas = 0;
        this.parentesco = "";
        this.data_visita = "";
        this.presente = "";
    }

    public VisitasModel(int idvisitas, String parentesco, String data_visita, String presente) {
        this.idvisitas = idvisitas;
        this.parentesco = parentesco;
        this.data_visita = data_visita;
        this.presente = presente;
    }

    //--------- GETs
    public int getIdvisitas() {
        return idvisitas;
    }

    public String getParentesco() {
        return parentesco;
    }

    public String getData_visita() {
        return data_visita;
    }

    public String getPresente() {
        return presente;
    }

    //--------- SETs
    public void setIdvisitas(int idvisitas) {
        this.idvisitas = idvisitas;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public void setData_visita(String data_visita) {
        this.data_visita = data_visita;
    }

    public void setPresente(String presente) {
        this.presente = presente;
    }

    //--------- METODOS
}
